package com.zukxu.resource.controller.system;

import com.zukxu.resource.common.result.Result;
import com.zukxu.resource.common.result.enums.ResultStatus;
import com.zukxu.resource.core.entity.ResourceAffair;
import com.zukxu.resource.core.service.IResourceAffairService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 审核控制器
 * </p>
 *
 * @author zukxu
 * @date 2021/1/19 0019 15:25
 */
@RestController
@RequestMapping("/affair")
public class ResourceAffairController {

	@Autowired
	IResourceAffairService affairService;

	@ApiOperation("审核")
	@PutMapping
	public Boolean affair(ResourceAffair entity) {
		return affairService.updateById(entity);
	}

	@ApiOperation("批量审核")
	@PostMapping("/batchAffair")
	public Result batchAffair(@RequestBody Map params) {
		List<String> ids = Arrays.asList(params.get("ids").toString().split(","));
		List<String> failId = new ArrayList<>(ids.size());
		Boolean isOk = true;
		for (String id : ids) {
			if (0 == affairService.affair(id)) {
				isOk = false;
				failId.add(id);
				continue;
			}
		}
		return isOk ? Result.success() : Result.failure(ResultStatus.DATA_IS_WRONG, failId);

	}
}
