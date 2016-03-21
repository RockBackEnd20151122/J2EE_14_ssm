package com.user.action;

import com.user.dto.UserDto;
import com.user.service.UserService;
import com.user.service.impl.UserServiceImpl;

public class UserAction {
	
	private UserDto userDto;
	private UserService userService;
	
	public UserAction(){
		this.userService = new UserServiceImpl();
	}
	
	public String addUser(){
		this.userService.addUser(userDto);
		return "success";
	}
	
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
