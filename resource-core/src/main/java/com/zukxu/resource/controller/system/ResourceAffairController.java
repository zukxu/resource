package com.zukxu.resource.controller.system;

import com.zukxu.resource.core.service.IResourceAffairService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@PostMapping
	public int affair(String id) {
		return affairService.affair(id);
	}

	@ApiOperation("批量审核")
	@PostMapping("/batchAffair")
	public Boolean batchAffair(@RequestBody Map params) {
		List<String> ids = Arrays.asList(params.get("ids").toString().split(","));
		Boolean isOk = true;
		for (String id : ids) {
			if (0 == affairService.affair(id)) {
				isOk = false;
				break;
			}
		}
		return isOk;
	}
}
