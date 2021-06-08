package com.api;

import com.shop.system.service.SpringInitRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 类作用：
 *
 * @author Lake
 * @date 下午 9:47 2021-03-17
 */
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = {"com.shop.system*"})
@MapperScan("com.shop.system.domain.mapper")
public class StartUp extends SpringBootServletInitializer implements CommandLineRunner {

    @Autowired(required = false)
    SpringInitRedisService springInitRedisService;

    public static void main(String[] args) {
        SpringApplication.run(StartUp.class,args);
    }

    @Override
    public void run(String... args) {
        springInitRedisService.findSystemParamToRedis();
    }
}
