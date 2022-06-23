package com.impl.api;

import com.entity.api.DeleteParam;
import com.entity.api.SaveOrUpdateParam;
import com.entity.api.SelectParam;
import com.entity.base.PagedQueryResult;
import com.repository.api.ApiRepository;
import com.service.api.ApiService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class ApiServiceImpl implements ApiService {

    private final ApiRepository apiRepository;

    public ApiServiceImpl(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    @Override
    public PagedQueryResult<Map<String, Object>> select(SelectParam selectParam) {
        final PagedQueryResult<Map<String, Object>> pagedQueryResult = new PagedQueryResult<>();
        if (!Strings.isBlank(selectParam.getDIYSqlString())) {
            pagedQueryResult.setTotalCount(apiRepository.selectCountDIY(selectParam.getDIYSqlString()));
            if (pagedQueryResult.getTotalCount() > 0) {
                pagedQueryResult.setData(apiRepository.selectListDIY(selectParam.getDIYSqlString(),selectParam.getStart(),selectParam.getLimit()));
            }
            return pagedQueryResult;
        }
        final StringBuilder queryString = new StringBuilder().append("1=1");
        //拼接条件查询
        if (null != selectParam.getQueryName()) {
            Set set = selectParam.getQueryName().entrySet();
            for (Object o : set) {
                Map.Entry entry = (Map.Entry) o;
                if( ((String) entry.getValue()).length()!=0){
                    queryString.append(" and ").append((String) entry.getKey()).append(" = '").append((String) entry.getValue()).append("'");
                }
            }
        }
        //like匹配查询
        if (null != selectParam.getQueryLikeName()) {
            Set set = selectParam.getQueryLikeName().entrySet();
            for (Object o : set) {
                Map.Entry entry = (Map.Entry) o;
                if( ((String) entry.getValue()).length()!=0){
                    queryString.append(" and ").append((String) entry.getKey()).append(" like '%").append((String) entry.getValue()).append("%'");
                }
            }
        }
        pagedQueryResult.setTotalCount(apiRepository.selectCount(selectParam, queryString.toString()));
        if (pagedQueryResult.getTotalCount() > 0) {
            pagedQueryResult.setData(apiRepository.selectList(selectParam, queryString.toString()));
        }
        return pagedQueryResult;
    }

    @Override
    public Boolean saveOrUpdate(SaveOrUpdateParam saveOrUpdateParam) {
        switch (saveOrUpdateParam.getHandleType()) {
            case "insert":
                if (null != saveOrUpdateParam.getData()) {
                    saveOrUpdateParam.getData().forEach(a -> {
                        StringBuilder insertSqlString = new StringBuilder();
                        for (int i = 0; i < a.size(); i++) {
                            insertSqlString.append("'").append(a.get(i)).append("'");
                            if (i != a.size() - 1) {
                                insertSqlString.append(",");
                            }
                        }
                        apiRepository.insert(saveOrUpdateParam, insertSqlString.toString());
                    });
                } else {
                    saveOrUpdateParam.getMapData().forEach(a -> {
                        StringBuilder insertSqlString = new StringBuilder();
                        for (int i = 0; i < saveOrUpdateParam.getFieldName().size(); i++) {
                            insertSqlString.append("'").append(a.get(saveOrUpdateParam.getFieldName().get(i))).append("'");
                            if (i != a.size() - 1) {
                                insertSqlString.append(",");
                            }
                        }
                        apiRepository.insert(saveOrUpdateParam, insertSqlString.toString());
                    });
                }
                break;
            case "update":
                final String primaryKey = saveOrUpdateParam.getFieldName().get(0);
                if (null != saveOrUpdateParam.getData()) {
                    saveOrUpdateParam.getData().forEach(a -> {
                        StringBuilder sqlString = new StringBuilder();
                        for (int i = 0; i < a.size(); i++) {
                            for (int k = 0; k < saveOrUpdateParam.getFieldName().size(); k++) {
                                if (i == k && i != 0) {
                                    sqlString.append(saveOrUpdateParam.getFieldName().get(k)).append("=").append("'").append(a.get(i)).append("'");
                                    if (i != a.size() - 1) {
                                        sqlString.append(",");
                                    }
                                }
                            }
                        }
                        apiRepository.update(saveOrUpdateParam.getTableName(), sqlString.toString(), primaryKey, a.get(0).toString());
                    });
                } else {
                    saveOrUpdateParam.getMapData().forEach(a -> {
                        StringBuilder sqlString = new StringBuilder();
                        for (int i = 0; i < saveOrUpdateParam.getFieldName().size(); i++) {
                            sqlString.append(saveOrUpdateParam.getFieldName().get(i)).append("=").append("'").append(a.get(saveOrUpdateParam.getFieldName().get(i))).append("'");
                            if (i != a.size() - 1) {
                                sqlString.append(",");
                            }
                        }
                        apiRepository.update(saveOrUpdateParam.getTableName(), sqlString.toString(), primaryKey, a.get("id").toString());
                    });
                }
                break;
        }
        return true;
    }

    @Override
    public Boolean delete(DeleteParam deleteParam) {
        return apiRepository.delete(deleteParam) > 0;
    }
}
