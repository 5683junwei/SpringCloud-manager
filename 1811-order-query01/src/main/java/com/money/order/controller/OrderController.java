package com.money.order.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.money.common.pojo.Order;
import com.money.order.mapper.OrderMapper;

@RestController

public class OrderController {
	@Autowired
	private OrderMapper ordermapper;
	
	//查看订单
	@RequestMapping("query")
	public List<Order> queryList(String userId){
		List<Order> orderList = ordermapper.queryOrders(userId);
		return orderList;
	}
	
	
	
}
