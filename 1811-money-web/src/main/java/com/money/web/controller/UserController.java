package com.money.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.money.common.pojo.User;
import com.money.common.util.CookieUtils;
import com.money.common.vo.SysResult;
import com.money.web.service.UserService;




@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//完成username校验,是否存在
	@RequestMapping("user/checkUserName")
	@ResponseBody
	public boolean checkUsername(@RequestParam(value="userName")String userName){
		//调用service,处理数据,查询结果返回SysResult对象
		//status=0表示userName不存在,=1表示存在
		System.out.println(userName);
		boolean result=userService.checkUsername(userName);
		//System.out.println(result);
		return result;
	}
	
	//表单提交数据新增
	@RequestMapping("user_ajax/regist")
	@ResponseBody
	public SysResult saveUser(User user){
		try{
			int success=userService.saveUser(user);
			//返回的数据处理新增rows=1
			if(success==1){//新增成功
			return SysResult.build(1, "");
			}
			return SysResult.build(2, "新增用户失败");
		}catch(Exception e){
			e.printStackTrace();
			return SysResult.build(2, e.getMessage());
		}		
	
	}
	//登录
	@RequestMapping("user_ajax/login")
	@ResponseBody
	public SysResult doLogin(User user,HttpServletRequest request,
			HttpServletResponse response){
		//拿到user数据，userName/userPassword
		String ticket=userService.doLogin(user);
		//判断是否为空       
		if(StringUtils.isNotEmpty(ticket)){
			//非空说明登录成功，需要将ticket存储到cookie响应回页面
			//cookie的名称叫做JT_TICKET值就是ticket
			CookieUtils.setCookie(request,response,"JT_TICKET",ticket);
			System.out.println("==========================");
			HttpSession session = request.getSession();
			System.out.println("我现在要从session中拿user的数据了"+user.getUserName());
			
			session.setAttribute("userName", user.getUserName());
			
			return SysResult.build(1,"ok");//登录成功
		}else{//说明ticket为空，说明登录失败
			return SysResult.build(0,"登录失败");			
		}
		
	
	}
	//注销逻辑
	@RequestMapping("user_ajax/logout")
	public String logout(HttpSession session){
		//会话没有断开情况下,session对象是同一个
		session.removeAttribute("userName");
		session.removeAttribute("userId");
		return "index";
	}
	
	@RequestMapping("user_ajax/usernum")	
	public String setNum(HttpServletRequest request,String num,String userId){
		//从cookie中拿到ticket----->MD5加密过的JT_TICKET+当前时间+唯一的userName
		String ticket=CookieUtils.getCookieValue(request,"JT_TICKET");
		String result=userService.setNum(num,userId,ticket);		
		return "index";
	}
}












































