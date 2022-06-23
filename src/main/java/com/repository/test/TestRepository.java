package com.repository.test;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestRepository {
    String getTime();
}
