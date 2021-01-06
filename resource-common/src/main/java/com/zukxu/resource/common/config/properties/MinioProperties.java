package com.zukxu.resource.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Minio配置类
 * </p>
 *
 * @author zukxu
 * @date 2020/12/28 0028 10:44
 */
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {
	/**
	 * minio 服务地址 http://ip:port
	 */
	private String endpoint;
	/**
	 * 用户名
	 */
	private String accessKey;
	/**
	 * 密码
	 */
	private String secretKey;
	/**
	 * 桶名称
	 */
	private String bucketName;
}
