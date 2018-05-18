package com.DataDictionary;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class DataDictionaryApplication extends SpringBootServletInitializer {
	
	@PostConstruct
	public void startup() {
		TimeZone.setDefault(TimeZone.getTimeZone("Singapore"));
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DataDictionaryApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DataDictionaryApplication.class, args);
	}

}
