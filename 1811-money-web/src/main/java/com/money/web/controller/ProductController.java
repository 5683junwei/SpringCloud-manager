package com.money.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.money.common.pojo.Aiproduct;
import com.money.web.service.ProductService;


@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@RequestMapping("page/product_list")
	public String queryByLevel(HttpServletRequest request,Model model){
		String number=(String) request.getSession().getAttribute("userNum");		
		String userId=(String) request.getSession().getAttribute("userId");
		Aiproduct aiproduct=productService.queryByLevel(number,userId);
		model.addAttribute("UserId",userId);
		model.addAttribute("aiproduct",aiproduct);
		request.getSession().setAttribute("productId",aiproduct.getAiId());
		return "product_list";
	}
}







