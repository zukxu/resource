package com.zukxu.resource.controller.file;

import com.zukxu.resource.common.config.properties.MinioProperties;
import com.zukxu.resource.common.entity.model.ApiResult;
import com.zukxu.resource.common.utils.FileUtils;
import com.zukxu.resource.common.utils.MinioUtils;
import com.zukxu.resource.core.entity.UploadFile;
import com.zukxu.resource.core.service.IUploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/22 0022 10:26
 */
@Api("文件")
@RestController
public class FileController {
	@Autowired
	IUploadFileService uploadFileService;

	@ApiOperation(value = "获取文件")
	@GetMapping("/fileList")
	public ApiResult getFile() {
		List<UploadFile> list = uploadFileService.list();
		return ApiResult.success(list);
	}

	/**
	 * 文件上传
	 */
	@ApiOperation("文件本地上传")
	@PostMapping("/file")
	public ApiResult fileUpload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty() || file.getSize() == 0) {
			return ApiResult.error("文件为空");
		}
		String path = uploadFileService.fileUpload(file);
		return ApiResult.success(path);
	}
	/**
	 * 本地文件删除
	 */
	@ApiOperation("本地文件删除")
	@DeleteMapping("/file/del")
	public ApiResult fileDel(String url) {
		uploadFileService.fileDel(url);
		return ApiResult.success();
	}

	/**
	 * 文件上传
	 */
	@ApiOperation("minio文件上传")
	@PostMapping("/minio")
	public ApiResult minio(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty() || file.getSize() == 0) {
			return ApiResult.error("文件为空");
		}
		String path = uploadFileService.minioUpload(file);
		return ApiResult.success(path);
	}

	/**
	 * minio文件删除
	 */
	@ApiOperation("minio文件删除")
	@DeleteMapping("/minio/del")
	public ApiResult minioDel(String fileName) {
		uploadFileService.minioDel(fileName);
		return ApiResult.success();
	}
}
