package com.controller.test;

import com.entity.base.AjaxResult;
import com.service.test.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制层
 * */
@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    /**
     * 获取当前数据库时间
     * @return String
     * */
    @GetMapping("/getTime")
    public AjaxResult<String> getTime(){
        return new AjaxResult<String>().setData(testService.getTime());
    }

}
