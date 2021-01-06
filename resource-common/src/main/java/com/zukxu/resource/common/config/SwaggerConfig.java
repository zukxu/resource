package com.zukxu.resource.common.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.zukxu.resource.common.config.properties.SwaggerProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/19 0019 15:21
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@AllArgsConstructor
@Profile({"dev", "test"})
@EnableConfigurationProperties(SwaggerProperties.class)
public class SwaggerConfig {

	private SwaggerProperties swagger;

	/**
	 * 可指定多个Docket区分不同的分组
	 *
	 * @return
	 */
	@Bean
	public Docket defaultApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				//是否启用
				.enable(swagger.isEnabled())
				.apiInfo(apiInfo())
				//分组名称
				.groupName(swagger.getGroupName())
				.select()
				//这里指定Controller扫描包路径
				.apis(RequestHandlerSelectors.basePackage(swagger.getBasePackage()))
				.paths(PathSelectors.any())
				.build();
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(swagger.getTitle())
				.description(swagger.getDescription())
				.contact(new Contact(swagger.getAuthor(), swagger.getUrl(), swagger.getEmail()))
				.version(swagger.getVersion())
				.build();
	}
}
