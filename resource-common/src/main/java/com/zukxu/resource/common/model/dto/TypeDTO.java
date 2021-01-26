package com.zukxu.resource.common.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * Type DTO
 * </p>
 *
 * @author zukxu
 * @date 2021/1/25 0025 10:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "评论DTO对象")
@JsonIgnoreProperties(value = {"handler"})
public class TypeDTO {
	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键id")
	private Integer id;

	/**
	 * 资源分类名
	 */
	@ApiModelProperty(value = "资源分类名")
	private String typeName;

	/**
	 * 排序值（大）
	 */
	@ApiModelProperty(value = "排序值（大）")
	private Integer sort;

	/**
	 * 图标
	 */
	@ApiModelProperty(value = "图标")
	private String pics;
	/**
	 * 上层父id
	 */
	@ApiModelProperty(value = "上层父id")
	private String parentId;
	/**
	 * 子集
	 */
	private List<TypeDTO> children;
}
