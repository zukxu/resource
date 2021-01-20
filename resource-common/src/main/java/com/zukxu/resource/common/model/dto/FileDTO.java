package com.zukxu.resource.common.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

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
	 * 访问路径
	 */
	private String url;
	/**
	 * 预览链接
	 */
	private String thumbUrl;
	/**
	 * 文件名
	 */
	private String originName;
	/**
	 * 上传文件名
	 */
	private String objectName;
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
}