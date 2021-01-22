package com.zukxu.resource.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.ResourceDTO;
import com.zukxu.resource.core.entity.Resources;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * $END
 * </p>
 *
 * @author zukxu
 * @date 2021/1/20 0020 16:24
 */
@Mapper
public interface ResourcesMapper extends BaseMapper<Resources> {
	/**
	 * 查询列表
	 *
	 * @param page 分页参数
	 * @return
	 */
	List<ResourceDTO> listInfo(@Param("page") PageDTO page);

	/**
	 * 更新分类为默认分类
	 *
	 * @param typeId
	 * @return
	 */
	int updResource(String typeId);

	/**
	 * 插入数据
	 *
	 * @param entity
	 * @return
	 */
	int insertResource(@Param("en") Resources entity);
}