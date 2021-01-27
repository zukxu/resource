package com.zukxu.resource.common.config;

import com.zukxu.resource.common.config.properties.ThreadPoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * <p>
 * 多线程池配置类
 * </p>
 *
 * @author zukxu
 * @date 2021/1/22 0022 16:32
 */
@EnableAsync
@Configuration
public class ThreadPoolConfig {
	private final ThreadPoolProperties threadPoolProperties;

	@Autowired
	public ThreadPoolConfig(ThreadPoolProperties threadPoolProperties) {
		this.threadPoolProperties = threadPoolProperties;
	}

	@Bean(name = "threadPoolTaskExecutor")
	public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(threadPoolProperties.getCorePoolSize());
		executor.setMaxPoolSize(threadPoolProperties.getMaxPoolSize());
		executor.setQueueCapacity(threadPoolProperties.getQueueCapacity());
		executor.setKeepAliveSeconds(threadPoolProperties.getKeepAliveSeconds());
		executor.setThreadNamePrefix("thread-pool-");
		return executor;
	}
}
