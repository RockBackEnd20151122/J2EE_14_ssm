package com.user.service.impl;

import java.util.Date;

import com.user.dao.UserDao;
import com.user.dto.UserDto;
import com.user.service.UserService;
import com.user.util.BaseUtils;
import com.user.util.UserBaseUtil;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public UserDto getUserByUserName( String userName ){
		
		return this.userDao.getUserByUserName(userName);
	}
	
	@Override
	public String judgeCanLogin(UserDto userDto){
		UserDto userDtoInDb = this.userDao.getUserByUserName(userDto.getUserName());
		if( userDtoInDb==null ){
			return UserBaseUtil.USER_NOT_EXIST;
		}
		if( userDtoInDb.getPassword().equals(userDto.getPassword())){
			return UserBaseUtil.CAN_LOGIN;
		}else{
			return UserBaseUtil.PASSWORD_ERROR;
		}
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

		//spring 相当于有一个dao的实现类
		this.userDao.addUser(user);
//		this.userDao.addUser(user);
		//here is for test 事务
	}

	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

}
