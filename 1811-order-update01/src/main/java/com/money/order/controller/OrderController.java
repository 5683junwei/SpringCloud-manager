package com.money.order.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.money.common.pojo.Cart;
import com.money.common.pojo.Order;
import com.money.common.vo.SysResult;
import com.money.order.mapper.OrderMapper;

@RestController
public class OrderController {
	@Autowired
	private OrderMapper ordermapper;	
	//新增订单

	@RequestMapping("update")
	public SysResult updatePay(String userId){
		//直接执行更新
		try{
			Order order = ordermapper.queryOrder(userId);
			order.setPayState(1);
			ordermapper.updatePay(order);
			return SysResult.oK();
		}catch(Exception e){
			return SysResult.build(201, e.getMessage());
		}
	}
	
	
	
}
