package com.digitalinnovationone.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Profile("dev") // buscar todas configs do profile dev
	@Bean // mostrar todo o conteúdo sendo mapeado quando subir o projeto
	public String testDatabaseConnection() {
		System.out.println("DB connection for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to H2_TEST - Test instance";
	}

	@Profile("prod")
	@Bean
	public String productionDatabaseConnection() {
		System.out.println("DB connection for Production - MySQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to MYSQL_PROD - Production instance";
	}
}