package com.zukxu.resource.common.entity.dto;

import lombok.Data;

/**
 * Description: 分页对象
 *
 * @author zukxu
 * @date 2020/10/17 0017 17:39
 */
@Data
public class PageDTO {
	/**
	 * 当前页
	 */
	private Integer current;
	/**
	 * 查询大小
	 */
	private Integer size;
	/**
	 * 分页偏移量
	 */
	private Integer offset;
	/**
	 * 索引
	 */
	private String index;
	/**
	 * 搜索字段
	 */
	private String fields;
	/**
	 * 总共数量
	 */
	private Integer total;

	public void setNewOffset() {
		this.setOffset((this.getCurrent() - 1) * this.getSize());
	}
}
