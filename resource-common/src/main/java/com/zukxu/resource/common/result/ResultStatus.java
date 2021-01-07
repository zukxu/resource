package com.zukxu.resource.common.result;

import lombok.Getter;
import lombok.ToString;

/**
 * <p>
 * 返回枚举类
 * </p>
 *
 * @author zukxu
 * @date 2021/1/6 0006 11:50
 */
@Getter
@ToString
public enum ResultStatus {
	/**
	 * 成功
	 */
	SUCCESS(SysStatus.SUCCESS, "请求成功"),
	/**
	 * 参数错误
	 */
	PARAMS_ERROR(SysStatus.PARAMS_ERROR, "参数错误"),
	/**
	 * 服务异常
	 */
	SYSTEM_INNER_ERROR(SysStatus.SYSTEM_INNER_ERROR, "系统内部异常"),
	/**
	 * 参数为空
	 */
	PARAMS_IS_NULL(SysStatus.PARAMS_IS_NULL, "参数为空"),
	;

	/**
	 * 系统代码
	 */
	private final Integer code;
	/**
	 * 消息
	 */
	private final String message;

	ResultStatus(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
}
