package com.zukxu.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

/**
 * @author zukxu
 */
@SpringBootApplication
@Slf4j
public class Application {
	@Value("${file.uploadPath}")
	private static String uploadPath;

	public static void main(String[] args) {
		File dir = new File(uploadPath);
		if (!dir.isDirectory() && !dir.exists()) {
			//如果目标文件所在的目录不存在，则创建目录
			if (dir.mkdirs()) {
				log.info("文件上传路径初始化成功！");
			} else {
				log.info("文件上传路径初始化失败！");
			}
		}
		SpringApplication.run(Application.class, args);
		System.out.println("" + "______  _   _   _   _   __    __  _   _  \n" + "|___  / | | | | | | / /  \\ \\  / / | | | | \n" + "   / /  | | | | | |/ /    \\ \\/ /  | | | | \n" + "  / /   | | | | | |\\ \\     }  {   | | | | \n" + " / /__  | |_| | | | \\ \\   / /\\ \\  | |_| | \n" + "/_____| \\_____/ |_|  \\_\\ /_/  \\_\\ \\_____/ ");

	}
}
