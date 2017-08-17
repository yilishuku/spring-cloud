package com.spring.cloud.springbootdemo.config;

/**
 * User: wcy
 * Date: 2017/8/16
 * Time: 17:05
 */
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

/**
 * Created by huguoju on 2016/12/29.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了 （访问页面就可以看到效果了）
     *
     */
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.spring"))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("wcy使用Swagger2构建RESTful APIs")
                .description("wcy中构建RESTful API")
                .termsOfServiceUrl("")
                .contact(new Contact("wcy","http://www.baidu.com","wucy@drore.com"))
                .version("1.0")
                .build();
    }
}
