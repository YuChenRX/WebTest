package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // 配置类
@EnableSwagger2 // 开启 swagger2 的自动配置
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                // 配置基本信息
                .apiInfo(apiInfo())
                .groupName("MART")
         .select() // 设置扫描接口
                // 配置如何扫描接口
                .apis(RequestHandlerSelectors
                                //.any() // 扫描全部的接口，默认
                                //.none() // 全部不扫描
                                .basePackage("com.controller") // 扫描指定包下的接口，最为常用
                        //.withClassAnnotation(RestController.class) // 扫描带有指定注解的类下所有接口
                        //.withMethodAnnotation(PostMapping.class) // 扫描带有只当注解的方法接口

                )
                .paths(PathSelectors
                                .any() // 满足条件的路径，该断言总为true
                        //.none() // 不满足条件的路径，该断言总为false（可用于生成环境屏蔽 swagger）
                        //.ant("/user/**") // 满足字符串表达式路径
                        //.regex("") // 符合正则的路径
                )
                .build();
    }
    @Bean
    public Docket docket2() {
        // 创建一个 swagger 的 bean 实例
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Two") // 修改组名为 "yank"
                // 配置接口信息
                .select() // 设置扫描接口
                // 配置如何扫描接口
                .apis(RequestHandlerSelectors
                        .any() // 扫描全部的接口，默认
                )
                .paths(PathSelectors
                        .ant("/error") // 满足字符串表达式路径
                )
                .build();
    }


    // 基本信息设置
    private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "MART", // 作者姓名
                "https://gitee.com/KKKMart/web.git", // 作者网址
                "2925528609@qq.com"); // 作者邮箱
        return new ApiInfoBuilder()
                .title("MatchApi") // 标题
                .description("商城接口文件") // 描述
                .termsOfServiceUrl("https://gitee.com/KKKMart/web.git") // 跳转连接
                .version("1.0") // 版本
                .license("Swagger-的使用(详细教程)")
                .licenseUrl("https://gitee.com/KKKMart/web.git")
                .contact(contact)
                .build();

    }

}
