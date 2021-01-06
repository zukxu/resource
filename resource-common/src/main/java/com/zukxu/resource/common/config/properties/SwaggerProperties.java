package com.zukxu.resource.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p>
 * Swagger配置实体类
 * </p>
 *
 * @author zukxu
 * @date 2020/12/4 0004 10:17
 */
@Data
@ConfigurationProperties(prefix = "swagger")
public class SwaggerProperties {
	private boolean enabled;
	private String groupName;
	private String title;
	private String description;
	private String author;
	private String url;
	private String email;
	private String version;
	private String basePackage;
}