package org.simon.zhao.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Zhaozhou
 * @date 2017/3/10
 */
public class AnnotationParser {
	public static void main(String[] args) {
		Class clz = AnnotationTest.class;
		for (Method method : clz.getMethods())
		{
			MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
			if (methodInfo != null) {
				System.out.println("method name:" + method.getName());
				System.out.println("method author:" + methodInfo.author());
				System.out.println("method date:" + methodInfo.date());
				System.out.println("method version:" + methodInfo.version());
			}

		}
	}
}
