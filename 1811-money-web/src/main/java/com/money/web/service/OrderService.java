package com.money.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.money.common.config.HttpClientService;

import com.money.common.util.OUtil;


@Service
public class OrderService {
	@Autowired
	private HttpClientService client;	
	private ObjectMapper mp=OUtil.mapper;
	
	//新增订单
	
	public String addOrder(String userId) {		
		try {
			//String url="http://localhost:9000/api-j/save?userId="+userId;
			String url="http://manage.money.com/api-j/save?userId="+userId;
			String result = client.doGet(url);
			return result;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	
	//查询订单
	public String queryOrders(String userId) {
		//http://localhost:9000/api-k/query/db476eb1-de60-46f8-afdf-9305a4e9f0dc
		try{
			//String url="http://localhost:9000/api-k/query?userId="+userId;
			String url="http://manage.money.com/api-k/query?userId="+userId;
			String result=client.doGet(url);//list的json字符串
			/*//jsonNode解析
			Order order=mp.readValue(jsonData, Order.class);
			JsonNode data = mp.readTree(jsonData);
			//准备返回的内容
			List<Order> oList=null;
			if(data.isArray()&&data.size()>0){
				//(将json解析成linkedHashMap的封装对象),traverce()
				oList= mp.readValue(data.traverse(),mp.getTypeFactory()
						.constructCollectionType(List.class,Order.class));
			}	*/	
			
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//删除订单


	public void deleteOrder(String orderId) {
		try{
			//String url="http://localhost:9000/api-l/delete/"+orderId;
			String url="http://manage.money.com/api-l/delete/"+orderId;
			client.doGet(url);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	//更新支付状态
		public void updatePay(String userId) {	
			try {
				//String url="http://localhost:9000/api-m/update/"+userId;
				String url="http://manage.money.com/api-m/update?userId="+userId;
				String result= client.doGet(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


}
