package com.yunsheng.unit.service;

import java.util.List;

import javax.annotation.Resource;

import com.cainiao.cngfc.client.ProductReadService;
import com.cainiao.cngfc.common.dto.GFCResultDTO;
import com.cainiao.cngfc.common.dto.ProductDTO;
import com.yunsheng.unit.model.TestModel;
import com.yunsheng.unit.test.base.UnitTestBase;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Transactional
public class TestServiceImplTest extends UnitTestBase {

    @Resource
    @InjectMocks
    private TestServiceImpl testServiceImpl;

    @Mock
    private ProductReadService productReadService;

    @Test
    @Sql("TestServiceImplTest_testGetById.sql")
    public void testGetById() {
        TestModel byId = testServiceImpl.getById(2);
        Assert.isTrue(byId != null && byId.getId().equals(2), "error");
    }

    @Test
    public void testInvorkOtherHsfService() {
        GFCResultDTO<List<ProductDTO>> value = GFCResultDTO.error("111", "111");
        Mockito.when(productReadService.queryAll()).thenReturn(value);

        GFCResultDTO<List<ProductDTO>> ret = testServiceImpl.invorkOtherHsfService();

        Assert.isTrue(ret != null && ret.getErrorCode().equals("111"), "error");
    }

}
