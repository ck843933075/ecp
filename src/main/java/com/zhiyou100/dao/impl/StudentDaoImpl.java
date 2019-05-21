package com.zhiyou100.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.zhiyou100.dao.StudentDao;
import com.zhiyou100.pojo.Student;

public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao{

	@Override
	public Student queryById(int id) {
		SqlSession sqlSession = super.getSqlSession();
		
		System.out.println("======第一次输出======");
		Object object = sqlSession.selectOne("queryById",id);
		
		System.out.println((Student)object);
		
		System.out.println("--------------");
		System.out.println("======第二次输出======");
		Object object2 = sqlSession.selectOne("queryById",id);
		
		System.out.println((Student)object2);
		sqlSession.close();
		return (Student)object;
	}

}
