package com.zukxu.resource.controller.test;

import com.zukxu.resource.common.result.Result;
import com.zukxu.resource.common.result.enums.ResultStatus;
import com.zukxu.resource.common.utils.SpringUtils;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;

/**
 * <p>
 * 测试Controller
 * </p>
 *
 * @author zukxu
 * @date 2021/1/22 0022 16:46
 */
@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {

	@ApiOperation("批量审核")
	@PostMapping("/batchAffair")
	public Result batchAffair1(@RequestBody Map params) {
		long l = System.currentTimeMillis();
		List<String> ids = Arrays.asList(params.get("ids").toString().split(","));
		List<String> failId = new ArrayList<>(ids.size());
		boolean isOk = true;
		multiProcess(ids);

		System.out.println("运行时间");
		System.out.println((System.currentTimeMillis() - l) / 1000 + "S");
		return isOk ? Result.success() : Result.failure(ResultStatus.DATA_IS_WRONG, failId);

	}


	public String singleProcess(String input) {
		log.info("Processing...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return new String("false, null");
		}
		return new String("success");
	}

	/**
	 * 批量处理
	 *
	 * @param inputList 输入对象列表
	 * @return 输出对象列表
	 */

	public List<String> multiProcess(List<String> inputList) {
		ThreadPoolTaskExecutor executor = SpringUtils.getBean("threadPoolTaskExecutor", ThreadPoolTaskExecutor.class);
		CountDownLatch latch = new CountDownLatch(inputList.size());
		List<String> outputList = Collections.synchronizedList(new ArrayList<>(inputList.size()));

		for (String input : inputList) {
			executor.execute(() -> {
				try {
					String output = singleProcess(input);
					outputList.add(output);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					latch.countDown();
				}
			});
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return outputList;
	}

	/**
	 * 异步处理
	 *
	 * @param input 输入对象
	 * @return 输出Future对象
	 */
	@Async("threadPoolTaskExecutor")
	public Future<String> asyncProcess(String input) {
		return new AsyncResult<>(singleProcess(input));
	}
}
