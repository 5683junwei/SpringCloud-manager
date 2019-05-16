package com.money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@SpringBootApplication
@MapperScan("com.money.cart.mapper")
@EnableEurekaClient
public class CartSaveStarter {

	public static void main(String[] args) {
		SpringApplication.run(CartSaveStarter.class, args);
	}
	
	@Bean
	public IRule getRule(){
		return new RandomRule();
	}
	
	
	//添加template
	@Bean
	@LoadBalanced//将当前对象加入到ribbon逻辑
	public RestTemplate getSor(){
		return new RestTemplate();
	}
}
