package com.zukxu.resource.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zukxu.resource.core.entity.ResourceAffair;

import java.util.List;

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
	 * 批量审核
	 * @param ids
	 * @return
	 */
	List<String> batchAffair(List<String> ids);
}
