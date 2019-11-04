package com.qfedu.ordersystem.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {

    //创建文档说明
    public ApiInfo createApi() {
        ApiInfo apiInfo = new ApiInfoBuilder().title("点餐系统").description("万豪国际酒店内部点餐系统").contact(new Contact("wzp","www.baidu.com","1505363731@qq.com")).build();

        return apiInfo;
    }


    @Bean
    public Docket createDoc() {
       return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApi()).select().apis(RequestHandlerSelectors.basePackage("com.qfedu.ordersystem.controller")).build();
    }

}
