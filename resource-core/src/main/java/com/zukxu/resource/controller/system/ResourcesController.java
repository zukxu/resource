package com.zukxu.resource.controller.system;

import com.zukxu.resource.common.entity.dto.PageDTO;
import com.zukxu.resource.common.entity.model.ApiResult;
import com.zukxu.resource.core.entity.Resources;
import com.zukxu.resource.core.service.IResourcesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public ApiResult pageInfo(PageDTO entity) {
		return ApiResult.success(resourcesService.pageInfo(entity));
	}

	@ApiOperation("查询资源详情")
	@GetMapping
	public ApiResult get(String id) {
		return ApiResult.success(resourcesService.getById(id));
	}

	@ApiOperation("新增资源")
	@PostMapping
	public ApiResult add(@RequestBody Resources entity) {
		return resourcesService.save(entity) ? ApiResult.success() : ApiResult.error();
	}

	@ApiOperation("更新资源")
	@PutMapping
	public ApiResult upd(@RequestBody Resources entity) {
		return resourcesService.updateById(entity) ? ApiResult.success() : ApiResult.error();
	}

	@ApiOperation("删除")
	@DeleteMapping
	public ApiResult delete(String id) {
		return resourcesService.removeById(id) ? ApiResult.success() : ApiResult.error();
	}
}
