package com.yingge.qa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class
    , DataSourceTransactionManagerAutoConfiguration.class
    , HibernateJpaAutoConfiguration.class})
@MapperScan("com.yingge.qa.dao")
@ComponentScan(basePackages = {"com.yingge.qa.controller","com.yingge.qa.service"})
public class QaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        try {
            SpringApplication.run(QaApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
