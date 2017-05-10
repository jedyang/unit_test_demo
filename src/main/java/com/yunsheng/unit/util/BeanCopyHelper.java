package com.yunsheng.unit.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;

/**
 * bean copy 方便
 * 
 * @author yunsheng
 * @since 2016年5月1日 下午2:23:20
 *
 */
public class BeanCopyHelper {

    private BeanCopyHelper() {}

    /**
     * 拷贝list中每一项到到指定类型的新list中, 通过target.newInstance()创建实例, 需要无参数构造方法
     * 
     * @param srcList 要拷贝的List
     * @param targetClass 目标类型
     * @return 新的List, 其中元素类型为 T
     */
    public static <T> T copy(Object src, Class<T> targetClass) {
        if (src == null) {
            return null;
        }
        try {
            T target = targetClass.newInstance();
            BeanUtils.copyProperties(src, target);
            return target;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeanCopyException("Bean拷贝异常", e);
        }
    }

    /**
     * 拷贝list中每一项到到指定类型的新list中, 通过target.newInstance()创建实例, 需要无参数构造方法
     * 
     * @param srcList 要拷贝的List
     * @param targetClass 目标类型
     * @return 新的List, 其中元素类型为 T
     */
    public static <T> List<T> copy(List<?> srcList, Class<T> targetClass) {
        if (srcList == null) {
            return null;
        }
        if (srcList.isEmpty()) {
            return Collections.emptyList();
        }

        List<T> ret = new ArrayList<>(srcList.size());
        for (Object src : srcList) {
            T target = copy(src, targetClass);
            ret.add(target);
        }
        return ret;
    }

    /**
     * Bean拷贝异常
     * 
     * @author yunsheng
     * @since 2016年5月1日 下午2:31:57
     *
     */
    public static class BeanCopyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public BeanCopyException(String message, Throwable cause) {
            super(message, cause);
        }

    }

}
