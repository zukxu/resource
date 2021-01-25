package com.zukxu.resource.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.TypeDTO;
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
			resService.updResource(id);
			return true;
		}
		return false;
	}

	@Override
	public List<TypeDTO> pageInfo(PageDTO entity) {
		entity.setNewOffset();
		return typeMapper.selectTypeById(-1, entity.getSize(), entity.getOffset());
	}

	@Override
	public List<ResourceType> getChildById(String id) {
		QueryWrapper<ResourceType> wrapper = new QueryWrapper<>();
		wrapper.lambda().eq(ResourceType::getParentId, id);
		return typeMapper.selectList(wrapper);
	}
}



