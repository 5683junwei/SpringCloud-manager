package com.money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.money.mapper")
@ImportResource(value="classpath:spring-quartz.xml")
@EnableFeignClients
public class OrderTimeDelStart {

	public static void main(String[] args) {
		SpringApplication.run(OrderTimeDelStart.class, args);
	}
}
