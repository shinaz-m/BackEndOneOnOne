package com.swaggerconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()              
                .apis(RequestHandlerSelectors.basePackage("com.Controller"))
                .paths(PathSelectors.any())
                .build()
                 .apiInfo(metaInfo());
    }
private ApiInfo metaInfo() {

    ApiInfo apiInfo = new ApiInfo(
    		" NINELEAPS ONEONONE",
            " NINELEAPS ONEONONE API for Updating the Employee feedback status.",
            "1.0",
            "Terms of Service",
            new Contact("Team-11(Charlie Batch,Nineleaps)"
            		+ "::Mentor:Ranjan", "https://www.nineleaps.com/",
                    "mohammad.shinaz@nineleaps.com" ),
            "",
            ""
    );

    return apiInfo;
}
}