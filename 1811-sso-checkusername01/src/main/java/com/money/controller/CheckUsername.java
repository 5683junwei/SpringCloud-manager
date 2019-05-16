package com.money.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.mapper.UserMapper;
@RestController
public class CheckUsername {
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("check")
	public String checkUsername(String userName){		
		String result=userMapper.checkUsername(userName)+"";
		return result;
	}
}
