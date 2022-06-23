package com.impl.test;

import com.repository.test.TestRepository;
import com.service.test.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    @Override
    public String getTime() {
        return testRepository.getTime();
    }
}
