package com.zukxu.resource.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zukxu.resource.common.config.properties.MinioProperties;
import com.zukxu.resource.common.utils.FileUtils;
import com.zukxu.resource.common.utils.MinioUtils;
import com.zukxu.resource.core.entity.UploadFile;
import com.zukxu.resource.core.mapper.UploadFileMapper;
import com.zukxu.resource.core.service.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadFileServiceImpl.class);
	@Autowired
	UploadFileMapper uploadFileMapper;

	@Autowired
	private MinioProperties minio;
	@Autowired
	private MinioUtils minioUtils;
	@Autowired
	private FileUtils fileUtils;

	@Value("${file.uploadPath}")
	private String uploadPath;
	@Value("${file.returnPath}")
	private String returnPath;

	@Override
	public String fileUpload(MultipartFile file) {
		//文件新名称
		String newFileName = fileUtils.getRandomFileName(file.getOriginalFilename());
		//设置文件存储路径，可以存放在你想要指定的路径里面
		String filePath = uploadPath + "/" + newFileName;
		File newFile = new File(filePath);
		//判断目标文件所在目录是否存在
		if (!newFile.getParentFile().exists()) {
			//如果目标文件所在的目录不存在，则创建父目录
			newFile.getParentFile().mkdirs();
		}

		//将内存中的数据写入磁盘
		try {
			//使用此方法保存必须要绝对路径且文件夹必须已存在,否则报错
			file.transferTo(newFile);
			LOGGER.info("文件上传成功！");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//图片上传保存url
		String url = returnPath + "/" + newFileName;
		UploadFile uploadFile = new UploadFile();
		uploadFile.setOriginName(file.getOriginalFilename());
		uploadFile.setUrl(url);
		uploadFileMapper.insert(uploadFile);
		return url;
	}

	@Override
	public void fileDel(String url) {
		String name = url.substring(url.lastIndexOf("/") + 1);
		url = uploadPath + name;
		File file = new File(url);
		file.delete();
	}

	@Override
	public String minioUpload(MultipartFile file) {
		InputStream stream = fileUtils.getStreamByByte(file);
		// String bulkName = fileUtils.getFileTypeBySuffix(file);
		String bulkName =minio.getBucketName();
		// minioUtils
		String fileName = fileUtils.getRandomFileName(file.getOriginalFilename());
		minioUtils.putObject(bulkName, fileName, stream);
		String objectURL = minioUtils.presignedGetObject(minio.getBucketName(), fileName, 7);

		String path = bulkName + "/" + fileName;
		return path;
	}

	@Override
	public void minioDel(String fileName) {
		minioUtils.removeObject(minio.getBucketName(), fileName);
	}
}


