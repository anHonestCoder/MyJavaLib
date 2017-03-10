package org.simon.zhao.mybatis.repository;

import org.apache.ibatis.annotations.Param;
import org.simon.zhao.mybatis.entity.Student;


/**
 * Created by zhou01.zhao on 2016/11/25.
 */
public interface StudentRepository {
	Student selectStudent(@Param("columns") String columns, @Param("id") String id);
}
