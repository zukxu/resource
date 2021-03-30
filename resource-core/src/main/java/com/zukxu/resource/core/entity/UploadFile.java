package com.zukxu.resource.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
  *<p>
  * 文件上传记录表
  *</p>
  * @author zukxu
  * @date   2021/1/20 0020 16:24
  * 
 */
@ApiModel(value = "com-zukxu-resource-core-entity-UploadFile")
@Data
@TableName(value = "upload_file")
@Accessors(chain = true)
public class UploadFile implements Serializable {
	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;

	/**
	 * 访问路径
	 */
	@TableField(value = "url")
	@ApiModelProperty(value = "访问路径")
	private String url;

	/**
	 * 原始文件名
	 */
	@TableField(value = "origin_name")
	@ApiModelProperty(value = "原始文件名")
	private String originName;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 文件上传方式（0-本地上传，1-oss，2-minio）
	 */
	@TableField(value = "method")
	@ApiModelProperty(value = "文件上传方式（0-本地上传，1-oss，2-minio）")
	private Integer method;

	/**
	 * 备注
	 */
	@TableField(value = "remark")
	@ApiModelProperty(value = "备注")
	private String remark;

	private static final long serialVersionUID = 1L;
}