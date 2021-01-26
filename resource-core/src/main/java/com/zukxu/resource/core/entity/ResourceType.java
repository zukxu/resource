package com.zukxu.resource.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
  *<p>
  *  资源分类表
  *</p>
  * @author zukxu
  * @date   2021/1/20 0020 16:24
  * 
 */
@ApiModel(value = "com-zukxu-resource-core-entity-ResourceType")
@Data
@TableName(value = "resource_type")
public class ResourceType implements Serializable {
	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time")
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime createTime;

	/**
	 * 更新时间
	 */
	@TableField(value = "update_time")
	@ApiModelProperty(value = "更新时间")
	private LocalDateTime updateTime;

	/**
	 * 逻辑删除值（false删除，true存在）
	 */
	@TableField(value = "enable")
	@ApiModelProperty(value = "逻辑删除值（false删除，true存在）")
	private Boolean enable;

	/**
	 * 备注
	 */
	@TableField(value = "remark")
	@ApiModelProperty(value = "备注")
	private String remark;

	/**
	 * 资源分类名
	 */
	@TableField(value = "type_name")
	@ApiModelProperty(value = "资源分类名")
	private String typeName;

	/**
	 * 排序值（大）
	 */
	@TableField(value = "sort")
	@ApiModelProperty(value = "排序值（大）")
	private Integer sort;

	/**
	 * 图标
	 */
	@TableField(value = "pics")
	@ApiModelProperty(value = "图标")
	private String  pics;
	/**
	 * 上层父id
	 */
	@TableField(value = "parent_id")
	@ApiModelProperty(value = "上层父id")
	private String  parentId;

	private static final long serialVersionUID = 1L;
}