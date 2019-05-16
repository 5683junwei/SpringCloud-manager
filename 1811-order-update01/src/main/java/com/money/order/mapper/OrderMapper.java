package com.money.order.mapper;


import com.money.common.pojo.Cart;
import com.money.common.pojo.Order;

public interface OrderMapper {
	
	Order queryOrder(String userId);

	void updatePay(Order order);

	

	
}

