package com.zukxu.resource.core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description: 资源表
 *
 * @author zukxu
 * @date 2020/10/21 0021 16:11
 */

@ApiModel(value = "Resources")
@Data
public class Resources implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键id")
	private String id;
	/**
	 * 资源名
	 */
	@ApiModelProperty(value = "资源名")
	private String name;
	/**
	 * 资源内容
	 */
	@ApiModelProperty(value = "资源内容")
	private String content;
	/**
	 * 资源分类Id
	 */
	@ApiModelProperty(value = "资源分类Id")
	private String typeId;
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