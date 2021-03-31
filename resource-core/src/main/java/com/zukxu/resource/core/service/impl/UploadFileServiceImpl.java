package com.zukxu.resource.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zukxu.resource.common.config.properties.FileUploadConfigProperties;
import com.zukxu.resource.common.config.properties.MinioProperties;
import com.zukxu.resource.common.model.dto.FileDTO;
import com.zukxu.resource.common.utils.FileUtils;
import com.zukxu.resource.common.utils.MinioUtils;
import com.zukxu.resource.core.entity.UploadFile;
import com.zukxu.resource.core.mapper.UploadFileMapper;
import com.zukxu.resource.core.service.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 *
 * @author zukxu
 * @date 2020/10/22 0022 09:59
 */
@Service
public class UploadFileServiceImpl extends ServiceImpl<UploadFileMapper, UploadFile> implements IUploadFileService {

	private static final Logger logger = LoggerFactory.getLogger(UploadFileServiceImpl.class);

	@Autowired
	UploadFileMapper uploadFileMapper;
	@Autowired
	FileUploadConfigProperties fileProperty;
	@Autowired
	private MinioProperties minio;
	@Autowired
	private MinioUtils minioUtils;

	@Override
	public FileDTO fileUpload(MultipartFile file) {
		//文件新名称
		String originalFilename = file.getOriginalFilename();
		String newFileName = FileUtils.getRandomFileName(originalFilename);
		//设置文件存储路径，可以存放在你想要指定的路径里面
		String filePath = fileProperty.getUploadPath() + "/" + newFileName;
		// 判断文件上传目录是否存在
		File newFile = new File(filePath);

		//将内存中的数据写入磁盘
		try {
			//使用此方法保存必须要绝对路径且文件夹必须已存在,否则报错
			file.transferTo(newFile);
			logger.info("文件上传成功！");
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("文件上传失败！");
		}
		//图片上传保存url
		String url = fileProperty.getReturnPath() + "/" + newFileName;
		UploadFile uploadFile = new UploadFile().setOriginName(originalFilename).setUrl(url);
		uploadFileMapper.insert(uploadFile);
		return new FileDTO().setOriginName(originalFilename).setObjectName(newFileName).setUrl(url);
	}

	@Override
	public boolean fileDel(String url) {
		String name = url.substring(url.lastIndexOf("/") + 1);
		url = fileProperty.getUploadPath() + name;
		File file = new File(url);
		return file.delete();
	}

	@Override
	public FileDTO minioUpload(MultipartFile file) {
		//获取文件流
		InputStream stream = FileUtils.getStreamByByte(file);
		String bulkName = minio.getBucketName();
		// minioUtils获取新的文件名，防止文件重复
		String originalFilename = file.getOriginalFilename();
		String fileName = FileUtils.getRandomFileName(originalFilename);
		//上传
		minioUtils.putObject(bulkName, fileName, stream);

		String url = bulkName + "/" + fileName;
		FileDTO fileDTO = new FileDTO();
		fileDTO.setUrl(url);
		fileDTO.setThumbUrl(minioUtils.getBasisUrl() + url);
		fileDTO.setOriginName(originalFilename);
		fileDTO.setObjectName(fileName);
		return fileDTO;
	}

	@Override
	public void minioMkdir(String dirName) {
		if (!dirName.endsWith("/")) {
			dirName += "/";
		}
		boolean folderExist = minioUtils.isFolderExist(minio.getBucketName(), dirName);
		if (!folderExist) {
			minioUtils.putObject(minio.getBucketName(), dirName, new ByteArrayInputStream(new byte[]{}));
		}
	}

	@Override
	public void minioDel(String fileName) {
		minioUtils.removeObject(minio.getBucketName(), fileName);
	}
}



