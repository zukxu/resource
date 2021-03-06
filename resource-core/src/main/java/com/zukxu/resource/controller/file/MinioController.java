package com.zukxu.resource.controller.file;

import com.zukxu.resource.common.model.dto.FileDTO;
import com.zukxu.resource.common.result.Result;
import com.zukxu.resource.common.result.annotations.ResponseResultBody;
import com.zukxu.resource.common.result.enums.ResultStatus;
import com.zukxu.resource.core.service.IUploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/22 0022 10:26
 */
@Api("minio文件")
@RestController
@RequestMapping("/minio")
@ResponseResultBody
public class MinioController {
	@Autowired
	IUploadFileService uploadFileService;

	@ApiOperation(value = "获取文件列表")
	@GetMapping("/list")
	public List getFile() {
		return uploadFileService.list();
	}

	/**
	 * 创建文件夹
	 */
	@ApiOperation("minio创建文件夹")
	@PostMapping("/makeDir/{dir}")
	public void makeDir(@RequestBody Map map) {
		//判断路径是否以/结尾
		uploadFileService.minioMkdir((String) map.get("name"));
	}

	/**
	 * 文件上传
	 */
	@ApiOperation("minio文件上传")
	@PostMapping
	public Result minio(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty() || file.getSize() == 0) {
			return Result.failure(ResultStatus.PARAMS_IS_NULL);
		}
		FileDTO fileDTO = uploadFileService.minioUpload(file);
		return Result.success(fileDTO);
	}

	/**
	 * minio文件删除
	 */
	@ApiOperation("minio文件删除")
	@DeleteMapping("/del/{url}")
	public Result minioDel(@PathVariable("url") String fileName) {
		uploadFileService.minioDel(fileName);
		return Result.success();
	}
}
