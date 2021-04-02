package com.zukxu.resource.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.TypeDTO;
import com.zukxu.resource.core.entity.ResourceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
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
public interface ResourceTypeMapper extends BaseMapper<ResourceType> {
	/**
	 * 根据中文进行排序
	 *
	 * @param entity
	 * @return
	 */
	List<ResourceType> selectByPage(@Param("page") PageDTO entity);

	/**
	 * 根据id查询
	 *
	 * @param parentId
	 * @param size
	 * @param offset
	 * @return
	 */
	List<TypeDTO> selectTypeById(@Param("parentId") Integer parentId, @Param("size") Integer size, @Param("offset") Integer offset);

	/**
	 * 查询每种分类的数量
	 * @return map
	 */
	List<HashMap<String, Integer>> countType();
}