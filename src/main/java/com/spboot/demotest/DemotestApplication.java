package com.spboot.demotest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// 레포지토리에 대한 지정된 패키지 스캔
@EnableJpaRepositories("com.spboot.demotest")
// JPA 엔티티 선택
@EntityScan("com.spboot.demotest")
@SpringBootApplication
public class DemotestApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotestApplication.class, args);
    }
}