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
 * <p>
 * $END
 * </p>
 *
 * @author zukxu
 * @date 2021/1/20 0020 11:32
 */

/**
 * 资源审核事务表
 */
@ApiModel(value = "ResourceAffair")
@Data
@TableName(value = "resource_affair")
public class ResourceAffair implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 主键id
	 */
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@ApiModelProperty(value = "主键id")
	private String id;

	/**
	 * 逻辑删除值（false删除，true存在）
	 */
	@TableField(value = "enable")
	@ApiModelProperty(value = "逻辑删除值（false删除，true存在）")
	private Boolean enable;
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
	 * 关联资源id
	 */
	@TableField(value = "relation_id")
	@ApiModelProperty(value = "关联资源id")
	private String relationId;

	/**
	 * 事务类型（
	 * 0-新增
	 * 1-修改
	 * 2-置顶
	 * 3-特殊
	 * )
	 */
	@TableField(value = "type")
	@ApiModelProperty(value = "事务类型（0-新增,1-修改,2-置顶,3-特殊,)")
	private Integer type;

	/**
	 * 事务状态（
	 * 0-待审核
	 * 1-审核失败
	 * 2-审核成功
	 * )
	 */
	@TableField(value = "status")
	@ApiModelProperty(value = "事务状态（0-待审核,1-审核失败,2-审核成功)")
	private Integer status;

	/**
	 * 处理意见
	 */
	@TableField(value = "handle_remark")
	@ApiModelProperty(value = "处理意见")
	private String handleRemark;
}