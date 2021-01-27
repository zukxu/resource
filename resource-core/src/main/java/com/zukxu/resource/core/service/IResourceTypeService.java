package com.zukxu.resource.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.TypeDTO;
import com.zukxu.resource.core.entity.ResourceType;

import java.util.List;

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
	List<TypeDTO> pageInfo(PageDTO entity);

	/**
	 * 根据id进行删除
	 * @param id
	 * @return
	 */
	boolean delTypeById(String id);

	/**
	 * 获取子级分类
	 * @param id
	 * @return
	 */
	TypeDTO getChildById(String id);

	/**
	 * 新增分类
	 * @param entity
	 * @return
	 */
	boolean add(ResourceType entity);
}
