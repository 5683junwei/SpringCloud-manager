package com.money.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.cart.mapper.CartMapper;
import com.money.common.pojo.Cart;

@RestController
public class QueryCartController {

	@Autowired
	private CartMapper cartMapper;
	@RequestMapping("list")
	public List<Cart> queryMyCart(String userId) {
		
		List<Cart> carts =cartMapper.queryAll(userId);
		return  carts;
	}
}
