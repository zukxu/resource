package com.zukxu.resource.core.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.core.entity.ResourceType;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/17 0017 17:26
 */
public interface IResourceTypeService extends IService<ResourceType> {
	/**
	 * list all
	 * @param entity
	 * @return
	 */
	IPage<ResourceType> pageInfo(PageDTO entity);

	/**
	 * 根据id进行删除
	 * @param id
	 * @return
	 */
	boolean delTypeById(String id);
}
