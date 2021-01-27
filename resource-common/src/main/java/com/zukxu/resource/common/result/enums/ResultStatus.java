package com.zukxu.resource.common.result.enums;

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
	SUCCESS(ProjectStatus.SUCCESS, "请求成功"),
	/**
	 * 参数错误
	 */
	PARAMS_ERROR(ProjectStatus.PARAMS_ERROR, "参数错误"),
	/**
	 * 服务异常
	 */
	SYSTEM_INNER_ERROR(ProjectStatus.SYSTEM_INNER_ERROR, "系统内部异常"),
	/**
	 * 参数为空
	 */
	PARAMS_IS_NULL(ProjectStatus.PARAMS_IS_NULL, "参数为空"),
	/**
	 * 参数错误
	 */
	DATA_IS_WRONG(ProjectStatus.DATA_IS_WRONG, "参数错误"),
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
