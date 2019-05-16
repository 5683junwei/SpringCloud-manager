package com.money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.money.order.mapper")
@EnableEurekaClient
@EnableFeignClients
public class OrderStarter {
	public static void main(String[] args) {
		SpringApplication.run(OrderStarter.class, args);
	}

}
