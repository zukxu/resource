package com.zukxu.resource.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description: 文件上传记录表
 *
 * @author zukxu
 * @date 2020/10/22 0022 10:11
 */

@ApiModel(value = "UploadFile")
@Data
@TableName(value = "upload_file")
public class UploadFile implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@ApiModelProperty(value = "主键id")
	private String id;
	/**
	 * 访问路径
	 */
	@TableField(value = "url")
	@ApiModelProperty(value = "访问路径")
	private String url;
	/**
	 * 文件名
	 */
	@TableField(value = "origin_name")
	@ApiModelProperty(value = "文件名")
	private String originName;
	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;
	/**
	 * 备注
	 */
	@TableField(value = "method")
	@ApiModelProperty(value = "文件上传方式（0-本地上传，1-oss，2-minio）")
	private String method;
	/**
	 * 备注
	 */
	@TableField(value = "remark")
	@ApiModelProperty(value = "备注")
	private String remark;
}