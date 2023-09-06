package com.usuariodiez.numbercombination;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class NumberCombinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumberCombinationApplication.class, args);
	}

}
