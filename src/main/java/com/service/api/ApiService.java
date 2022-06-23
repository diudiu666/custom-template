package com.service.api;

import com.entity.api.DeleteParam;
import com.entity.api.SaveOrUpdateParam;
import com.entity.api.SelectParam;
import com.entity.base.PagedQueryResult;

import java.util.Map;

public interface ApiService {
    PagedQueryResult<Map<String, Object>> select(SelectParam selectParam);

    Boolean saveOrUpdate(SaveOrUpdateParam saveOrUpdateParam);

    Boolean delete(DeleteParam deleteParam);
}
