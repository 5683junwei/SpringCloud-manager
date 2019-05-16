package com.money;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.money.mymoney.mapper")
@EnableEurekaClient
public class MymoneyStarter {
	public static void main(String[] args) {
		SpringApplication.run(MymoneyStarter.class, args);
	}
}
