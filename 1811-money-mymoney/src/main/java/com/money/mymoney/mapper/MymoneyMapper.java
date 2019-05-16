package com.money.mymoney.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.money.common.pojo.Aiproduct;
import com.money.common.pojo.Order;
import com.money.common.pojo.Product;
import com.money.common.pojo.Userproduct;

public interface MymoneyMapper {

	List<Product> findProduct(@Param(value="category")String category, @Param(value="equity")int equity);

	int insertUserproduct(Userproduct userproduct_equity);

	Aiproduct findProductByLevel(int _number);
	
	//查userproduct表
	int queryuserproductnum(String userId);
	//查order表
	Order queryorder(String userId);
	//查userproduct表具体数据
	List<Userproduct> queryUserproduct(String userId);

}
