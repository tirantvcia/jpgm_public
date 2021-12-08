package io.intellisense.test.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IntellisenseJobTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntellisenseJobTestApplication.class, args);
	}

}
