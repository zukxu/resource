package com.zukxu.resource.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zukxu.resource.common.model.dto.FileDTO;
import com.zukxu.resource.core.entity.UploadFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/22 0022 09:59
 */
public interface IUploadFileService extends IService<UploadFile> {
	/**
	 * 图片上传至本地
	 *
	 * @param file
	 * @return
	 */
	FileDTO fileUpload(MultipartFile file);

	/**
	 * 本地删除
	 * @param url 链接
	 */
	void fileDel(String url);

	/**
	 * minio文件上传
	 * @param file
	 * @return
	 */
	FileDTO minioUpload(MultipartFile file);

	/**
	 * minio文件删除
	 * @param fileName
	 */
	void minioDel(String fileName);

	/**
	 * minio 创建文件夹
	 * @param name
	 */
	void mkdir(String name);
}
