package com.money.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.money.common.pojo.User;
import com.money.common.util.CookieUtils;
import com.money.common.util.OUtil;
import com.money.mapper.UserMapper;

import redis.clients.jedis.JedisCluster;
@RestController
public class SetUserNum {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private JedisCluster cluster;
	
	@RequestMapping("setnum")
	public String setUserNum(String userNum,String userId,String ticket){			
		String result=userMapper.setUserNum(userNum,userId)+"";		
		//我现在需要拿出COOKIE中的JT_TICKET对应的值ticket
		//然后把redis中的键值对ticket:userJson中的userJson更新为最新的userJson	
		
		//查询到最新的user信息封装成user对象
		User user=userMapper.selectUser(userId);		
		try {
			//把最新的user对象转化成json格式
			String userJson = OUtil.mapper.writeValueAsString(user);
			//往redis中存入，相当于把原来的ticket中的值替换成最新的user信息
			cluster.set(ticket,userJson);
		} catch (JsonProcessingException e) {			
			e.printStackTrace();
		}		
		return result;
	}
}
