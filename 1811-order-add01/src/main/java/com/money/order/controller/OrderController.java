package com.money.order.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.money.common.pojo.Cart;
import com.money.common.pojo.Order;
import com.money.order.mapper.OrderMapper;

@RestController
public class OrderController {
	@Autowired
	private OrderMapper ordermapper;	
	//新增订单
	@RequestMapping("save")
	public int saveOrder(@RequestParam String userId){
		//整合时注入购物车相关对象,调用购物车功能中的查询购物车方法
		Cart cart=ordermapper.queryById(userId);
		Order order=new Order();
	    order.setPayState(0);
	    order.setOrderDate(new Date());
	    order.setProductId(cart.getProductId());
	    order.setProductImg(cart.getProductImage());
	    order.setProductPrice(cart.getProductPrice());
	    order.setNum(cart.getNum());
	    order.setProductName(cart.getProductName());
	    order.setUserId(userId);
	    int result=ordermapper.saveOrder(order);
	    return result;
	}
	
	
	
}
