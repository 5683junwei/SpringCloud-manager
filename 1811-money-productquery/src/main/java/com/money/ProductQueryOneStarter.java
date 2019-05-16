package com.money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.money.product.mapper")
@EnableEurekaClient
public class ProductQueryOneStarter {
	public static void main(String[] args) {
		SpringApplication.run(ProductQueryOneStarter.class, args);
	}
}
