package com.money.order.mapper;

import java.util.Date;
import java.util.List;


public interface OrderMapper {

	void deleteOrder(String orderId);
	
	void deleteOTOrder(Date otTime);
}
