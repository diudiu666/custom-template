package com.entity.api;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 数据接收实体
 * @author muggle.wang
 * Create in 2022/2/7 11:03
 */
@Data
public class SaveOrUpdateParam implements Serializable {
    private static final long serialVersionUID = 7657600686776443645L;
    /**
     * 表名
     */
    String tableName;

    /**
     * 字段名
     * */
    List<String> fieldName;

    /**
     * 和mapData选填一个
     * 数据map<字段名,内容>
     * */
    List<List<Object>> data;

    /**
     * 和data选填一个
     * 数据mapData
     * */
    List<Map<String,Object>> mapData;

    /**
     * 批量删除id集合,删除暂不开放
     */
    private List<Long> ids;

    /**
     * 需要执行的操作类型 insert update
     * fieldName与data顺序需保持一致
     * 使用mapData时无顺序要求
     * update时主键id需排列在第一位
     */
    private String handleType;
}
