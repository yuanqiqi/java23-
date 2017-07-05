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
		
		//1.加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.创建sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.创建sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.操作数据库
		
		List<User> userlist = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
		for(User user : userlist) {
			System.out.println(user.getUserName());
			System.out.println(user.getAddress());
		}
		//5.关闭session
		sqlSession.close();
	}
	
	@Test
	public void first()throws Exception {
		
		//1.加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.创建sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.创建sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//4.操作数据库
		
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
		System.out.println(user.getUserName());
		System.out.println(user.getAddress());
		
		//5.关闭session
		sqlSession.close();
	}
	@Test
	public void save()throws Exception {
		
		//1.加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.创建sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.创建sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();//openSession(true)自动提交事务
		//4.操作数据库
		
		User user = new User();
		user.setUserName("小明");
		user.setAddress("上海");
		user.setPassword("000");
		
		sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);
		
		//5.提交事务
		sqlSession.commit();
		
		
		//6.关闭session
		sqlSession.close();
	}
	@Test
	public void update()throws Exception {
		
		//1.加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.创建sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.创建sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();//openSession(true)自动提交事务
		//4.操作数据库
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);
	
		user.setAddress("beijing");
		
		sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
		
		//5.提交事务
		sqlSession.commit();
		
		
		//6.关闭session
		sqlSession.close();
	}
	@Test
	public void delete()throws Exception {
		
		//1.加载配置文件
		Reader reader = Resources.getResourceAsReader("mybatis.xml");
		//2.创建sql session factory
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		SqlSessionFactory  sqlSessionFactory = sqlSessionFactoryBuilder.build(reader);
		//3.创建sql session
		SqlSession sqlSession = sqlSessionFactory.openSession();//openSession(true)自动提交事务
		//4.操作数据库
		
		sqlSession.delete("com.kaishengit.mapper.UserMapper.delete",4);
		
		//5.提交事务
		sqlSession.commit();
		
		
		//6.关闭session
		sqlSession.close();
	}
}
