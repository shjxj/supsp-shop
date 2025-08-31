package com.supsp.shop;

import com.supsp.springboot.core.config.UniqueNameGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(
        nameGenerator = UniqueNameGenerator.class
)
@EnableAspectJAutoProxy(
        exposeProxy = true
)
@ComponentScan(
        basePackages = {"com.supsp.shop", "com.supsp.springboot.core"},
        nameGenerator = UniqueNameGenerator.class
)
@EnableTransactionManagement
@MapperScan("com.supsp.shop.model.*.mapper")
public class ShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}