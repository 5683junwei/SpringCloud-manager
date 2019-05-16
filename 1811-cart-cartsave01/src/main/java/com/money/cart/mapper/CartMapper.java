package com.money.cart.mapper;
import com.money.common.pojo.Aiproduct;
import com.money.common.pojo.Cart;

public interface CartMapper {

	public void addCart(Cart cart);
	public Cart queryOne(Cart cart);
	public Aiproduct findProductById(String id);
	public void updateNum(Cart cart);
		
}
