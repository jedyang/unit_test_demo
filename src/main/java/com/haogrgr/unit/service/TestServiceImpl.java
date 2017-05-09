package com.haogrgr.unit.service;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import com.cainiao.cngfc.client.ProductReadService;
import com.cainiao.cngfc.common.dto.GFCResultDTO;
import com.cainiao.cngfc.common.dto.ProductDTO;
import com.haogrgr.unit.dao.TestMapper;
import com.haogrgr.unit.model.TestModel;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl {

    @Resource
    private TestMapper testMapper;

    @Resource
    private ProductReadService productReadService;

    public TestModel getById(Integer id) {
        Objects.requireNonNull(id);
        return testMapper.getById(id);
    }

    public GFCResultDTO<List<ProductDTO>> invorkOtherHsfService() {
        return productReadService.queryAll();
    }

}
