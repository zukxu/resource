package com.zukxu.resource.common.config;

import com.zukxu.resource.common.config.properties.MinioProperties;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Minio配置类
 * </p>
 *
 * @author zukxu
 * @date 2020/12/31 0031 10:38
 */

@Configuration
public class MinioConfig {
	@Autowired
	private MinioProperties minio;

	@Bean
	public MinioClient minioClient() {
		return MinioClient.builder()
				.endpoint(minio.getEndpoint())
				.credentials(minio.getAccessKey(), minio.getSecretKey())
				.build();
	}
}
