package org.simon.zhao.spring.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * Created by zhou01.zhao on 2016/12/16.
 */
public class Main {
	public static void main(String[] args) throws InterruptedException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person john = context.getBean("john", Person.class);
		Thread.sleep(5000);
		Person simon = context.getBean("simon", Person.class);

		Group g = context.getBean(Group.class);
		Person person = g.getPerson();
		Map<String, Person> member = g.getMember();
		System.out.println(member.size());
		System.out.println(person.getName());
	}
}
