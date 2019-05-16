package com.money.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.money.common.config.HttpClientService;
import com.money.common.util.OUtil;
@Service
public class MymoneyService {
	@Autowired
	private HttpClientService client;
	public String queryproduct(String userId, String number) {
		String url="http://manage.money.com/api-o/mymoney?userId="+userId+"&number="+number;
		try {
			String jsonData=client.doGet(url);
			switch (jsonData) {
			case "index":return OUtil.mapper.writeValueAsString("index");
			case "order":return OUtil.mapper.writeValueAsString("order");	

			default:
				return jsonData;
			}
			
		} catch (Exception e) {
			System.out.println("连接后台出现异常:"+e.getMessage());
			return null;
		}
	}

}
