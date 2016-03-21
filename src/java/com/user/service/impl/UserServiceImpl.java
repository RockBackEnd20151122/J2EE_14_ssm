package com.user.service.impl;

import java.util.Date;

import com.user.dao.UserDao;
import com.user.dao.impl.UserDaoImpl;
import com.user.dto.UserDto;
import com.user.service.UserService;
import com.user.util.BaseUtils;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl(){
		this.userDao = new UserDaoImpl();
	}
	
	@Override
	public void addUser(UserDto user) {
		// TODO Auto-generated method stub
		
		Date time = new Date();
		user.setUserId(BaseUtils.getUUID());
		user.setRegisterTime(time);
		user.setCreateTime(time);
		user.setCreateBy("Rock");
		user.setUpdateBy("rock");
		user.setUpdateTime(time);
		user.setUserStatus("01");

		this.userDao.addUser(user);
	}

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
