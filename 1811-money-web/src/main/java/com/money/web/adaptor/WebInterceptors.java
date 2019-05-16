package com.money.web.adaptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.money.web.interceptors.CartInterceptor;
import com.money.web.interceptors.OrderInterceptor;
import com.money.web.interceptors.ProductInterceptor;
import com.money.web.interceptors.SeckillInterceptor;


@Component
public class WebInterceptors extends WebMvcConfigurerAdapter{
	@Autowired
	private CartInterceptor ci;
	@Autowired
	private OrderInterceptor oi;
	@Autowired
	private SeckillInterceptor si;
	@Autowired
	private ProductInterceptor pi;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(ci)
		.addPathPatterns("/cart/**");
		registry.addInterceptor(oi)
		.addPathPatterns("/order/**");
		registry.addInterceptor(si)
		.addPathPatterns("/seckill/**");
		registry.addInterceptor(pi)
		.addPathPatterns("/page/product_list/**");
		
		//  /WEB-INF/views/producu_list.jsp
		
		super.addInterceptors(registry);
	}
	

}
