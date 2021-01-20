package com.zukxu.resource.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zukxu.resource.common.utils.URLUtils;
import com.zukxu.resource.core.entity.ResourceAffair;
import com.zukxu.resource.core.mapper.ResourceAffairMapper;
import com.zukxu.resource.core.service.IResourceAffairService;
import org.springframework.stereotype.Service;
/**
  *<p>
  * $END
  *</p>
  * @author zukxu
  * @date   2021/1/20 0020 11:32
  * 
 */
@Service
public class ResourceAffairServiceImpl extends ServiceImpl<ResourceAffairMapper, ResourceAffair> implements IResourceAffairService {

	@Override
	public int affair(String id) {
		URLUtils.isConnect("");
		return 0;
	}
}
