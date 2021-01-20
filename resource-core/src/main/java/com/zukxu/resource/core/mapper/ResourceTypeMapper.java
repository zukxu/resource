package com.zukxu.resource.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zukxu.resource.common.model.dto.PageDTO;import com.zukxu.resource.core.entity.ResourceType;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * <p>
 * $END
 * </p>
 *
 * @author zukxu
 * @date 2021/1/20 0020 16:24
 */
@Mapper
public interface ResourceTypeMapper extends BaseMapper<ResourceType> {
	/**
	 * 根据中文进行排序
	 *
	 * @param entity
	 * @return
	 */
	List<ResourceType> selectOrderByClomn(@Param("page") PageDTO entity);
}