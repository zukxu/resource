package com.zukxu.resource.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * UCloud配置类
 * </p>
 *
 * @author zukxu
 * @date 2021/1/7 0007 17:50
 */
@Data
@Component
@ConfigurationProperties(prefix = "ucloud")
public class UCloudProperties {
	private String privateKey;
	private String publicKey;
	private String resourceId;
	private String url;
	private String flag;
}
