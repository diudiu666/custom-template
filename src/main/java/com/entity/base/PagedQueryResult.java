package com.entity.base;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class PagedQueryResult<T> implements Serializable {

    private static final long serialVersionUID = -6609765585581086269L;
    private Integer totalCount;
    private List<T> data;

    public PagedQueryResult() {
    }

    public PagedQueryResult(List<T> data, int count) {
        this.data = data;
        this.totalCount = count;
    }

    public List<T> getData() {
        return this.data == null ? Collections.emptyList() : this.data;
    }

    public void setData(List<T> list) {
        this.data = list;
    }

    public Integer getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(Integer count) {
        this.totalCount = count;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper (this)
                .add ("totalCount", totalCount)
                .add ("data", data)
                .toString ();
    }
}
