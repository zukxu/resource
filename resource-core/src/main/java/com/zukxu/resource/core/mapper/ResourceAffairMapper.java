package com.zukxu.resource.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zukxu.resource.core.entity.ResourceAffair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * $END
 * </p>
 *
 * @author zukxu
 * @date 2021/1/20 0020 16:24
 */
@Mapper
public interface ResourceAffairMapper extends BaseMapper<ResourceAffair> {
	/**
	 * 根据relationId查询
	 * @param id
	 * @return
	 */
	ResourceAffair selectByrelationId(@Param("relationId") String id);
}