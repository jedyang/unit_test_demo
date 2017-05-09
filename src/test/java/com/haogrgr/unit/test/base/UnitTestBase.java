package com.haogrgr.unit.test.base;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 支付模块的测试基类
 * 
 * @author tudesheng
 * @since 2016年6月29日 下午8:34:37
 *
 */
@DBSelecter(DBTypes.H2)
@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring-root-test.xml")
public class UnitTestBase {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

}
