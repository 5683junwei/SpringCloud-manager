package com.money.mymoney.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.money.common.pojo.Aiproduct;
import com.money.common.pojo.Order;
import com.money.common.pojo.Product;
import com.money.common.pojo.Userproduct;
import com.money.common.util.OUtil;
import com.money.common.util.WeightRandom;
import com.money.common.vo.VoProduct;
import com.money.mymoney.mapper.MymoneyMapper;

import redis.clients.jedis.JedisCluster;

@RestController
public class MymoneyController {
	@Autowired
	MymoneyMapper mymoneyMapper;
	@Autowired
	JedisCluster cluster;
	@RequestMapping("mymoney")
	public String querymymoney(String userId,String number) throws Exception{
		String key=userId+"money";
		if(cluster.exists(key)){
			//解析获取的数据
			String jsonData=cluster.get(key);
			//直接将数据返回调用
			return jsonData;
		}else {
			//查userproduct表
			int success=mymoneyMapper.queryuserproductnum(userId);
			
			if (success!=0) {
				//查询并封装数据返回
				List<VoProduct> voList=this.back(userId);
				return OUtil.mapper.writeValueAsString(voList);
				
				
			}else{
				//查order表
				Order order=mymoneyMapper.queryorder(userId);
				if (order==null) {
					return "index";
				}else{
					if (order.getPayState()!=1) {
						return "order";
					}else{
						//执行方法
						int _number=(Integer.parseInt(number))/5;
						boolean flag=true;
						flag=this.dowangzhe(userId, _number, "股票型", "1","equity")&&flag;
						flag=this.dowangzhe(userId, _number, "混合型", "2","hybrid")&&flag;
						flag=this.dowangzhe(userId, _number, "债券型", "3","bond")&&flag;
						flag=this.dowangzhe(userId, _number, "指数型", "4","index")&&flag;
						flag=this.dowangzhe(userId, _number, "货币型", "5","money")&&flag;
						flag=this.dowangzhe(userId, _number, "原油", "6","crude")&&flag;
						flag=this.dowangzhe(userId, _number, "黄金", "7","gold")&&flag;
						if(flag){
							//返回vo数据
							List<VoProduct> voList=this.back(userId);							
							return OUtil.mapper.writeValueAsString(voList);
						}else{
							return "index";
						}
					}
				}
			}
		}	
	}

