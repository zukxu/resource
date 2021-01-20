package com.zukxu.resource.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zukxu.resource.core.entity.ResourceAffair;

/**
 * <p>
 * $END
 * </p>
 *
 * @author zukxu
 * @date 2021/1/20 0020 11:32
 */
public interface IResourceAffairService extends IService<ResourceAffair> {

	/**
	 * 审核资源
	 *
	 * @param id
	 * @return
	 */
	int affair(String id);
}
