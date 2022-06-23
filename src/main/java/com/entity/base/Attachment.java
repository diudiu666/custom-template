package com.entity.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 *公共附件实体(有特殊逻辑继承此类,不要修改此类)
 *@author :Muggle.Wang
 *Create in 12:03 2021/8/4
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment implements Serializable {
    private static final long serialVersionUID = -216241757688242032L;

    Long id;
    /**
     * 父id
     * */
    String parentId;
    /**
     * 附件名称
     * */
    String name;
    /**
     * 附件地址
     * */
    String url;
    /**
     * 附件描述
     * */
    String description;
    /**
     * 常量识别类型
     * */
    String type;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper (this)
                .add ("id", id)
                .add ("parentId", parentId)
                .add ("name", name)
                .add ("url", url)
                .add ("description", description)
                .add ("type", type)
                .toString ();
    }
}
