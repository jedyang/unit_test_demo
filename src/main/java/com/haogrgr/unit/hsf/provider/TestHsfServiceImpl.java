package com.haogrgr.unit.hsf.provider;

import java.util.Objects;

import javax.annotation.Resource;

import com.haogrgr.unit.hsf.client.TestDTO;
import com.haogrgr.unit.hsf.client.TestHsfService;
import com.haogrgr.unit.model.TestModel;
import com.haogrgr.unit.service.TestServiceImpl;
import com.haogrgr.unit.util.BeanCopyHelper;

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
