package com.zukxu.resource.common.utils;

import com.zukxu.resource.common.result.enums.FileTypeEnums;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>
 * 文件类型判断
 * </p>
 *
 * @author zukxu
 * @date 2021/1/7 0007 10:50
 */
public final class FileTypeJudge {

	/**
	 * Constructor
	 */
	private FileTypeJudge() {
	}

	/**
	 * 将文件头转换成16进制字符串
	 *
	 * @param src
	 * @return 16进制字符串
	 */
	private static String bytesToHexString(byte[] src) {

		StringBuilder stringBuilder = new StringBuilder();
		if (src == null || src.length <= 0) {
			return null;
		}
		for (byte b : src) {
			int v = b & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
		return stringBuilder.toString();
	}

	/**
	 * 得到文件头
	 *
	 * @param is 文件流
	 * @return 文件头
	 * @throws IOException
	 */
	private static String getFileContent(InputStream is) {

		byte[] b = new byte[28];

		try {
			is.read(b, 0, 28);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytesToHexString(b);
	}

	/**
	 * 判断文件类型
	 *
	 * @param is 文件流
	 * @return 文件类型
	 */
	public static FileTypeEnums getType(InputStream is) throws IOException {

		String fileHead = getFileContent(is);
		if (fileHead == null || fileHead.length() == 0) {
			return null;
		}
		fileHead = fileHead.toUpperCase();
		System.out.println(fileHead);
		FileTypeEnums[] fileTypes = FileTypeEnums.values();

		for (FileTypeEnums type : fileTypes) {
			if (fileHead.startsWith(type.getValue())) {
				System.out.println(type);
				return type;
			}
		}
		return null;
	}

	/**
	 * @param value 表示文件类型
	 * @return
	 */
	public static Integer isFileType(FileTypeEnums value) {
		// 其他
		int type = 7;
		// 图片
		FileTypeEnums[] exe = {FileTypeEnums.EXE};

		FileTypeEnums[] docs = {FileTypeEnums.RTF, FileTypeEnums.XML, FileTypeEnums.HTML, FileTypeEnums.CSS, FileTypeEnums.JS, FileTypeEnums.EML, FileTypeEnums.DBX, FileTypeEnums.PST, FileTypeEnums.XLS_DOC, FileTypeEnums.XLSX_DOCX, FileTypeEnums.VSD,
				FileTypeEnums.MDB, FileTypeEnums.WPS, FileTypeEnums.WPD, FileTypeEnums.EPS, FileTypeEnums.PDF, FileTypeEnums.QDF, FileTypeEnums.PWL, FileTypeEnums.ZIP, FileTypeEnums.RAR, FileTypeEnums.JSP, FileTypeEnums.JAVA, FileTypeEnums.CLASS,
				FileTypeEnums.JAR, FileTypeEnums.MF, FileTypeEnums.CHM};

		FileTypeEnums[] rar = {FileTypeEnums.ZIP, FileTypeEnums.RAR, FileTypeEnums.GZ, FileTypeEnums.TAR};

		FileTypeEnums[] pics = {FileTypeEnums.JPEG, FileTypeEnums.PNG, FileTypeEnums.GIF, FileTypeEnums.TIFF, FileTypeEnums.BMP, FileTypeEnums.DWG, FileTypeEnums.PSD, FileTypeEnums.RAW};

		FileTypeEnums[] audios = {FileTypeEnums.WAV, FileTypeEnums.MP3, FileTypeEnums.FLAC, FileTypeEnums.APE};

		FileTypeEnums[] videos = {FileTypeEnums.AVI, FileTypeEnums.RAM, FileTypeEnums.RM, FileTypeEnums.MPG, FileTypeEnums.MOV, FileTypeEnums.ASF, FileTypeEnums.MP4, FileTypeEnums.FLV, FileTypeEnums.MID};

		// 程序
		if (FileTypeEnums.EXE.equals(value)) {
			type = 1;
			return type;
		}
		// 文档
		for (FileTypeEnums fileType : docs) {
			if (fileType.equals(value)) {
				type = 2;
				return type;
			}
		}
		// 压缩格式
		for (FileTypeEnums fileType : rar) {
			if (fileType.equals(value)) {
				type = 3;
				return type;
			}
		}
		// 图片
		for (FileTypeEnums fileType : pics) {
			if (fileType.equals(value)) {
				type = 4;
				return type;
			}
		}
		// 音乐
		for (FileTypeEnums fileType : audios) {
			if (fileType.equals(value)) {
				type = 5;
				return type;
			}
		}
		// 视频
		for (FileTypeEnums fileType : videos) {
			if (fileType.equals(value)) {
				type = 6;
				return type;
			}
		}

		return type;
	}
}
