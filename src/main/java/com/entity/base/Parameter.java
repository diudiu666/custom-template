package com.entity.base;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *参数实体
 *@author :Muggle.Wang
 *Create in 15:03 2021/8/3
 */
@Getter
@Setter
public class Parameter implements Serializable {
    private static final long serialVersionUID = -157431012188091910L;

    Long id;

    /**
     * 参数名称
     * */
    String name;
    /**
     * 参数code
     * */
    String code;
    /**
     * 参数排序
     * */
    Integer listOrder;
    /**
     * 参数描述
     * */
    String description;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper (this)
                .add ("id", id)
                .add ("name", name)
                .add ("code", code)
                .add ("listOrder", listOrder)
                .add ("description", description)
                .toString ();
    }
}
