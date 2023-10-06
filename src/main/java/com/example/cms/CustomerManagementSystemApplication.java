package com.example.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class CustomerManagementSystemApplication {
  public static void main(String[] args) {
    SpringApplication.run(CustomerManagementSystemApplication.class, args);
  }
}
