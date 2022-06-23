package com.repository.api;

import com.entity.api.DeleteParam;
import com.entity.api.SaveOrUpdateParam;
import com.entity.api.SelectParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApiRepository {
    /**
     * 查询列表
     * @param queryString
     * @param selectParam
     * @return List<Map<String, Object>>
     * */
    List<Map<String, Object>> selectList(@Param("param") SelectParam selectParam, @Param("queryString") String queryString);

    /**
     * 查询数量
     * @param queryString
     * @param selectParam
     * @return Integer
     * */
    Integer selectCount(@Param("param") SelectParam selectParam, @Param("queryString") String queryString);

    /**
     * 获取字段类型
     * @param fieldName
     * @param tableName
     * @return 字段类型
     * */
    String getFieldType(String tableName, String fieldName);

    /**
     * 数据同步/新增
     * @param saveOrUpdateParam
     * @param sqlString
     * */
    void insert(@Param("param") SaveOrUpdateParam saveOrUpdateParam, @Param("sqlString") String sqlString);

    /**
     * 数据同步/新增
     * @param tableName
     * @param sqlString
     * @param primaryKey
     * @param id
     * */
    void update(String tableName, String sqlString, String primaryKey, String id);

    /**
     * 数据删除
     * @param deleteParam
     * */
    Integer delete(DeleteParam deleteParam);

    /**
     * 查询数量
     * @param diySqlString
     * @return Integer
     * */
    Integer selectCountDIY(@Param("diySqlString") String diySqlString);

    /**
     * 查询列表
     * @param diySqlString
     * @return List<Map<String, Object>>
     * */
    List<Map<String, Object>> selectListDIY(@Param("diySqlString") String diySqlString,@Param("start")Integer start,@Param("limit")Integer limit);
}
