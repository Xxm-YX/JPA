package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
/*
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2) // 1.SWAGGER_2
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.swaggerv2.controller")) // 2.设置扫描路径
                .build();
    }*/
@Bean
public Docket createRestApi() {
    return new Docket(DocumentationType.OAS_30) // v2 不同
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.demo.web")) // 设置扫描路径
            .build();
}


}