	private boolean dowangzhe(String userId,int _number,String type,String category,String key){
		Aiproduct aiproduct = mymoneyMapper.findProductByLevel(_number);
		
		//开始计算user的商品
		Properties prop=new Properties();
		InputStream in = MymoneyController.class.getClassLoader().getResourceAsStream(
		        "productnumber.properties");		
		try {
			prop.load(in);
			//从文件中得到股票型有几个商品
			int equity=Integer.parseInt(prop.getProperty(key));
			//从数据库拿出_equity个商品
			List<Product> pList= mymoneyMapper.findProduct(category,equity);
			//得到股票型商品占比
			String bond="";
			switch (category) {
			case "1":bond = aiproduct.getEquity();break;
			case "2":bond = aiproduct.getHybrid();break;
			case "3":bond = aiproduct.getBond();break;
			case "4":bond = aiproduct.getIndex();break;
			case "5":bond = aiproduct.getMoney();break;
			case "6":bond = aiproduct.getCrude();break;
			case "7":bond = aiproduct.getGold();break;
			default:
				break;
			}
			//通过占比自动添加商品数量
			List<Integer> rList = WeightRandom.wangzhe(bond, equity);
			//封装userproduct对象
			for (int i = 0; i < pList.size(); i++) {
				Userproduct userproduct_equity = new Userproduct(userId,type, bond,pList.get(i).getProductName(),aiproduct.getAiImage(),rList.get(i));
				int win=mymoneyMapper.insertUserproduct(userproduct_equity);
				if(win!=1){
					return false;
				}
			}
			return true;
		}catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	
	
	public List<VoProduct> back(String userId){
		VoProduct vop = new VoProduct(new ArrayList<>());
		List<VoProduct> vList = new LinkedList<>();
		
		try {
			
			List<Userproduct> uList = mymoneyMapper.queryUserproduct(userId);
			//equity---6
			for (int i = 0; i <= 5; i++) {
				
				Product product = new Product();
				
				vop.setCategroyName(uList.get(i).getCategroyName());
				
				vop.setCategroyNum(uList.get(i).getCategroyNum());
				vop.setImgurl(uList.get(i).getImgurl());
				product.setProductName(uList.get(i).getProductName());
				product.setProductNum(uList.get(i).getpNum());
				vop.getProductList().add(product);
			}
			vList.add(0, vop);
			vop = new VoProduct(new ArrayList<>());
			//hybrid---5
			for (int i = 6; i <= 10 ; i++) {
				
				Product product = new Product();
				vop.setCategroyName(uList.get(i).getCategroyName());
				
				vop.setCategroyNum(uList.get(i).getCategroyNum());
				vop.setImgurl(uList.get(i).getImgurl());
				product.setProductName(uList.get(i).getProductName());
				product.setProductNum(uList.get(i).getpNum());
				vop.getProductList().add(product);
			}
			vList.add(1, vop);
			vop = new VoProduct(new ArrayList<>());
			
			//bond---3
			for (int i =11 ; i <= 13 ; i++) {
				
				Product product = new Product();
				vop.setCategroyName(uList.get(i).getCategroyName());
				
				vop.setCategroyNum(uList.get(i).getCategroyNum());
				vop.setImgurl(uList.get(i).getImgurl());
				product.setProductName(uList.get(i).getProductName());
				product.setProductNum(uList.get(i).getpNum());
				vop.getProductList().add(product);
			}
			vList.add(2, vop);
			vop = new VoProduct(new ArrayList<>());
			//index----4
			for (int i =14 ; i <= 17 ; i++) {
				Product product = new Product();
				vop.setCategroyName(uList.get(i).getCategroyName());
				
				vop.setCategroyNum(uList.get(i).getCategroyNum());
				vop.setImgurl(uList.get(i).getImgurl());
				product.setProductName(uList.get(i).getProductName());
				product.setProductNum(uList.get(i).getpNum());
				vop.getProductList().add(product);
			}
			vList.add(3, vop);
			vop = new VoProduct(new ArrayList<>());
			
			//money---5
			for (int i =18 ; i <= 22 ; i++) {
				Product product = new Product();
				vop.setCategroyName(uList.get(i).getCategroyName());
				
				vop.setCategroyNum(uList.get(i).getCategroyNum());
				vop.setImgurl(uList.get(i).getImgurl());
				product.setProductName(uList.get(i).getProductName());
				product.setProductNum(uList.get(i).getpNum());
				vop.getProductList().add(product);
				
			}
			vList.add(4, vop);
			vop = new VoProduct(new ArrayList<>());
			
			//curde----3
			for (int i =23 ; i <= 25 ; i++) {
				Product product = new Product();
				vop.setCategroyName(uList.get(i).getCategroyName());
				
				vop.setCategroyNum(uList.get(i).getCategroyNum());
				vop.setImgurl(uList.get(i).getImgurl());
				product.setProductName(uList.get(i).getProductName());
				product.setProductNum(uList.get(i).getpNum());
				vop.getProductList().add(product);
				
			}
			vList.add(5, vop);
			vop = new VoProduct(new ArrayList<>());
			
			
			//gold---2
			for (int i =26 ; i <= 27 ; i++) {
				Product product = new Product();
				vop.setCategroyName(uList.get(i).getCategroyName());
				
				vop.setCategroyNum(uList.get(i).getCategroyNum());
				vop.setImgurl(uList.get(i).getImgurl());
				product.setProductName(uList.get(i).getProductName());
				product.setProductNum(uList.get(i).getpNum());
				vop.getProductList().add(product);
				
			}
			vList.add(6, vop);
			
			
			
			
			
			return vList;

			
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		}
		
		
	}

}


