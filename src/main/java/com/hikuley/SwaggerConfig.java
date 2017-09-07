package com.hikuley;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by hikuley on 9/7/2017.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${info.app.name}")
    private String serviceName;
    @Value("${info.app.desc}")
    private String serviceDesc;

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().paths(postPaths())
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .paths(springBootActuatorJmxPaths())
                .build()
                ;
    }

    private Predicate<String> postPaths() {
        return regex("/.*");
    }

    private Predicate<String> springBootActuatorJmxPaths() {
        return regex("^/(?!env|restart|pause|resume|refresh).*$");
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(serviceName).description(serviceDesc).build();
    }






}
