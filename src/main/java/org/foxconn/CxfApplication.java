package org.foxconn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.justin.hibernateTest.dao")
@EntityScan(basePackages = "org.justin")
public class CxfApplication {
	public static void main(String[] args) {
		SpringApplication.run(CxfApplication.class,args);
	}
}
