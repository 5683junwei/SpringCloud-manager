package com.money.mapper;

import com.money.common.pojo.User;

public interface UserMapper {
	int saveUser(User user);

	int checkUsername(String userName);
	
}
