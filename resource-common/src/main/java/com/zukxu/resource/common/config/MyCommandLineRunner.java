package com.zukxu.resource.common.config;

import com.zukxu.resource.common.config.properties.FileUploadConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * <p>
 * 任务初始化类
 * </p>
 *
 * @author zukxu
 * @date 2021/3/30 0030 16:12
 */
@Component
@Slf4j
public class MyCommandLineRunner implements CommandLineRunner {
	final FileUploadConfigProperties uploadConfigProperties;

	public MyCommandLineRunner(FileUploadConfigProperties uploadConfigProperties) {
		this.uploadConfigProperties = uploadConfigProperties;
	}
	@Override
	public void run(String... args) throws Exception {
		log.info("初始化文件上传路径：{}",uploadConfigProperties.getUploadPath());
		File dir = new File(uploadConfigProperties.getUploadPath());
		if (!dir.exists()) {
			//如果目标文件所在的目录不存在，则创建目录
			if (dir.mkdirs()) {
				log.info("文件上传路径初始化成功！");
			} else {
				log.info("文件上传路径初始化失败！");
			}
		}
	}
}
