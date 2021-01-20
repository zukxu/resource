package com.zukxu.resource.core.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.core.entity.ResourceType;
import com.zukxu.resource.core.mapper.ResourceTypeMapper;
import com.zukxu.resource.core.service.IResourceTypeService;
import com.zukxu.resource.core.service.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/17 0017 17:26
 */
@Service
public class ResourceTypeServiceImpl extends ServiceImpl<ResourceTypeMapper, ResourceType> implements IResourceTypeService {

	@Autowired
	ResourceTypeMapper typeMapper;
	@Autowired
	IResourcesService resService;

	@Override
	public boolean delTypeById(String id) {
		if (typeMapper.deleteById(id) > 0) {
			return resService.updResource(id) > 0;
		}
		return false;
	}

	@Override
	public IPage<ResourceType> pageInfo(PageDTO entity) {
		IPage<ResourceType> page = new Page<>();
		List<ResourceType> typeList = typeMapper.selectByPage(entity);
		if (entity.getCurrent() != null && entity.getSize() != null) {
			entity.setNewOffset();
			page.setCurrent(entity.getCurrent()).setSize(entity.getSize());
		}
		page.setRecords(typeList);
		return page;
	}
}



