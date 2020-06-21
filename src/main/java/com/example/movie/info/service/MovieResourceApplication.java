package com.example.movie.info.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@EnableSwagger2//springfox swagger2    dynamic javadoc tool
@SpringBootApplication
@EnableEurekaClient
public class MovieResourceApplication {

	@Bean
	public Docket swagerConfiguration(){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
//				.paths(PathSelectors.ant(("/api/*")))
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo(){
		return new ApiInfo(
				"title: Movie info Service",
				"description: getting info about movies",
				"version: 1.0",
				"terms of service: free",
				new Contact("contact: roy", "url:", "royeliyahu827@gmail.com"),
				"licence",
				"licence url",
				Collections.emptyList()
		);
	}
	public static void main(String[] args) {
		SpringApplication.run(MovieResourceApplication.class, args);
	}


}
