package com.entity.api;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class DeleteParam implements Serializable {
    private static final long serialVersionUID = 5812596164482153928L;

    /**
     * 表名
     * */
    String tableName;

    /**
     * 主键名称
     * */
    String keyName;

    /**
     * 删除依据主键
     * */
    List<Long> ids;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("tableName", tableName)
                .add("keyName", keyName)
                .add("ids", ids)
                .toString();
    }
}
