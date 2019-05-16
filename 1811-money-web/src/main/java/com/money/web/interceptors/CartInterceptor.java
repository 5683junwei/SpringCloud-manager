package com.money.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.money.common.config.HttpClientService;
import com.money.common.pojo.User;
import com.money.common.util.CookieUtils;
import com.money.common.util.OUtil;


@Component
public class CartInterceptor implements HandlerInterceptor{
	@Autowired
	private HttpClientService client;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ticket = CookieUtils.getCookieValue(request, "JT_TICKET");
		if (StringUtils.isNotEmpty(ticket)) {// 至少曾经登陆过
			// 发起代码的跨域请求sso.jt.com/user/query/ticket
			// String url="http://sso.jt.com"+ "/user/query/"+ticket;
			//String url = "http://localhost:9000/api-d/query?ticket=" + ticket;
			String url = "http://manage.money.com/api-d/query?ticket=" + ticket;
			String userJson = client.doGet(url);
			// 判断userJson是否为空
			System.out.println("判断userjson是否为空");

			if (StringUtils.isNotEmpty(userJson)) {// 不为空
				// 登录有效
				// 将数据userId放到request域中,放行
				User user = OUtil.mapper.readValue(userJson, User.class);
				// 拿到用户的风险评分
				String userNum = user.getUserNum();
				request.getSession().setAttribute("userId", user.getUserId());
				System.out.println("userjson:"+userJson);
				if (userNum != null) {
					
					return true;
				} else {
					System.out.println("答题");
					// 登录的用户没有风险评分
					response.sendRedirect("/page/question");
					
					return false;
				}
			}	
			System.out.println("没有拿到userJson");
			response.sendRedirect("/page/login");
			return false;	
		}
		// 任何一个if没进去，说明登录失效的
		// 跳转登录页面
		response.sendRedirect("/page/login");
		return false;	
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
