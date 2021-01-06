package com.zukxu.resource.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.zukxu.resource.common.config.properties.MinioProperties;
import io.minio.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.DeleteObject;
import io.minio.messages.Item;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 *
 * </p>
 *
 * @author zukxu
 * @date 2020/12/31 0031 16:12
 */
@Slf4j
@Component
public class MinioUtils {
	@Autowired
	private MinioClient minioClient;
	@Autowired
	private MinioProperties minio;


	// 存储桶操作

	/**
	 * <p>
	 * makeBucket创建一个新的存储桶
	 * 创建bucket
	 *
	 * @param bucketName bucket名称
	 */
	@SneakyThrows
	public void makeBucket(String bucketName) {
		if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
			minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
		}
	}

	/**
	 * listBuckets
	 * 获取全部bucket
	 * <p>
	 */
	@SneakyThrows
	public List<Bucket> listBuckets() {
		return minioClient.listBuckets();
	}

	/**
	 * 根据bucketName获取信息
	 *
	 * @param bucketName bucket名称
	 */
	@SneakyThrows
	public Optional<Bucket> getBucket(String bucketName) {
		return listBuckets().stream().filter(b -> b.name().equals(bucketName)).findFirst();
	}

	/**
	 * bucketExists
	 * 验证bucketName是否存在
	 *
	 * @return boolean true:存在
	 */
	@SneakyThrows
	public boolean bucketExists() {
		return minioClient.bucketExists(BucketExistsArgs.builder().bucket(minio.getBucketName()).build());
	}

	/**
	 * removeBucket
	 * 根据bucketName删除信息
	 *
	 * @param bucketName bucket名称
	 */
	@SneakyThrows
	public void removeBucket(String bucketName) {
		minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucketName).build());
	}

	/**
	 * listObjects 列出存储桶中所有对象
	 *
	 * @param bucketName bucket名称
	 * @param prefix     文件名称，默认为空
	 * @param recursive  是否递归查找，如果是false,就模拟文件夹结构查找
	 * @return 二进制流
	 */
	public Iterable<Result<Item>> listObjects(String bucketName, String prefix, boolean recursive) {
		return minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).prefix(prefix).recursive(recursive).build());
	}

	/**
	 * listIncompleteUploads
	 * 列出存储桶中被部分上传的对象
	 */

	// 文件对象操作

	/**
	 * getObject 以流的形式下载一个对象
	 * 获取文件流
	 *
	 * @param bucketName bucket名称
	 * @param objectName 文件名称
	 * @return 二进制流
	 */
	@SneakyThrows
	public InputStream getObject(String bucketName, String objectName) {
		minioClient.statObject(StatObjectArgs.builder()
				.bucket(bucketName).object(objectName)
				.build());
		return minioClient.getObject(
				GetObjectArgs.builder()
						.bucket(bucketName)
						.object(objectName)
						.build());
	}

	/**
	 * 断点下载
	 *
	 * @param bucketName 桶名
	 * @param objectName 文件名
	 * @param offset     起始字节
	 * @param length     是要读取的长度 (可选，如果无值则代表读到文件结尾)。
	 * @return
	 */
	@SneakyThrows
	public InputStream getObject(String bucketName, String objectName, long offset, Long length) {
		statObject(bucketName, objectName);
		return minioClient.getObject(
				GetObjectArgs.builder()
						.bucket(bucketName)
						.object(objectName)
						.offset(offset)
						.length(length)
						.build());
	}

	/**
	 * putObject
	 * /**
	 * 通过流上传文件
	 *
	 * @param bucketName  存储桶
	 * @param objectName  文件对象
	 * @param stream      文件流
	 * @param size        要上传的stream的size
	 * @param contentType contentType
	 */
	@SneakyThrows
	public void putObject(String bucketName, String objectName, InputStream stream, long size, String contentType) {
		minioClient.putObject(PutObjectArgs.builder()
				.bucket(bucketName)
				.object(objectName)
				.stream(stream, size, -1)
				.contentType(contentType)
				.build());
	}

	/**
	 * 更新文件
	 *
	 * @param bucketName
	 * @param objectName
	 * @param inputStream
	 */
	@SneakyThrows
	public void putObject(String bucketName, String objectName, InputStream inputStream) {
		putObject(bucketName, objectName, inputStream, inputStream.available(), "");
	}

	/**
	 * 上传本地文件
	 *
	 * @param bucketName 存储桶
	 * @param objectName 对象名称
	 * @param fileName   本地文件路径
	 */
	@SneakyThrows
	public ObjectWriteResponse putObject(String bucketName, String objectName,
										 String fileName) {
		return minioClient.uploadObject(UploadObjectArgs.builder()
				.bucket(bucketName)
				.object(objectName)
				.filename(fileName)
				.build());
	}


	/**
	 * copyObject 从objectName指定的对象中将数据拷贝到destObjectName指定的对象。
	 *
	 * @param bucketName     源桶名
	 * @param objectName     源对象名
	 * @param destBucketName 目标存储桶名
	 * @param destObjectName 目标对象名
	 */
	@SneakyThrows
	public void copyObject(String bucketName, String objectName, String destBucketName, String destObjectName) {
		minioClient.copyObject(CopyObjectArgs.builder()
				.source(CopySource.builder().bucket(bucketName).object(objectName).build())
				.bucket(destBucketName)
				.object(destBucketName)
				.build());
	}

	/**
	 * 判断文件是否存在
	 *
	 * @param bucketName 存储桶
	 * @param objectName 对象
	 * @return true：存在
	 */
	@SneakyThrows
	public boolean isObjectExist(String bucketName, String objectName) {
		boolean exist = true;
		try {
			statObject(bucketName, objectName);
		} catch (Exception e) {
			exist = false;
		}
		return exist;
	}

	/**
	 * 判断文件夹是否存在
	 *
	 * @param bucketName 存储桶
	 * @param objectName 文件夹名称（去掉/）
	 * @return true：存在
	 */
	public boolean isFolderExist(String bucketName, String objectName) {
		boolean exist = false;
		try {
			Iterable<Result<Item>> results = listObjects(bucketName, objectName, false);
			for (Result<Item> result : results) {
				Item item = result.get();
				if (item.isDir() && objectName.equals(item.objectName())) {
					exist = true;
				}
			}
		} catch (Exception e) {
			exist = false;
		}
		return exist;
	}

	/**
	 * 创建文件夹或目录
	 *
	 * @param bucketName 存储桶
	 * @param objectName 目录路径,要有目录前缀/
	 */
	@SneakyThrows
	public ObjectWriteResponse makeDir(String bucketName, String objectName) {
		return minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName)
				.stream(new ByteArrayInputStream(new byte[]{}), 0, -1)
				.build());
	}

	/**
	 * statObject 获取对象的元数据。用于判断文件是否存在
	 * /**
	 * 获取文件信息, 如果抛出异常则说明文件不存在
	 *
	 * @param bucketName bucket名称
	 * @param objectName 文件名称
	 */
	@SneakyThrows
	public void statObject(String bucketName, String objectName) {
		minioClient.statObject(StatObjectArgs.builder().bucket(bucketName).object(objectName).build());
	}

	/**
	 * removeObject 删除一个对象
	 */
	@SneakyThrows
	public void removeObject(String bucketName, String objectName) {
		minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
	}

	/**
	 * 批量删除
	 *
	 * @param bucketName 桶名
	 * @param keys       文件名列表
	 */
	public void removeObjects(String bucketName, List<String> keys) {
		List<DeleteObject> objects = new LinkedList<>();
		//构造批量删除的对象集合
		keys.forEach(s -> {
			objects.add(new DeleteObject(s));
		});
		try {
			minioClient.removeObjects(
					RemoveObjectsArgs.builder().bucket(bucketName).objects(objects).build());
		} catch (Exception e) {
			log.error("批量删除失败！{}", e);
		}
	}

	/**
	 * removeIncompleteUpload 删除一个未上传完整的对象
	 */


	// Presigned操作

	/**
	 * presignedGetObject
	 * 生成一个给HTTP GET请求用的presigned URL。浏览器/移动端的客户端可以用这个URL进行下载，即使其所在的存储桶是私有的。这个presigned URL可以设置一个失效时间，默认值是7天。
	 * <p>
	 * bucketName	存储桶名称。
	 * objectName	存储桶里的对象名称。
	 * expiry		失效时间（以秒为单位），默认是7天，不得大于七天。
	 */
	@SneakyThrows
	public String presignedGetObject(String bucketName, String objectName, Integer expires) {

		return minioClient.getPresignedObjectUrl(
				GetPresignedObjectUrlArgs.builder()
						.bucket(bucketName)
						.object(objectName)
						.method(Method.GET)
						.expiry(expires)
						.build());
	}
	/**
	 presignedPutObject
	 生成一个给HTTP PUT请求用的presigned URL。浏览器/移动端的客户端可以用这个URL进行上传，即使其所在的存储桶是私有的。这个presigned URL可以设置一个失效时间，默认值是7天。
	 */

	/**
	 * presignedPostPolicy 允许给POST请求的presigned URL设置策略，比如接收对象上传的存储桶名称的策略，key名称前缀，过期策略。
	 */
	@SneakyThrows
	public Map<String, String> presignedPostPolicy(PostPolicy policy) {

		return minioClient.getPresignedPostFormData(policy);
	}

	/**
	 * 存储桶策略
	 * getBucketPolicy
	 */
	@SneakyThrows
	public JSONObject getBucketPolicy(String bucketName) {
		String bucketPolicy = minioClient.getBucketPolicy(GetBucketPolicyArgs.builder().bucket(bucketName).build());
		return JSONObject.parseObject(bucketPolicy);
	}
	/**
	 setBucketPolicy 设置桶权限
	 */

	/**
	 * 获取上传文件的基础路径
	 *
	 * @return url
	 */
	public String getBasisUrl() {
		String separator = "/";
		return minio.getEndpoint() + separator + minio.getBucketName() + separator;
	}
}
