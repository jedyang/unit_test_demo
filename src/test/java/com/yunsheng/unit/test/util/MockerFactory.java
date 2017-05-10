package com.yunsheng.unit.test.util;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 外部接口mock类, 方便测试
 * 
 * @author yunsheng
 * @since 2016年6月27日 上午11:21:08
 *
 */
public class MockerFactory<T> implements FactoryBean<T> {

    private static final Logger logger = LoggerFactory.getLogger(MockerFactory.class);

    private Enhancer enhancer = new Enhancer();
    private Class<T> clazz;

    @Override
    @SuppressWarnings("unchecked")
    public T getObject() throws Exception {
        this.enhancer.setCallback(new MockerInterceptor());
        this.enhancer.setSuperclass(clazz);
        return (T)this.enhancer.create();
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void init() throws Exception {}

    public void setInterfaceClass(Class<T> interfaceClass) {
        clazz = interfaceClass;
    }

    @SuppressWarnings("unchecked")
    public void setInterfaceName(String interfaceName) {
        try {
            clazz = (Class<T>)MockerFactory.class.getClassLoader().loadClass(interfaceName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setVersion(String version) {}

    private class MockerInterceptor implements MethodInterceptor {

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
            logger.info("调用Mock, 类:{}, 方法:{}", clazz.getSimpleName(), method.getName());
            return null;
        }

    }

}