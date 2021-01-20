package com.zukxu.resource.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.core.entity.ResourceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/21 0021 16:11
 */
@Mapper
public interface ResourceTypeMapper extends BaseMapper<ResourceType> {
	/**
	 * 根据中文进行排序
	 * @return
	 * @param entity
	 */
	List<ResourceType> selectOrderByClomn(@Param("page") PageDTO entity);
}