package com.zukxu.resource.common.result;

import io.swagger.models.auth.In;
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
	SUCCESS(HttpStatus.SUCCESS, 200, "请求成功"),
	/**
	 * 参数错误
	 */
	PARAMS_ERROR(HttpStatus.PARAMS_ERROR, 400, "参数错误"),
	/**
	 * 服务异常
	 */
	SYSTEM_INNER_ERROR(HttpStatus.SYSTEM_INNER_ERROR, 500, "系统内部异常"),
	;
	/**
	 * HTTP状态码
	 */
	private Integer status;
	/**
	 * 系统代码
	 */
	private Integer code;
	/**
	 * 消息
	 */
	private String message;

	ResultStatus(Integer status, Integer code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
