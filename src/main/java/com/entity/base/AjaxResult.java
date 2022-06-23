package com.entity.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;

import java.io.Serializable;

import static com.Constant.NUM_FIVE_HUNDRED;
import static com.Constant.NUM_TWO_HUNDRED;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AjaxResult<T> implements Serializable {
    private static final long serialVersionUID = 7819436044612328783L;
    /**
     * 操作状态
     * */
    private boolean success = true;
    /**
     * 操作信息
     * */
    private String message;
    /**
     * 返回数据
     * */
    private T data;
    /**
     * 状态码
     * */
    private Integer code = NUM_TWO_HUNDRED;

    public boolean isSuccess() {
        return success;
    }

    public AjaxResult<T> setSuccess(boolean success) {
        this.success = success;
        if(success){
            this.code = NUM_TWO_HUNDRED;
        }else{
            this.code = NUM_FIVE_HUNDRED;
        }
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AjaxResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public Object getData() {
        return data;
    }

    public AjaxResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public Integer getCode(){
        return code;
    }

    public AjaxResult<T> setCode(Integer code){
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper (this)
                .add ("success", success)
                .add ("message", message)
                .add ("data", data)
                .add ("code", code)
                .toString ();
    }
}
