package org.simon.zhao.java.annotation;

import java.lang.annotation.*;

/**
 * @author Zhaozhou
 * @date 2017/3/10
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
	String author() default "zhaozhou";
	String date();
	int version() default 1;
}
