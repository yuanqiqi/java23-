package com.kaishengit.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;

import com.kaishengit.mapper.MovieMapper;

public class MovieMapperTest {

	private SqlSession sqlSession;
	private MovieMapper movieMapper;
	
	@Before
	public void before() {
		sqlSession = MybatisUtil.getSqlSession();
		movieMapper = sqlSession.getMapper(MovieMapper.class);
		
	}

	public void after() {
		sqlSession.close();
	}
}
