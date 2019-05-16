package com.money.web.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.money.common.pojo.Order;
import com.money.web.service.OrderService;




@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;	
	
	//新增订单
	@RequestMapping("order/save")
	public String addOrder(HttpServletRequest request,Model model){
		//String userId=(String)request.getAttribute("userId");	
		String userId=(String)request.getSession().getAttribute("userId");
		System.out.println("+++++++++++");
		String result=orderService.addOrder(userId);	
		if(result!=null){
			String success = orderService.queryOrders(userId);
			//List<Order> orderList=orderService.queryOrders(userId);
			//model.addAttribute("orderList", oList);
			return "order";
		}
		return "order";		
	}
	
	
	//查询订单
		@RequestMapping("order/list")
		@ResponseBody
		public String queryOrders(HttpServletRequest request,
				Model model){
			String userId=(String) request.getSession().getAttribute("userId");
			
			String result = orderService.queryOrders(userId);
			//List<Order> orderList=orderService.queryOrders(userId);
			//携带数据
			//model.addAttribute("orderList", oList);
			//model.addAttribute("orderList", orderList);
			return result;
		}
	//删除订单		
		@RequestMapping("order/deleteOrder/{orderId}")
		public String deleteOrder(@PathVariable String orderId){
			orderService.deleteOrder(orderId);
			//return "redirect:/order/list";
			return "redirect:/order";
		}
		
		
    //更新支付状态
		
		@RequestMapping("order/updateorder")
		public String editCart(HttpServletRequest request) throws Exception{
			//获取userId
			String userId=(String)request.getSession().getAttribute("userId");
			orderService.updatePay(userId);
			//return "redirect:/order/list";
			return "order";
		}
}
