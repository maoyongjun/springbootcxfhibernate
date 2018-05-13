package org.foxconn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.foxconn.dao")
@EntityScan(basePackages = "org.foxconn")
public class CxfApplication {
	public static void main(String[] args) {
		SpringApplication.run(CxfApplication.class,args);
	}
}
