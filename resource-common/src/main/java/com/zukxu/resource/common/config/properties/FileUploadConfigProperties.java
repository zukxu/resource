package com.zukxu.resource.common.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 文件上传实体
 * </p>
 *
 * @author zukxu
 * @date 2021/3/30 0030 15:51
 */
@Data
@Component
@ConfigurationProperties(prefix = "file")
public class FileUploadConfigProperties {
	private String uploadPath;
	private String returnPath;
}
