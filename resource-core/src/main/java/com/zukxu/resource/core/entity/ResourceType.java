package com.zukxu.resource.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description: 资源分类表
 *
 * @author zukxu
 * @date 2020/10/21 0021 16:11
 */
@ApiModel(value = "ResourceType")
@Data
public class ResourceType implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键id")
	private String id;
	/**
	 * 资源分类名
	 */
	@ApiModelProperty(value = "资源分类名")
	private String typeName;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime updateTime;
	/**
	 * 逻辑删除值（false删除，true存在）
	 */
	@ApiModelProperty(value = "逻辑删除值（false删除，true存在）")
	private Boolean enable;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;
}