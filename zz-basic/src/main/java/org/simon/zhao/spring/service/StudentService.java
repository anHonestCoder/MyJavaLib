package org.simon.zhao.spring.service;

import org.simon.zhao.spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Zhaozhou
 * @date 2017/6/13
 */
public class StudentService {

	@Autowired
	StudentRepository studentRepository ;

	public int count() {
		return studentRepository.selectCount();
	}
}
