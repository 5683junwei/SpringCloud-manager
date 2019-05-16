package com.money.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.money.cart.mapper.CartMapper;
import com.money.common.pojo.Aiproduct;
import com.money.common.pojo.Cart;
import com.money.common.vo.SysResult;

@RestController
public class QueryCartController {

	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private RestTemplate temp;

	@RequestMapping("save")
	public SysResult saveCart(Cart cart) {
		try {
			
			Aiproduct product ;
			
			//String url = "http://manage.money.com/products/queryById/" + cart.getProductId();
			//jsonData = client.doGet(url);
			//product = OUtil.mapper.readValue(jsonData, Product.class);
			
			//String result=temp.getForObject("http://serviceHi/hi?name="+name,String.class);
			// 将easymall中新增购物车的service粘贴
			// 判断是否已经存在
			Cart exist = cartMapper.queryOne(cart);
			// System.out.println(exist);
			// 如果存在,更新num
			if (exist != null) {// 将已存在num和新增num添加,执行
				// 更新语句
				//Integer getnum = exist.getNum();
				Integer newnum = cart.getNum();
				exist.setNum(newnum);
				exist.setProductPrice((double)(cart.getNum()*1000));
				//cartMapper.updateNum(exist);// userId,productId,num
				/*SysResult forObject = temp.getForObject("http://cartupdate/updateNum?userId="
				+cart.getUserId()+"&productId="+cart.getProductId()+"&num="+cart.getNum(),SysResult.class);*/
				
				//直接执行更新
				try{
					cartMapper.updateNum(exist);
					return SysResult.oK();
				}catch(Exception e){
					return SysResult.build(201, e.getMessage());
				}
				
				
			} else {
				String productId=cart.getProductId();
				product= cartMapper.findProductById(cart.getProductId());
				
				//temp.getForObject("http://localhost:7401/product/findProductById/01",AiProduct.class);
				
				cart.setProductImage(product.getAiImage());
				cart.setProductName(product.getAiName());
				
				cart.setProductId(productId);
				cart.setProductPrice((double) (1000*cart.getNum()));
				cartMapper.addCart(cart);
			}
			return SysResult.oK();
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.build(201, e.getMessage());
		}
	}

	
}
