package com.money.web.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.money.common.util.OUtil;
import com.money.common.vo.VoProduct;
import com.money.web.service.MymoneyService;

@Controller
public class MymoneyController {
	@Autowired
	private MymoneyService myService;
	@Autowired
	private ObjectMapper mp=OUtil.mapper;
	@RequestMapping("mymoney")
	@ResponseBody
	public String queryByLevel(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException{
		System.out.println("=============");
		String number=(String) request.getSession().getAttribute("userNum");		
		String UserId=(String) request.getSession().getAttribute("userId");
		String jsonData=myService.queryproduct(UserId,number);
		System.out.println(jsonData);
		return jsonData;
	}
}

