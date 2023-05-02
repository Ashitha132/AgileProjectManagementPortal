package com.example.Api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.*;

import io.swagger.models.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

//@Configuration
@EnableSwagger2
public
 class SwaggerConfig {
	@Bean
	public Docket postsApi() {

	return new Docket(DocumentationType.SWAGGER_2)
			.select()  .apis(RequestHandlerSelectors.basePackage("com.example.Api.Controller"))

	.paths(regex("/api.*")).build()
	//.apiInfo(metaData())
	;

	}

/*

	private ApiInfo metaData() {
		
		ApiInfo apiInfo=new ApiInfo(
				"Spring Boot  Blog REST APIs",
				"APM Project API ,Documentation",
				"1",
				"Terms of service",
				new Contact("Ashitha","",""),
				"Licence of API",
				"API licence url"
				);
				
		return apiInfo;

	
	
			

	}
*/
	
	
}



