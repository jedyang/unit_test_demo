package com.yunsheng.unit.test.base;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

/**
 * 选择使用H2数据库还是使用Mysql数据库, 底层使用的是Spring的Profile功能
 * 
 * 可以通过
 * 
 * @see spring-test-datasource.xml
 * @author yunsheng
 * @since 2016年9月13日 下午7:02:38
 *
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@ActiveProfiles(inheritProfiles = false)
public @interface DBSelecter {

	/**
	 * profiles, 取值只能是DBTypes.H2, 或者是DBTypes.MYSQL, 默认DBTypes.H2
	 */
	@AliasFor(annotation = ActiveProfiles.class, attribute = "profiles")
	String[] value() default { DBTypes.H2 };

	/**
	 * profiles, 取值只能是DBTypes.H2, 或者是DBTypes.MYSQL, 默认DBTypes.H2
	 */
	@AliasFor(annotation = ActiveProfiles.class, attribute = "profiles")
	String[] type() default { DBTypes.H2 };

}
