package com.zukxu.resource.common.exception;

import com.zukxu.resource.common.result.ResultStatus;
import lombok.Getter;

/**
 * <p>
 * 系统异常处理类
 * </p>
 *
 * @author zukxu
 * @date 2021/1/6 0006 11:55
 */
@Getter
public class ResultException extends Exception {

	/**
	 * 业务异常信息信息
	 */
	ResultStatus resultStatus;

	public ResultException() {
		this(ResultStatus.INTERNAL_SERVER_ERROR);
	}

	public ResultException(ResultStatus resultStatus) {
		super(resultStatus.getMessage());
		this.resultStatus = resultStatus;
	}
}