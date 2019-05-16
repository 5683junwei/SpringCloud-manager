package com.money.mapper;

import org.apache.ibatis.annotations.Param;

import com.money.common.pojo.User;

public interface UserMapper {
	

	int setUserNum(@Param("userNum")String userNum,@Param("userId")String userId);

	User selectUser(String userId);
	
}
