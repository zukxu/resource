package com.zukxu.resource.common.config;

import org.springframework.beans.factory.annotation.Value;
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
	@Value("${file.uploadPath}")
	private String uploadPath;

	@Value("${file.returnPath}")
	private String returnPath;

	/**
	 * 添加静态资源映射路径，css、js等都放在classpath下的static中
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/**
		 * addResourceHandler 指的是对外暴露的访问路径
		 * addResourceLocations 指的是文件配置的目录
		 */

		//文件上传路径映射
		registry.addResourceHandler(returnPath)
				.addResourceLocations("file:" + uploadPath);
		// registry.addResourceHandler(returnPath + "/images/**")
		// 		.addResourceLocations("file:" + uploadPath + "/images/");
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
	 * @param converters
	 */
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.removeIf(converter -> converter instanceof StringHttpMessageConverter);
	}

/*	@Bean
	ObjectMapper jacksonObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		//实体类中没有的字段进行忽略
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//设置日期格式
		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"));
		return objectMapper;
	}*/
}