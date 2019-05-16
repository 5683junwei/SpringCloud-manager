package com.money.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.money.common.config.HttpClientService;
import com.money.common.pojo.Cart;
import com.money.common.util.OUtil;

@Service
public class CartService {
	@Autowired 
	private HttpClientService client;
	private ObjectMapper mp=OUtil.mapper;

	public List<Cart> queryCart(String userId) {
		//按照接口实现访问
		try{
			//String url="http://localhost:9000/api-g/list?userId="+userId;
			String url="http://manage.money.com/api-g/list?userId="+userId;
			String jsonData=client.doGet(url);//[{"":""},{}]
			//jsonData时一个list结构，无法直接使用之前readValue();
			//先将jsonData的字符串，转化成JsonNode
			JsonNode data=mp.readTree(jsonData);
			List<Cart> cList=null;
			//data并不一定有值，判断是否是数组类型，是否size>0
			if(data.isArray()&&data.size()>0){
				//(将json解析成linkedHashMap的封装对象),traverce()
				cList= mp.readValue(data.traverse(),mp.getTypeFactory()
						.constructCollectionType(List.class,Cart.class));
			}
			//并且制定List类反射，元素类反射对象List<Cart>
			return cList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}
	public String addCart(String userId, String productId, String num){
		//String url="http://localhost:9000/api-h/save";
		String url="http://manage.money.com:9000/api-h/save";
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("userId", userId);
		map.put("productId", productId);
		map.put("num", Integer.parseInt(num));
		//doGet
		try{
			String result=client.doGet(url, map);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			return e.getMessage();
		}		
	}
	public void deleteCart(String userId) throws Exception {
		//String url="http://localhost:9000/api-i/delete";
		String url="http://manage.money.com:9000/api-i/delete";
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("userId", userId);
		client.doGet(url,map);
	}

}





