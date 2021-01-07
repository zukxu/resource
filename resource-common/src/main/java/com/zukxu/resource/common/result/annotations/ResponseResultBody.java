package com.zukxu.resource.common.result.annotations;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * <p>
 * 全局结果封装返回注解
 * 使用这个注解就可以返回统一的json格式,  用于类和方法上
 * </p>
 *
 * @author zukxu
 * @date 2021/1/6 0006 15:44
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseResultBody {

}
