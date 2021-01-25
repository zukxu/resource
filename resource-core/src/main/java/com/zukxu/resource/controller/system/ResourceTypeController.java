package com.zukxu.resource.controller.system;

import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.model.dto.TypeDTO;
import com.zukxu.resource.common.result.Result;
import com.zukxu.resource.core.entity.ResourceType;
import com.zukxu.resource.core.service.IResourceTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Description: 分类请求处理
 *
 * @author zukxu
 * @date 2020/10/5 0005 2:17
 */
@Api("分类")
@RestController
@RequestMapping("/type")
public class ResourceTypeController {
	@Autowired
	IResourceTypeService typeService;

	@ApiOperation("查询分类列表")
	@GetMapping("/list")
	public List<TypeDTO> pageInfo(PageDTO entity) {
		return typeService.pageInfo(entity);
	}

	@ApiOperation("查询分类详情")
	@GetMapping
	public ResourceType get(@RequestParam(value = "id") String id) {
		return typeService.getById(id);
	}

	@ApiOperation("查询子级分类详情")
	@GetMapping("/getChildType")
	public List<ResourceType> getChildById(@RequestParam(value = "id") String id) {
		return typeService.getChildById(id);
	}

	@ApiOperation("新增分类")
	@PostMapping
	public Result add(@RequestBody ResourceType entity) {
		return typeService.save(entity) ? Result.success() : Result.failure();
	}

	@ApiOperation("更新分类")
	@PutMapping
	public Result upd(@RequestBody ResourceType entity) {
		return typeService.updateById(entity) ? Result.success() : Result.failure();
	}

	@ApiOperation("根据ID删除分类")
	@DeleteMapping
	public Result del(String id) {
		return typeService.delTypeById(id) ? Result.success() : Result.failure();
	}

}
