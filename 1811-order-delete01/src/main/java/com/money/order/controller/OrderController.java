package com.money.order.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.money.common.util.OUtil;
import com.money.common.util.UUIDUtil;
import com.money.common.vo.SysResult;
import com.money.order.mapper.OrderMapper;

@RestController

public class OrderController {
	@Autowired
	private OrderMapper ordermapper;
	
	
	//删除订单
	
	@RequestMapping("delete/{id}")
	public SysResult deleteOrder(@PathVariable String id){
		ordermapper.deleteOrder(id);
		return SysResult.oK();
	}
	


}
