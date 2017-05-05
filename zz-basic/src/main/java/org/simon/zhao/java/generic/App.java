package org.simon.zhao.java.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Zhaozhou
 * @date 2017/3/27
 */
public class App {

	public static void main(String[] args) {
/*		List<String> strings = new ArrayList<>();
		List<Integer> ints = new ArrayList<>();
		List<String> list = new ArrayList();
		List<?> list3 = (List<?>) list;
		unsafeAdd(strings, new Integer(0));
		unsafeAdd3(list);
		unsafeAdd4(ints, list);*/
		List<Class> l = new ArrayList();

		List<?> [] lists = new List<?>[3];
//		lists[0].add("1");

		Object[] objects = new Long[1];
		objects[0] = 1l;
		System.out.println(objects[0]);




	}

	public static void unsafeAdd(List list, Object o) {
		list.add(o);
	}

	public static void unsafeAdd2(List<Object> list, Object o) {
		list.add(o);
	}

	public static void unsafeAdd3(List<String> list) {
		list.add(new String("1"));
	}

	public static void unsafeAdd4(List<?> list, List<?> list2) {

	}

	interface Function<T> {
		T apply(T arg1, T args);
	}

	static <E> E reduce(List<E> list, Function<E> f, E initVal) {
		List<E> snapshot = new ArrayList<>(list);
		E result = initVal;
		for (E e:snapshot) {
			result = f.apply(result, e);
		}
		return result;
	}

}
