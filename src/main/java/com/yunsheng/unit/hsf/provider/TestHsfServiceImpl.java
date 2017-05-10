package com.yunsheng.unit.hsf.provider;

import java.util.Objects;

import javax.annotation.Resource;

import com.yunsheng.unit.hsf.client.TestDTO;
import com.yunsheng.unit.hsf.client.TestHsfService;
import com.yunsheng.unit.model.TestModel;
import com.yunsheng.unit.service.TestServiceImpl;
import com.yunsheng.unit.util.BeanCopyHelper;

@Resource
public class TestHsfServiceImpl implements TestHsfService {

    @Resource
    private TestServiceImpl testService;

    @Override
    public TestDTO getById(Integer id) {
        Objects.requireNonNull(id);

        TestModel test = testService.getById(id);
        TestDTO copy = BeanCopyHelper.copy(test, TestDTO.class);

        return copy;
    }

}
