package com.handler;

import com.entity.base.AjaxResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

import static com.Constant.*;


/**
 *全局异常处理
 *@author :Muggle.Wang
 *Create in 14:18 2021/8/3
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理数据库重复键值异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public AjaxResult<String> handleDuplicateKeyException(DuplicateKeyException e) {
        return new AjaxResult<String>().setData(EXCEPTION_DUPLICATE_KEY_INFO);
    }

    /**
     * 处理json解析异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = JsonProcessingException.class)
    public AjaxResult<String> handleJsonProcessingException(JsonProcessingException e) {
        return new AjaxResult<String>().setData(EXCEPTION_JSON_PROCESSING_INFO);
    }

    /**
     * ValidationException
     * @param e
     * @return
     */
    @ExceptionHandler(ValidationException.class)
    public AjaxResult<String> handleValidationException(ValidationException e) {
        return new AjaxResult<String>().setData(EXCEPTION_VALIDATION_INFO);
    }

    /**
     * 处理系统异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public AjaxResult<String> handleException(Exception e) {
        return new AjaxResult<String>().setData(EXCEPTION_INFO);
    }

}
