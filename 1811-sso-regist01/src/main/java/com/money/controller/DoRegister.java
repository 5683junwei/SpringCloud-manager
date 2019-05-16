package com.money.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.common.pojo.User;
import com.money.common.util.MD5Util;
import com.money.common.util.UUIDUtil;
import com.money.mapper.UserMapper;
@RestController
public class DoRegister {
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("register")
	public String doRegister(User user){
		//补充内容		
		String userId=UUIDUtil.getUUID();
		user.setUserId(userId);
		//加密
		user.setUserPassword(MD5Util.md5(user.getUserPassword()));
		String result=userMapper.saveUser(user)+"";		
		return result;
	}
}
