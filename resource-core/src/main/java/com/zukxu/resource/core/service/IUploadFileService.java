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
	 * @return fileDTO
	 */
	FileDTO fileUpload(MultipartFile file);

	/**
	 * 本地删除
	 * @param url 链接
	 * @return bool
	 */
	boolean fileDel(String url);

	/**
	 * minio文件上传
	 * @param file
	 * @return fileDTO
	 */
	FileDTO minioUpload(MultipartFile file);

	/**
	 * minio文件删除
	 * @param fileName 文件名
	 */
	void minioDel(String fileName);

	/**
	 * minio 创建文件夹
	 * @param dirName 文件夹名称
	 */
	void mkdir(String dirName);
}
