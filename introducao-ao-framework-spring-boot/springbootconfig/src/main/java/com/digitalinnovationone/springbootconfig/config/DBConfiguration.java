package com.digitalinnovationone.springbootconfig.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource") // mapear todas as strings do arquivo .properties
@Getter
@Setter
public class DBConfiguration {

	private String driverClassName;
	private String url;
	private String username;
	private String password;

	@Profile("dev") // buscar toda configuração que contém dev
	@Bean // mostrar todo o conteúdo deste método ao iniciar o sistema
	public String testDatabaseConnection() {
		System.out.println("DB Connection for DEV - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to H2_TEST - Test instance";
	}

	@Profile("prod") // buscar toda configuração que contém prod
	@Bean // mostrar todo o conteúdo deste método ao iniciar o sistema
	public String productionDatabaseConnection() {
		System.out.println("DB Connection for Production - MySQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to MYSQL_PROD - Production instance";
	}

}
