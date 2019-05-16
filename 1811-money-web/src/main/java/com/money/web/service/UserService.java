package com.money.web.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.money.common.config.HttpClientService;
import com.money.common.pojo.User;
import com.money.common.util.CookieUtils;
import com.money.common.util.MD5Util;
import com.money.common.util.OUtil;
import com.money.common.vo.HttpResult;
import com.money.common.vo.SysResult;

import redis.clients.jedis.JedisCluster;

@Service
public class UserService {
	@Autowired
	private HttpClientService client;

	public boolean checkUsername(String userName) {
		// 按照接口文件，发送数据给sso
		//String url = "http://localhost:9000/api-c/check?userName="+userName;
		String url = "http://manage.money.com/api-c/check?userName="+userName;
		try {// 没有额外参数，直接get请求
			String exists = client.doGet(url);// 1/0
			int status = Integer.parseInt(exists);
			// return SysResult.build(status, "查询完毕");
			return status == 0 ? false : true;
		} catch (Exception e) {
			// 异常表示查询失败
			// return SysResult.build(1,e.getMessage());
			return false;
		}
	}
	@Autowired
	private JedisCluster cluster;	
	public int saveUser(User user) throws Exception {
		// 将user封装为httpclient的参数
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", user.getUserName());
		map.put("userEmail", user.getUserEmail());
		map.put("userPassword", user.getUserPassword());
		map.put("userGender", user.getUserGender());
		System.out.println(map.toString());
		// post地址
		// String url="http://sso.jt.com/user/register";
		//String url = "http://localhost:9000/api-a/register";
		String url = "http://manage.money.com/api-a/register";
		HttpResult result = client.doPost(url, map);// body的值		
		
		int success = Integer.parseInt(result.getBody());		
		System.out.println(success+"=============");
		return success;
	}
	
	
	public String doLogin(User user){
		//按照接口文件,发送数据,接收数据
		//String url="http://localhost:9000/api-b/login";
		String url="http://manage.money.com/api-b/login";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userName", user.getUserName());
		map.put("userPassword", user.getUserPassword());
		try{
			//httpResult的body就是sso返回的ticket,redis的key值
			String ticket=client.doPost(url, map).getBody();
			return ticket;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}		
	}	
	
	
	public String setNum(String num,String userId,String ticket) {				
		//String url="http://localhost:9000/api-e/setnum?userNum="+num+"&userId="+userId+"&ticket="+ticket;	
		String url="http://manage.money.com/api-e/setnum?userNum="+num+"&userId="+userId+"&ticket="+ticket;	
		try{
			String result = client.doGet(url);// body的值		
			return result;
		}catch(Exception e){
			return "";
		}		
	}
}
