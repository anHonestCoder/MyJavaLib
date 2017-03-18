package org.simon.zhao.java.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Zhaozhou
 * @date 2017/3/10
 */
@SupportedAnnotationTypes({"org.simon.zhao.java.annotation.MethodInfo"})
public class MethodInfoProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
		HashMap<String, String> map =new HashMap<String, String>();
		for (TypeElement typeElement : annotations) {
			for (Element element : env.getElementsAnnotatedWith(typeElement)) {
				MethodInfo methodInfo = element.getAnnotation(MethodInfo.class);
				map.put(element.getEnclosingElement().toString(), methodInfo.author());
				System.out.println(element.getEnclosingElement().toString() + ":" + methodInfo.author());
			}
		}
		return false;
	}

	public static void main(String[] args) {

	}
}
