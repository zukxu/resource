package com.zukxu.resource.common.result;


import com.zukxu.resource.common.result.enums.ResultStatus;
import lombok.Getter;
import lombok.ToString;

/**
 * 返回结果封装
 *
 * @author zukxu
 * @date 2020-10-5 22:04:58
 */
@Getter
@ToString
public class Result<T> {
	/**
	 * 业务错误码
	 */
	private Integer code;
	/**
	 * 信息描述
	 */
	private String message;
	/**
	 * 返回参数
	 */
	private T data;

	private Result(ResultStatus resultStatus, T data) {
		this.code = resultStatus.getCode();
		this.message = resultStatus.getMessage();
		this.data = data;
	}

	/**
	 * 业务成功返回业务代码和描述信息
	 */
	public static Result<Void> success() {
		return success(null);
	}

	/**
	 * 业务成功返回业务代码,描述和返回的参数
	 */
	public static <T> Result<T> success(T data) {
		return success(ResultStatus.SUCCESS, data);
	}

	/**
	 * 业务成功返回业务代码,描述和返回的参数
	 */
	public static <T> Result<T> success(ResultStatus resultStatus, T data) {
		if (resultStatus == null) {
			return success(data);
		}
		return new Result<>(resultStatus, data);
	}

	/**
	 * 业务异常返回业务代码和描述信息
	 */
	public static <T> Result<T> failure() {
		return failure(ResultStatus.SYSTEM_INNER_ERROR);
	}

	/**
	 * 业务异常返回业务代码,描述和返回的参数
	 */
	public static <T> Result<T> failure(ResultStatus resultStatus) {
		return failure(resultStatus, null);
	}

	/**
	 * 业务异常返回业务代码,描述和返回的参数
	 */
	public static <T> Result<T> failure(ResultStatus resultStatus, T data) {
		if (resultStatus == null) {
			return new Result<>(ResultStatus.SYSTEM_INNER_ERROR, null);
		}
		return new Result<>(resultStatus, data);
	}
}
