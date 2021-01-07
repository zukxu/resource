package com.zukxu.resource.common.result.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * 文件夹分类
 * </p>
 *
 * @author zukxu
 * @date 2021/1/7 0007 11:21
 */
@Getter
@ToString
public enum FolderEnums {
	/**
	 * 可执行程序
	 */
	EXE(1, "exe"),
	/**
	 * 文档类
	 */
	DOC(2, "doc"),
	/**
	 * 压缩类
	 */
	ZIP(3, "zip"),
	/**
	 * 图片类
	 */
	IMG(4, "img"),
	/**
	 * 音频类
	 */
	AUDIO(5, "audio"),
	/**
	 * 视频类
	 */
	VIDEO(6, "video"),
	/**
	 * 其他
	 */
	OTHER(7, "other");


	private Integer value;
	private String folder;

	FolderEnums(Integer value, String folder) {
		this.value = value;
		this.folder = folder;
	}
}
