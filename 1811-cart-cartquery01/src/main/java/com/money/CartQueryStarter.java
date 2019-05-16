package com.money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.money.cart.mapper")
@EnableEurekaClient
@EnableFeignClients
public class CartQueryStarter {

	public static void main(String[] args) {
		SpringApplication.run(CartQueryStarter.class, args);
	}
}
