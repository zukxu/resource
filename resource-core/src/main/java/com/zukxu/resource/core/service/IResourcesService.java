package com.zukxu.resource.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.ResourceDTO;
import com.zukxu.resource.core.entity.Resources;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/17 0017 17:26
 */
public interface IResourcesService extends IService<Resources> {
	/**
	 * 分页查询列表
	 *
	 * @param entity
	 * @return
	 */
	IPage<ResourceDTO> pageInfo(PageDTO entity);

	/**
	 * 修改分类为未分类
	 *
	 * @param typeId
	 * @return
	 */
	int updResource(String typeId);

	/**
	 * 插入数据
	 *
	 * @param entity
	 * @return
	 */
	boolean insert(Resources entity);
}
