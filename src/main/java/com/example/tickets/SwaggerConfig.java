package com.example.tickets;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {


    public static final String AUTHORIZATION_HEADER = "Authorization";

    private ApiKey apiKey(){
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

    private ApiInfo apiInfo(){
        return new ApiInfo(
                "Spring Boot Blog REST APIs",
                "Spring Boot Blog REST API Documentation",
                "1",
                "Terms of service",
                new Contact("Ramesh Fadatare", "www.javaguides.net", "ramesh@gmail.com"),
                "License of API",
                "API license URL",
                Collections.emptyList()
        );
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth(){
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
    }





//   @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(basicAuthScheme()));
//    }

//    @Bean
//    public Docket api() {
//
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo())
//                .securitySchemes(Arrays.asList(apiKey()));
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Sig-Predict REST API Document")
//                .description("work in progress")
//                .termsOfServiceUrl("localhost")
//                .version("1.0")
//                .build();
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("jwtToken", "Authorization", "header");
//    }

//    @Bean
//    public Docket api() {
//        List<SecurityScheme> schemeList = new ArrayList<>();
//        schemeList.add(new ApiKey(HttpHeaders.AUTHORIZATION, "JWT", "header"));
//        return new Docket(DocumentationType.SWAGGER_2)
//                .produces(Collections.singleton("application/json"))
//                .consumes(Collections.singleton("application/json"))
//                .ignoredParameterTypes(Authentication.class)
//                .securitySchemes(schemeList)
//                .useDefaultResponseMessages(false)
//                .select()
//    //            .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Arrays.asList(basicAuthReference()))
//                .forPaths(PathSelectors.ant("/api/v1/**"))
//                .build();
//    }
//
//    private SecurityScheme basicAuthScheme() {
//        return new BasicAuth("basicAuth");
//    }
//
//    private SecurityReference basicAuthReference() {
//        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
//    }
//







}