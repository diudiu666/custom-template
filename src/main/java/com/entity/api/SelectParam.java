package com.entity.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class SelectParam implements Serializable {

    private static final long serialVersionUID = 5704047288470793191L;
    /**
     * 字段列表,为空查*
     * */
    List<String> fieldList;
    /**
     * 条件查询字段
     * */
    Map<String,String> queryName;
    /**
     * 模糊查询字段
     * */
    Map<String,String> queryLikeName;
    /**
     * 排序字段
     * */
    String orderName;
    /**
     * 表名
     * */
    String tableName;

    /**
     * DIYsqlString,任意可执行的sql
     * */
    @JsonProperty("DIYSqlString")
    String DIYSqlString;

    /**
     * 页码
     * */
    Integer page;

    /**
     * 分页数量
     * */
    Integer limit;

    /**
     * start后端会重新计算,前端不必传
     * */
    Integer start;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("fieldList", fieldList)
                .add("queryName", queryName)
                .add("queryLikeName", queryLikeName)
                .add("orderName", orderName)
                .add("tableName", tableName)
                .add("DIYSqlString", DIYSqlString)
                .add("page", page)
                .add("limit", limit)
                .add("start", start)
                .toString();
    }
}
