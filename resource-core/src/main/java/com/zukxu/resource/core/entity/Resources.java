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
  * 资源表
  *</p>
  * @author zukxu
  * @date   2021/1/20 0020 16:24
  * 
 */

@ApiModel(value = "com-zukxu-resource-core-entity-Resources")
@Data
@TableName(value = "resources")
public class Resources implements Serializable {
	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	@ApiModelProperty(value = "主键id")
	private Integer id;

	/**
	 * 资源名
	 */
	@TableField(value = "name")
	@ApiModelProperty(value = "资源名")
	private String name;

	/**
	 * 资源内容
	 */
	@TableField(value = "content")
	@ApiModelProperty(value = "资源内容")
	private String content;

	/**
	 * 资源分类Id
	 */
	@TableField(value = "type_id")
	@ApiModelProperty(value = "资源分类Id")
	private Integer typeId;

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
	 * 逻辑删除值,是否删除
	 */
	@TableField(value = "enable")
	@ApiModelProperty(value = "逻辑删除值,是否删除")
	private Boolean enable;

	/**
	 * 备注
	 */
	@TableField(value = "remark")
	@ApiModelProperty(value = "备注")
	private String remark;

	private static final long serialVersionUID = 1L;
}