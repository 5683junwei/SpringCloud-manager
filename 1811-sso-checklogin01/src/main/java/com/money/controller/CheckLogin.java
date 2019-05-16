package com.money.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.money.common.util.OUtil;
import com.money.common.vo.SysResult;
import redis.clients.jedis.JedisCluster;
@RestController
public class CheckLogin {
	@Autowired
	private JedisCluster cluster;	
	@RequestMapping("test")
	public String test(){
		System.out.println(cluster.del("null"));
		return "success";
	}
		
	@RequestMapping("query")
	public String checkLogin(String ticket,
			String callback){
		//获取了前台传递的ticket,用户需要用ticket验证是否登录,验证
		//redis是否已经存在user数据,有就是登录过了,没有就是没登录
		
		//String userJson = redis.get(ticket);
		//根据userJson判断是否登录,将userJson(""/{"":"","":"","":""})
		//sysResult的data属性,赋值userJson
		//判断超时剩余时间	
		Long timeOT = cluster.ttl(ticket);//剩余秒数
		if(timeOT<60*5){//用户已经连续访问了大于25分钟系统
			cluster.expire(ticket, (int)(timeOT+(60*10)));
			//存在瞬间超时，无法执行续约
			//一定是用户至少5分钟没有使用用户操作系统;
		}
		
		String userJson=cluster.get(ticket);//超时了返回空,续约失败返回空,续约成功返回userJson,没达到续约条件,返回userJson		
		String jsonData="";
		try{
			jsonData=OUtil.mapper.
			writeValueAsString(SysResult.oK(userJson));
		}catch(Exception e){
			return jsonData;
		}	
		//{"status":"200","msg":"ok","data":{"userId":"","userName"}}
		//根据callback返回数据结构,非空的callback表示jsonp格式
		//空callback表示json格式
		if(callback==null){//说明拦截器发起请求,返回userJson
			System.out.println("================");
			if(userJson==null){
				System.out.println("userjson空");
				return "";
			}
			System.out.println("++++++++++++++++++");
			System.out.println("userJson"+userJson);
			return userJson;
		}else{//非空,需要返回jsonp格式
			String result=callback+"("+jsonData+")";
			return result;
		}
	}	
}




