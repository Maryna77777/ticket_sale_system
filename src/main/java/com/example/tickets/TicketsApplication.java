package com.example.tickets;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableSwagger2
public class TicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}


//	@Bean
//	public Docket api() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//				.paths(PathSelectors.any()).build().pathMapping("/")
//				.apiInfo(apiInfo()).useDefaultResponseMessages(false);
//	}
//
//	@Bean
//	public ApiInfo apiInfo() {
//		final ApiInfoBuilder builder = new ApiInfoBuilder();
//		builder.title("My Application API through Swagger UI").version("1.0").license("(C) Copyright Test")
//				.description("List of all the APIs of My Application App through Swagger UI");
//		return builder.build();
//	}


//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("com.example.tickets")).build();
//	}
}