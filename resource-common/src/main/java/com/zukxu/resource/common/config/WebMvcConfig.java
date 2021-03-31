package com.zukxu.resource.common.config;

import com.zukxu.resource.common.config.properties.FileUploadConfigProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * MVC通用配置
 *
 * @author zukxu
 * @date 2020-10-5 22:04:58
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	final FileUploadConfigProperties uploadConfig;

	public WebMvcConfig(FileUploadConfigProperties uploadConfig) {
		this.uploadConfig = uploadConfig;
	}


	/**
	 * 添加静态资源映射路径，css、js等都放在classpath下的static中
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// addResourceHandler 指的是对外暴露的访问路径
		// addResourceLocations 指的是文件配置的目录
		//文件上传路径映射
		registry.addResourceHandler(uploadConfig.getReturnPath()+"/**")
				.addResourceLocations("file:/" + uploadConfig.getUploadPath()+"/");
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				//请求头
				.allowedHeaders("*")
				//请求方法
				.allowedMethods("*")
				//接受任意域名的请求。
				.allowedOrigins("*")
				//接受请求携带cookie
				.allowCredentials(true)
				.maxAge(3600);

	}

	/**
	 * 修复自定义异常处理String转换Object问题
	 * @param converters 转换
	 */
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.removeIf(converter -> converter instanceof StringHttpMessageConverter);
	}

}