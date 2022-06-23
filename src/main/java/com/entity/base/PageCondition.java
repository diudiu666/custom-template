package com.entity.base;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

import static com.Constant.NUM_ZERO;

/**
 *公共分页实体
 *@author :Muggle.Wang
 *Create in 11:33 2021/8/5
 */
public class PageCondition implements Serializable {

    private static final long serialVersionUID = -6493773718679159215L;
    /**
     * 页码 从1 开始
     */
    @NotNull
    private Integer page;
    /**
     * 每页大小
     */
    @NotNull
    private Integer limit;


    public PageCondition(){
        this.page = 0;
        this.limit = 0;
    }

    public Integer getPage(){
        return this.page;
    }

    public void setPage(Integer page){
        this.page = page;
    }

    public Integer getLimit(){
        return this.limit;
    }

    public void setLimit(Integer limit){
        this.limit = limit;
    }

    public Integer getStart(){
        //分页参数必填校验
        if( page.equals (NUM_ZERO) ){
            throw new NullPointerException ("分页参数为空");
        }
        return (this.page-1)*this.limit;
    }

}
