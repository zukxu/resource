package com.zukxu.resource.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zukxu.resource.common.utils.URLUtils;
import com.zukxu.resource.core.entity.ResourceAffair;
import com.zukxu.resource.core.entity.Resources;
import com.zukxu.resource.core.mapper.ResourceAffairMapper;
import com.zukxu.resource.core.service.IResourceAffairService;
import com.zukxu.resource.core.service.IResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * <p>
 * $END
 * </p>
 *
 * @author zukxu
 * @date 2021/1/20 0020 11:32
 */
@Service
public class ResourceAffairServiceImpl extends ServiceImpl<ResourceAffairMapper, ResourceAffair> implements IResourceAffairService {

	@Autowired
	IResourcesService resourcesService;
	@Autowired
	ResourceAffairMapper affairMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int affair(String id) {
		Resources byId = resourcesService.getById(id);
		ResourceAffair resourceAffair = new ResourceAffair();
		resourceAffair.setRelationId(Integer.parseInt(id));
		resourceAffair.setType(1);
		if (-1 == URLUtils.isConnect(byId.getContent())) {
			//不能连通，进行移除(修改)
			if (resourcesService.removeById(id)) {
				//添加事务
				resourceAffair.setStatus(2);
				resourceAffair.setHandleRemark("资源地址无法访问");
				return affairMapper.insert(resourceAffair);
			}
		}
		return 0;
	}
}

