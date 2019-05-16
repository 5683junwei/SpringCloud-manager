package com.money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.money.order.mapper")
@EnableFeignClients
public class removeOrderStarter {
	public static void main(String[] args) {
		SpringApplication.run(removeOrderStarter.class, args);
	}

}
