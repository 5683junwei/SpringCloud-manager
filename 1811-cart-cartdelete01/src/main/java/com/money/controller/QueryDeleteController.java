package com.money.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.cart.mapper.CartMapper;
import com.money.common.pojo.Cart;
import com.money.common.vo.SysResult;

@RestController
public class QueryDeleteController {

	@Autowired
	private CartMapper cartMapper;
	@RequestMapping("delete")
	public SysResult deleteCart(Cart cart){
		cartMapper.deleteCart(cart);
		return SysResult.oK();
	}
}
