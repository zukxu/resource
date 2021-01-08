package com.zukxu.resource.common.utils;

import lombok.SneakyThrows;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <p>
 * 文件上传工具类
 * </p>
 *
 * @author zukxu
 * @date 2020/12/31 0031 11:44
 */
@Component
public class FileUtils {
	/**
	 * 获取随机文件名
	 *
	 * @return InputStream
	 */
	@SneakyThrows
	public String getRandomFileName(String fileName) {
		//生成随机数
		Random rand = new Random();
		int random = Math.abs(rand.nextInt());
		fileName = random + fileName.substring(fileName.lastIndexOf(".")).toLowerCase();

		return fileName;
	}

	/**
	 * 通过字节数组的方式获取文件流
	 *
	 * @param file MultipartFile文件
	 * @return InputStream
	 */
	@SneakyThrows
	public InputStream getStreamByByte(MultipartFile file) {
		byte[] bytes = file.getBytes();
		InputStream stream = new ByteArrayInputStream(bytes);
		stream.close();
		return stream;
	}

	/**
	 * 通过CommonsMultipartFile中转的方式获取文件流
	 *
	 * @param file MultipartFile文件
	 * @return InputStream
	 */
	@SneakyThrows
	public InputStream getStreamByCommons(MultipartFile file) {
		CommonsMultipartFile cFile = (CommonsMultipartFile) file;
		DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
		InputStream stream = fileItem.getInputStream();
		stream.close();
		return stream;
	}

	/**
	 * 根据文件后缀进行分类
	 *
	 * @param file
	 * @return
	 */
	public String getFileTypeBySuffix(MultipartFile file) {
		String fileName = file.getOriginalFilename();
		assert fileName != null;
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		// 文件类型分类
		String[] imgTypes = new String[]{"jpg", "png", "gif"};
		String[] audioTypes = new String[]{"wav", "mp3"};
		String[] videoTypes = new String[]{"avi", "mp4", "rmvb", "wmv", "flv"};
		String[] docTypes = new String[]{"pdf", "docx", "doc"};
		if (isValid(suffix, imgTypes)) {
			return "image";
		} else if (isValid(suffix, audioTypes)) {
			return "audio";
		} else if (isValid(suffix, videoTypes)) {
			return "video";
		} else if (isValid(suffix, docTypes)) {
			return "doc";
		} else {
			return "other";
		}
	}

	public boolean isValid(String contentType, String... allowTypes) {
		if (null == contentType || "".equals(contentType)) {
			return false;
		}
		for (String type : allowTypes) {
			if (contentType.equals(type)) {
				return true;
			}
		}
		return false;
	}
}
