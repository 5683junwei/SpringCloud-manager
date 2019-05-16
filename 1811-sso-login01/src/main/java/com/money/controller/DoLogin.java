package com.money.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.common.pojo.User;
import com.money.common.util.MD5Util;
import com.money.common.util.OUtil;
import com.money.common.util.UUIDUtil;
import com.money.mapper.UserMapper;

import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
@RestController
public class DoLogin {
	@Autowired
	private JedisCluster cluster;
	@Autowired
	private UserMapper userMapper;
	@RequestMapping("test")
	public String test(){
		System.out.println(cluster.del("null"));
		return "success";
	}
	
	
	@RequestMapping("login")
	public String doLogin(User user){
		//user对象中只有username和password的属性,passwrod是明文
		//验证合法,使用mapper查询where user_name=arg1,user_password=arg2
		user.setUserPassword(MD5Util.md5(user.getUserPassword()));
		User _user = userMapper.login(user);
		try{
			if(_user!=null){//说明有值,登录信息正确
				//将数据存储到redis,第三方存储
				//准备key ticket 算法=MD5("JT_TICKET"+TIME+USERNAME)
				String ticket=MD5Util.md5("JT_TICKET"+
						System.currentTimeMillis()+user.getUserName());
				//表示同一个用户,在不同时间登录时在redis的key值
				String userJson=OUtil.mapper.writeValueAsString(_user);
				//存储
				//redis.set(ticket, userJson);//登录超时30分钟
				//删除有的ticket/实现一个用户只能登陆一次
				//String string = cluster.get(_user.getUserId());
				//cluster.del(string);
				//set当前登录的ticket，键是：user的UUID，值是：MD5加密过的JT_TICKET+当前时间+唯一的userName
				cluster.set(_user.getUserId(), ticket);			
				
				cluster.set(ticket,userJson);
				System.out.println(ticket);
				cluster.expire(ticket, 20);
				//ticket======MD5加密过的JT_TICKET+当前时间+唯一的userName
				return ticket;
			}
			return "";//说明验证失败,用户名密码不对;
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		
	}
}
