package com.money.order.mapper;


import com.money.common.pojo.Cart;
import com.money.common.pojo.Order;

public interface OrderMapper {
	

	Cart queryById(String userId);

	int saveOrder(Order order);
}

