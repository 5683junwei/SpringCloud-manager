package com.money.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.common.pojo.Aiproduct;
import com.money.common.util.OUtil;
import com.money.product.mapper.ProductQueryMapper;

import redis.clients.jedis.JedisCluster;

@RestController
public class ProductQueryController {
	@Autowired
	ProductQueryMapper productQueryMapper;
	@Autowired
	JedisCluster cluster;
	@RequestMapping("select")
	public Aiproduct findProductByLevel(String number,String userId){
		String key=userId+number;
		int _number=Integer.parseInt(number)/5;
		try{
		if(cluster.exists(key)){
			//解析获取的数据
			String jsonData=cluster.get(key);
			Aiproduct aiproduct=OUtil.mapper.readValue(jsonData, Aiproduct.class);
			//直接将数据返回调用
			return aiproduct;
			}else{
				Aiproduct aiproduct = productQueryMapper.findProductByLevel(_number);
				//准备ticket
				String ticket=userId+number;
				//将aiproduct转换成json字符串
				String aipJson=OUtil.mapper.writeValueAsString(aiproduct);
				//存储
				cluster.set(ticket, aipJson);
				return aiproduct;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
