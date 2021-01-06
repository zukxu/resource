package com.zukxu.resource.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 项目配置
 * </p>
 *
 * @author zukxu
 * @date 2020/12/4 0004 10:24
 */
@Component
@ConfigurationProperties(prefix = "ruoyi")
public class ProjectConfig {
	/**
	 * 上传路径
	 */
	private static String profile;
	/**
	 * 获取地址开关
	 */
	private static boolean addressEnabled;
	/**
	 * 项目名称
	 */
	private String name;
	/**
	 * 版本
	 */
	private String version;
	/**
	 * 版权年份
	 */
	private String copyrightYear;
	/**
	 * 实例演示开关
	 */
	private boolean demoEnabled;

	public static String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		ProjectConfig.profile = profile;
	}

	public static boolean isAddressEnabled() {
		return addressEnabled;
	}

	public void setAddressEnabled(boolean addressEnabled) {
		ProjectConfig.addressEnabled = addressEnabled;
	}

	/**
	 * 获取头像上传路径
	 */
	public static String getAvatarPath() {
		return getProfile() + "/avatar";
	}

	/**
	 * 获取下载路径
	 */
	public static String getDownloadPath() {
		return getProfile() + "/download/";
	}

	/**
	 * 获取上传路径
	 */
	public static String getUploadPath() {
		return getProfile() + "/upload";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCopyrightYear() {
		return copyrightYear;
	}

	public void setCopyrightYear(String copyrightYear) {
		this.copyrightYear = copyrightYear;
	}

	public boolean isDemoEnabled() {
		return demoEnabled;
	}

	public void setDemoEnabled(boolean demoEnabled) {
		this.demoEnabled = demoEnabled;
	}
}
