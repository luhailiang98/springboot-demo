package com.sy;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.sy.dao")
public class SpringbootDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootDemoApplication.class, args);
  }
}
