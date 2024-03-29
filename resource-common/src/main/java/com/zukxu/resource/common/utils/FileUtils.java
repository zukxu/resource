package com.zukxu.resource.common.utils;

import cn.hutool.core.lang.UUID;
import lombok.SneakyThrows;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

/**
 * <p>
 * 文件上传工具类
 * </p>
 *
 * @author zukxu
 * @date 2020/12/31 0031 11:44
 */
public final class FileUtils {
	private FileUtils() {
	}

	/**
	 * 获取随机文件名
	 *
	 * @return InputStream
	 */
	@SneakyThrows
	public static String getRandomFileName(String fileName) {
		return UUID.randomUUID()+getSuffix(fileName);
	}
	/**
	 * 获取文件后缀
	 * @param fileName 文件名
	 * @return 后缀
	 */
	public static String getSuffix(String fileName){
		return fileName.substring(fileName.lastIndexOf("."));
	}

	/**
	 * 通过字节数组的方式获取文件流
	 *
	 * @param file MultipartFile文件
	 * @return InputStream
	 */
	@SneakyThrows
	public static InputStream getStreamByByte(MultipartFile file) {
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
	public static InputStream getStreamByCommons(MultipartFile file) {
		CommonsMultipartFile cFile = (CommonsMultipartFile) file;
		DiskFileItem fileItem = (DiskFileItem) cFile.getFileItem();
		InputStream stream = fileItem.getInputStream();
		stream.close();
		return stream;
	}

	/**
	 * 根据文件后缀进行分类
	 *
	 * @param file 文件
	 * @return 分类
	 */
	public static String getFileTypeBySuffix(MultipartFile file) {
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

	public static boolean isValid(String contentType, String... allowTypes) {
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

	/**
	 * 获取当前host
	 * @param uri url
	 * @return URI
	 */
	public static URI getHost(URI uri) {
		URI effectiveURI = null;
		try {
			effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
		} catch (Throwable var4) {
			effectiveURI = null;
		}
		return effectiveURI;
	}
}
