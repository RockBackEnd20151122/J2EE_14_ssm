package com.user.dao.impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.user.dao.UserDao;
import com.user.dto.UserDto;

public class UserDaoImpl implements UserDao {

	@Override
	public void addUser(UserDto user) {
		// TODO Auto-generated method stub
		
		String resource = "mybatis/mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = factory.openSession();
		
		try {
			sqlSession.insert("userManager.addUser", user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}
	
	public static void main( String[] argu){
		UserDaoImpl userDao = new UserDaoImpl();
		UserDto user = new UserDto();
		
		userDao.addUser(user);
		
	}

	@Override
	public UserDto getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		String resource = "mybatis/mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = factory.openSession();
		
		UserDto userDto = new UserDto();
		
		try {
			userDto = sqlSession.selectOne("userManager.getUserByUserName", userName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return userDto;
	}

}
