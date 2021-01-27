package com.zukxu.resource.common.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 资源DTO
 * </p>
 *
 * @author zukxu
 * @date 2020/12/10 0010 16:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "资源DTO对象")
public class ResourceDTO {
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
	 * 分类名称
	 */
	@ApiModelProperty(value = "资源分类Id")
	private String typeName;
	/**
	 * 创建时间
	 */
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;
	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间")
	private LocalDateTime updateTime;
	/**
	 * 备注
	 */
	@ApiModelProperty(value = "备注")
	private String remark;
	/**
	 * icon地址
	 */
	@ApiModelProperty(value = "icon地址")
	private String icon;
}
