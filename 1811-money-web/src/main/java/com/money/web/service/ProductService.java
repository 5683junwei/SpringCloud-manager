package com.money.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.money.common.config.HttpClientService;
import com.money.common.pojo.Aiproduct;
import com.money.common.util.OUtil;

@Service
public class ProductService {

	@Autowired
	private HttpClientService client;
	@Autowired
	private ObjectMapper mp=OUtil.mapper;
	
	public Aiproduct queryByLevel(String number, String userId) {
		//String url="http://localhost:9000/api-b/select?number="+number+"&userId="+userId;
		String url="http://manage.money.com/api-f/select?number="+number+"&userId="+userId;
		try {
			String jsonData=client.doGet(url);
			Aiproduct aiproduct=mp.readValue(jsonData,Aiproduct.class);
			return aiproduct;
		} catch (Exception e) {
			System.out.println("连接后台出现异常:"+e.getMessage());
			return null;
		}
	}
	
}