package com.money.cart.mapper;

import java.util.List;

import com.money.common.pojo.Cart;

public interface CartMapper {

	public List<Cart> queryAll(String userId);
		
}
