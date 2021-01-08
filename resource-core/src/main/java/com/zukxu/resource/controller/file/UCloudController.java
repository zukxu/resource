package com.zukxu.resource.controller.file;

import com.zukxu.resource.common.config.properties.UCloudProperties;
import com.zukxu.resource.common.utils.UCloudUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * <p>
 * UCloud服务提供者
 * </p>
 *
 * @author zukxu
 * @date 2021/1/7 0007 17:31
 */
@RestController
@RequestMapping("/uc")
public class UCloudController {

	/**
	 * ucloud 鉴黄
	 *
	 * @param imageUrl
	 * @return 返回值
	 * RetCode 0 标识正常 其余一律异常
	 * Suggestion 建议， pass-放行， forbid-封禁， check-人工审核
	 */
	@Autowired
	private UCloudProperties ucloud;

	@PostMapping
	public String check(String imageUrl) {
		try {
			//图片绝对路径
			imageUrl = ucloud.getUrl() +"/"+ imageUrl;
			RestTemplate rest = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			/**
			 * 生成signature，首字母排序
			 */
			String timestamp = System.currentTimeMillis() + "";
			SortedMap<Object, Object> packageParams = new TreeMap<>();
			packageParams.put("PublicKey", ucloud.getPublicKey());
			packageParams.put("ResourceId", ucloud.getResourceId());
			packageParams.put("Timestamp", timestamp);
			packageParams.put("Url", imageUrl);
			String signature = UCloudUtils.createSign(packageParams, ucloud.getPrivateKey());
			/**
			 * 参数
			 */
			MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
			param.add("Scenes", "porn");
			param.add("Method", "url");
			param.add("Url", imageUrl);
			/**
			 * headers 参数
			 */
			headers.setContentType(MediaType.parseMediaType("multipart/form-data; charset=UTF-8"));
			headers.set("PublicKey", ucloud.getPublicKey());
			headers.set("Signature", signature);
			headers.set("ResourceId", ucloud.getResourceId());
			headers.set("Timestamp", timestamp);
			HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(param, headers);
			ResponseEntity<String> responseEntity = rest.exchange(imageUrl, HttpMethod.POST, httpEntity,
					String.class);
			return responseEntity.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}