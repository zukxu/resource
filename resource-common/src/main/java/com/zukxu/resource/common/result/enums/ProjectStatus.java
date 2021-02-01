package com.zukxu.resource.common.result.enums;

/**
 * <p>
 * 系统状态码
 * </p>
 *
 * @author zukxu
 * @date 2021/1/6 0006 14:31
 */
public class ProjectStatus {
	/**
	 * 成功状态码
	 */
	public static final int SUCCESS = 1;

	// -------------------失败状态码----------------------
	/**
	 * 用户不存在
	 */
	public static final int USER_NOT_EXIST = 20001;
	/**
	 * 用户未登陆
	 */
	public static final int USER_NOT_LOGGED_IN = 20002;
	/**
	 * 用户名或密码错误
	 */
	public static final int USER_ACCOUNT_ERROR = 20003;
	/**
	 * 用户账户已被禁用
	 */
	public static final int USER_ACCOUNT_FORBIDDEN = 20004;

	/**
	 * 用户已存在
	 */
	public static final int USER_HAS_EXIST = 20005;

	// 业务错误
	/**
	 * 系统业务出现问题
	 */
	public static final int BUSINESS_ERROR = 30001;

	// 系统错误
	/**
	 * 系统内部错误
	 */
	public static final int SYSTEM_INNER_ERROR = 40001;

	// 数据错误
	/**
	 * 数据未找到
	 */
	public static final int DATA_NOT_FOUND = 50001;
	/**
	 * 数据有误
	 */
	public static final int DATA_IS_WRONG = 50002;
	/**
	 * 数据已存在
	 */
	public static final int DATA_ALREADY_EXISTED = 50003;

	// 接口错误
	/**
	 * 系统内部接口调用异常
	 */
	public static final int INTERFACE_INNER_INVOKE_ERROR = 60001;
	/**
	 * 系统外部接口调用异常
	 */
	public static final int INTERFACE_OUTER_INVOKE_ERROR = 60002;
	/**
	 * 接口禁止访问
	 */
	public static final int INTERFACE_FORBIDDEN = 60003;
	/**
	 * 接口地址无效
	 */
	public static final int INTERFACE_ADDRESS_INVALID = 60004;
	/**
	 * 接口请求超时
	 */
	public static final int INTERFACE_REQUEST_TIMEOUT = 60005;
	/**
	 * 接口负载过高
	 */
	public static final int INTERFACE_EXCEED_LOAD = 60006;

	// 权限错误
	/**
	 * 没有访问权限
	 */
	public static final int PERMISSION_NO_ACCESS = 70001;
	// 参数错误
	/**
	 * 参数为空
	 */
	public static final int PARAMS_IS_NULL = 80001;
	/**
	 * 参数不全
	 */
	public static final int PARAMS_NOT_COMPLETE = 80002;
	/**
	 * 参数类型错误
	 */
	public static final int PARAMS_TYPE_ERROR = 80003;
	/**
	 * 参数无效
	 */
	public static final int PARAMS_IS_INVALID = 80004;
	/**
	 * 参数无效
	 */
	public static final int PARAMS_ERROR = 80005;

}