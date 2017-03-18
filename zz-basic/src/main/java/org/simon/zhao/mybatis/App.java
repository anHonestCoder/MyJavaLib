package org.simon.zhao.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.simon.zhao.mybatis.entity.Student;
import org.simon.zhao.mybatis.repository.StudentRepository;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by zhou01.zhao on 2016/11/25.
 */
public class App {

	private static SqlSessionFactory sessionFactory = null;

	public static SqlSessionFactory getSessionFactory()  {
		if (sessionFactory == null) {
			InputStream stream = null;
			try {
				stream = Resources.getResourceAsStream("mybatis-config.xml");
			} catch (IOException e) {
				e.printStackTrace();
			}
			sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		SqlSession session = null;
		try {
			session = getSessionFactory().openSession();
			StudentRepository studentRepository = session.getMapper(StudentRepository.class);
			Student result = studentRepository.selectStudent("id,name", "123");
			System.out.printf(result.toString());
		} catch (Exception i) {
			i.printStackTrace();
		} finally{
			session.close();
		}

	}
}
