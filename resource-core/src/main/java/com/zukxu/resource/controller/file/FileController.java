package com.zukxu.resource.controller.file;

import com.zukxu.resource.common.model.dto.FileDTO;
import com.zukxu.resource.common.result.Result;
import com.zukxu.resource.common.result.enums.ResultStatus;
import com.zukxu.resource.core.entity.UploadFile;
import com.zukxu.resource.core.service.IUploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/22 0022 10:26
 */
@Api("文件")
@RestController
@RequestMapping("/file")
public class FileController {
	@Autowired
	IUploadFileService uploadFileService;

	@ApiOperation(value = "获取文件")
	@GetMapping("/fileList")
	public Result<List<UploadFile>> getFile() {
		List<UploadFile> list = uploadFileService.list();
		return Result.success(list);
	}

	/**
	 * 文件上传
	 */
	@ApiOperation("文件本地上传")
	@PostMapping
	public Result<FileDTO> fileUpload(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty() || file.getSize() == 0) {
			return Result.failure(ResultStatus.PARAMS_IS_NULL);
		}
		return Result.success(uploadFileService.fileUpload(file));
	}

	/**
	 * 本地文件删除
	 */
	@ApiOperation("本地文件删除")
	@DeleteMapping("/file/del/{url}")
	public Result<Void> fileDel(@PathVariable("url") String url) {
		uploadFileService.fileDel(url);
		return Result.success();
	}
}
