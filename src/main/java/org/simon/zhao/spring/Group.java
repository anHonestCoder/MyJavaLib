package org.simon.zhao.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by zhou01.zhao on 2016/12/19.
 */
@Component
public class Group {
	private Map<String, Person> member;


	private Person person;

	public Person getPerson() {
		return person;
	}

	@Resource(name = "john")
	public void setPerson(Person person) {
		this.person = person;
	}

	public Map<String, Person> getMember() {
		return member;
	}

	@Autowired
	public void setMember(Map<String, Person> member) {
		this.member = member;
	}
}
