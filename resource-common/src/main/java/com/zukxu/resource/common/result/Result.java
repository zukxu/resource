package com.zukxu.resource.common.result;


import cn.hutool.core.util.ObjectUtil;

/**
 * 返回结果封装
 *
 * @author zukxu
 * @date 2020-10-5 22:04:58
 */
public class Result<T> {
	/**
	 * 码
	 */
	private Integer code;
	/**
	 * 消息内容
	 */
	private String message;
	/**
	 * 数据对象
	 */
	private T data;

	/**
	 * 初始化一个新创建的 Result 对象，使其表示一个空消息。
	 */
	Result() {
	}

	private Result(T data) {
		this.code = 200;
		this.message = "success";
		this.data = data;
	}

	private Result(ResultStatus resultStatus, T data) {
		this.code = resultStatus.getCode();
		this.message = resultStatus.getMessage();
		this.data = data;
	}

	/**
	 * 初始化一个新创建的 Result 对象
	 *
	 * @param code    状态码
	 * @param message 返回内容
	 * @param data    数据对象
	 */
	private Result(int code, String message, T data) {
		this.code = code;
		this.message = message;
		if (ObjectUtil.isNotEmpty(data)) {
			this.data = data;
		}
	}

	/**
	 * 返回成功消息
	 *
	 * @return 成功消息
	 */
	public static <T> Result<T> success() {
		return new Result("操作成功");
	}

	/**
	 * 返回成功数据
	 *
	 * @return 成功消息
	 */
	public static <T> Result<T> success(T data) {
		return Result.success("操作成功", data);
	}

	/**
	 * 返回成功消息
	 *
	 * @param msg  返回内容
	 * @param data 数据对象
	 * @return 成功消息
	 */
	public static <T> Result<T> success(String msg, T data) {
		return Result.success(200, msg, data);
	}

	/**
	 * 返回成功消息
	 *
	 * @param msg  返回内容
	 * @param data 数据对象
	 * @return 成功消息
	 */
	public static <T> Result<T> success(Integer code, String msg, T data) {
		return new Result<T>(code, msg, data);
	}

	/**
	 * 返回错误消息
	 *
	 * @return
	 */
	public static <T> Result<T> error() {
		return Result.error("操作失败");
	}

	/**
	 * 返回错误消息
	 *
	 * @param msg 返回内容
	 * @return 警告消息
	 */
	public static <T> Result<T> error(String msg) {
		return Result.error(500, msg);
	}

	/**
	 * 返回错误消息
	 *
	 * @param code 状态码
	 * @param msg  返回内容
	 * @return 警告消息
	 */
	public static <T> Result<T> error(int code, String msg) {
		return Result.error(code, msg, null);
	}

	/**
	 * 返回错误消息
	 *
	 * @param code 编码
	 * @param msg  返回内容
	 * @param data 数据对象
	 * @return 警告消息
	 */
	public static <T> Result<T> error(Integer code, String msg, T data) {
		return new Result<T>(code, msg, data);
	}
}
