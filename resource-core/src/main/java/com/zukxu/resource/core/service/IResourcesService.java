package com.zukxu.resource.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zukxu.resource.common.entity.dto.PageDTO;
import com.zukxu.resource.common.entity.dto.ResourceDTO;
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
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	Boolean batchDel(String[] ids);

	/**
	 * 修改分类为未分类
	 *
	 * @param typeId
	 * @return
	 */
	int updResource(String typeId);

}
