package com.zukxu.resource.common.entity.dto;

import lombok.Data;

/**
 * <p>
 * 文件上传返回封装
 * </p>
 *
 * @author zukxu
 * @date 2021/1/6 0006 11:36
 */
@Data
public class FileDTO {
	/**
	 * 文件名
	 */
	private String name;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 访问连接
	 */
	private String url;
	/**
	 * 缩略图链接
	 */
	private String thumbUrl;
}