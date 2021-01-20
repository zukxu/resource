package com.zukxu.resource.controller.system;

import com.zukxu.resource.common.model.dto.PageDTO;
import com.zukxu.resource.common.result.Result;
import com.zukxu.resource.core.entity.Resources;
import com.zukxu.resource.core.service.IResourcesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Description: 资源请求处理
 *
 * @author zukxu
 * @date 2020/10/5 0005 2:15
 */
@Api("资源")
@RestController
@RequestMapping("/resource")
public class ResourcesController {
	@Autowired
	IResourcesService resourcesService;

	@ApiOperation("查询资源列表")
	@GetMapping("/list")
	public Result pageInfo(PageDTO entity) {
		return Result.success(resourcesService.pageInfo(entity));
	}

	@ApiOperation("查询资源详情")
	@GetMapping
	public Result get(String id) {
		return Result.success(resourcesService.getById(id));
	}

	@ApiOperation("新增资源")
	@PostMapping
	public Result add(@RequestBody Resources entity) {
		return resourcesService.insert(entity) ? Result.success() : Result.failure();
	}

	@ApiOperation("更新资源")
	@PutMapping
	public Result upd(@RequestBody Resources entity) {
		return resourcesService.updateById(entity) ? Result.success() : Result.failure();
	}

	@ApiOperation("删除")
	@DeleteMapping
	public Result delete(String id) {
		return resourcesService.removeById(id) ? Result.success() : Result.failure();
	}

	@ApiOperation("批量删除")
	@DeleteMapping("/batchDel")
	public Result deleteBatch(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = Arrays.asList(idArray);
		return resourcesService.removeByIds(list) ? Result.success() : Result.failure();
	}
}
