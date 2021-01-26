package com.zukxu.resource.core.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.TypeDTO;
import com.zukxu.resource.common.utils.MinioUtils;
import com.zukxu.resource.common.utils.StrToImg;
import com.zukxu.resource.core.entity.ResourceType;
import com.zukxu.resource.core.mapper.ResourceTypeMapper;
import com.zukxu.resource.core.service.IResourceTypeService;
import com.zukxu.resource.core.service.IResourcesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

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
	@Autowired
	private MinioUtils minioUtils;

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
		if (entity.getCurrent() != null && entity.getSize() != null) {
			entity.setNewOffset();
		}
		return typeMapper.selectTypeById(-1, entity.getSize(), entity.getOffset());
	}

	@Override
	public TypeDTO getChildById(String id) {
		//根据id查询详情
		TypeDTO typeDTO = new TypeDTO();
		ResourceType resourceType = typeMapper.selectById(id);
		BeanUtils.copyProperties(resourceType, typeDTO);

		List<TypeDTO> list = typeMapper.selectTypeById(Integer.valueOf(id), 10, 0);
		typeDTO.setChildren(list);
		return typeDTO;
	}

	@Override
	public boolean add(ResourceType entity) {
		if (StrUtil.isBlank(entity.getPics())) {
			BufferedImage image = StrToImg.generateImg(entity.getTypeName());
			InputStream stream = StrToImg.toUpload(image);
			String fileName = entity.getTypeName() + Math.abs(new Random().nextInt()) + ".jpg";
			minioUtils.putObject("res", fileName, stream);
			entity.setPics("res/" + fileName);
		}
		return typeMapper.insert(entity) > 0;
	}
}



