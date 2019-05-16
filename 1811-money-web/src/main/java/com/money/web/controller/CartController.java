package com.money.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.money.common.pojo.Aiproduct;
import com.money.common.pojo.Cart;
import com.money.web.service.CartService;

@Controller
public class CartController {
	
	//查询我的购物车
	//通过userId获取t_cart表格的list数据
	@Autowired
	private CartService cartService;
	@RequestMapping("cart/mycart")
	public String queryCart(Model model,HttpServletRequest request){
		//判断登录是否存在,session是否有userId属性
		String userId=(String)request.getSession().getAttribute("userId");		
		//已经登录情况下,拿到了userId,直接调用方法获取cart购物车数据
		List<Cart> cartList=cartService.queryCart(userId);
		//model携带数据到页面 "cartList"
		model.addAttribute("cartList", cartList);
		return "cart";
	}
	
//新增商品到购物车
	@RequestMapping("cart/addCart")
	public String addCart(HttpSession session,String num){
		//判断登录是否存在,session是否有userId属性
		String userId = (String)session.getAttribute("userId");
		String productId = (String)session.getAttribute("productId");		
		//String num=(String)session.getAttribute("num");
		
		System.out.println(num);
		System.out.println(productId);		
		//主功能编写
		try {
			cartService.addCart(userId,productId,num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/cart/mycart";
	}
	
	//删除购物车商品
	@RequestMapping("cart/deleteCart")
	public String deleteCart(HttpSession session){
		//获取userId
		String userId=(String)session.getAttribute("userId");
		try {
			cartService.deleteCart(userId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/cart/mycart";
	}
	
}




















