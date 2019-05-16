package com.money.order.mapper;


import java.util.List;

import com.money.common.pojo.Order;



public interface OrderMapper {

	List<Order> queryOrders(String userId);


}
