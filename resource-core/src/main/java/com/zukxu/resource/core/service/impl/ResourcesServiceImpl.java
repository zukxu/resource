package com.zukxu.resource.core.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.ResourceDTO;
import com.zukxu.resource.core.entity.ResourceAffair;
import com.zukxu.resource.core.entity.Resources;
import com.zukxu.resource.core.mapper.ResourcesMapper;
import com.zukxu.resource.core.service.IResourceAffairService;
import com.zukxu.resource.core.service.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/17 0017 17:26
 */
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources> implements IResourcesService {

	@Autowired
	ResourcesMapper resourcesMapper;
	@Autowired
	IResourceAffairService affairService;

	@Override
	public IPage<ResourceDTO> pageInfo(PageDTO entity) {
		entity.setNewOffset();
		IPage<ResourceDTO> page = new Page<>(entity.getCurrent(), entity.getSize());
		List<ResourceDTO> list = resourcesMapper.listInfo(entity);
		page.setRecords(list);
		QueryWrapper<Resources> wrapper = new QueryWrapper<>();
		if (StrUtil.isNotBlank(entity.getIndex())) {
			wrapper.lambda().eq(Resources::getTypeId, entity.getIndex());
		}
		if (StrUtil.isNotBlank(entity.getFields())) {
			wrapper.lambda().like(Resources::getName, entity.getFields());
		}
		page.setTotal(resourcesMapper.selectCount(wrapper));
		return page;
	}

	@Override
	public int updResource(String typeId) {
		return resourcesMapper.updResource(typeId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean insert(Resources entity) {
		int insert = resourcesMapper.insertResource(entity);
		if (0 == insert) {
			return false;
		}
		ResourceAffair affair = new ResourceAffair();
		affair.setRelationId(entity.getId());
		return affairService.save(affair);
	}
}



