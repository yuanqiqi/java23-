package com.kaishengit.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.kaishengit.entity.User;

public class MyBatisTest {
	@Test
	public void findAll()throws Exception {
		
		//1.���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.����sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.����sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.�������ݿ�
		
		List<User> userlist = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
		for(User user : userlist) {
			System.out.println(user.getUserName());
			System.out.println(user.getAddress());
		}
		//5.�ر�session
		sqlSession.close();
	}
	
	@Test
	public void first()throws Exception {
		
		//1.���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.����sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.����sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.�������ݿ�
		
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
		System.out.println(user.getUserName());
		System.out.println(user.getAddress());
		
		//5.�ر�session
		sqlSession.close();
	}
	@Test
	public void save()throws Exception {
		
		//1.���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.����sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.����sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();//openSession(true)�Զ��ύ����
		//4.�������ݿ�
		
		User user = new User();
		user.setUserName("С��");
		user.setAddress("�Ϻ�");
		user.setPassword("000");
		
		sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);
		
		//5.�ύ����
		sqlSession.commit();
		
		
		//6.�ر�session
		sqlSession.close();
	}
	@Test
	public void update()throws Exception {
		
		//1.���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.����sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.����sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();//openSession(true)�Զ��ύ����
		//4.�������ݿ�
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
	
		user.setAddress("beijing");
		
		sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
		
		//5.�ύ����
		sqlSession.commit();
		
		
		//6.�ر�session
		sqlSession.close();
	}
	@Test
	public void delete()throws Exception {
		
		//1.���������ļ�
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.����sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.����sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();//openSession(true)�Զ��ύ����
		//4.�������ݿ�
		
		sqlSession.delete("com.kaishengit.mapper.UserMapper.delete",4);
		
		//5.�ύ����
		sqlSession.commit();
		
		
		//6.�ر�session
		sqlSession.close();
	}
}
