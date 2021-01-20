package com.zukxu.resource.controller.system;

import com.zukxu.resource.core.service.IResourceAffairService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping
	public int affair(String id) {
		return affairService.affair(id);
	}

	@ApiOperation("批量审核")
	@GetMapping("/batchAffair")
	@Transactional
	public int batchAffair(String ids) {
		String[] split = ids.split(",");
		for (String id : split) {

		}
		return 0;
	}
}
