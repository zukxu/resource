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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	@Transactional(rollbackFor = Exception.class)
	public int affair(String id) {
		Resources byId = resourcesService.getById(id);
		ResourceAffair resourceAffair = affairMapper.selectByrelationId(id);
		assert resourceAffair != null;
		if (-1 == URLUtils.isConnect(byId.getContent())) {
			resourceAffair.setType(1);
			//不能连通，进行审核不通过
			resourceAffair.setStatus(1);
			//修改事务备注
			resourceAffair.setHandleRemark("资源地址无法访问");
			return affairMapper.updateById(resourceAffair);
		}
		return 2;
	}

	@Override
	public List<String> batchAffair(List<String> ids) {
		long l = System.currentTimeMillis();
		List<String> list = Collections.synchronizedList(new ArrayList<>(ids.size()));

		for (String id : ids) {
			if (0 == affair(id)) {
				list.add(id);
			}
		}
		System.out.println("运行时间" + (System.currentTimeMillis() - l) + "ms");
		return list;
	}
}

