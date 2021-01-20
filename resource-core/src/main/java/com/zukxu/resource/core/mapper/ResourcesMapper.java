package com.zukxu.resource.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.ResourceDTO;
import com.zukxu.resource.core.entity.Resources;
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
public interface ResourcesMapper extends BaseMapper<Resources> {
	/**
	 * 查询列表
	 * @param page 分页参数
	 * @return
	 */
	List<ResourceDTO> listInfo(@Param("page") PageDTO page);

	/**
	 * 更新分类为默认分类
	 * @param typeId
	 * @return
	 */
	int updResource(String typeId);
}