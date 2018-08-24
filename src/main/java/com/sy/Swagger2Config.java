package com.sy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: luhailiang
 * @Date: 2018/8/21 13:24
 * @Description:
 */
@EnableSwagger2
@Configuration
public class Swagger2Config extends WebMvcConfigurationSupport {


  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  @Bean
  public Docket createRestApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        //为当前包路径
        .apis(RequestHandlerSelectors.basePackage("com.sy.controller"))
        .paths(PathSelectors.any())
        .build();
  }

  //构建 api文档的详细信息函数
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        //页面标题
        .title("Spring Boot 测试使用 Swagger2 构建RESTful API")
        //创建人
        .contact(new Contact("肆意。-", "https://hailiang.io", "1176239106@qq.com"))
        //版本号
        .version("1.0")
        //描述
        .description("API 描述")
        .build();
  }
}
