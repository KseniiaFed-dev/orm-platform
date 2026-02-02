package com.example.ormplatform;

import org.springframework.boot.SpringApplication;

public class TestOrmPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrmPlatformApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
