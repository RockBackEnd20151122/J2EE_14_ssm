package com.user.action;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.user.dto.UserDto;
import com.user.service.UserService;
import com.user.service.impl.UserServiceImpl;

public class UserAction {
	
	private UserDto userDto;
	private UserService userService;
	private String message;
	
	public String login(){
		
		if( userDto.getUserName()==null || userDto.getUserName().trim().equals("") ){
			this.message = "user name must have";
			return "error";
		}
		
		if( userDto.getPassword() ==null || userDto.getPassword().trim().equals("") ){
			this.message = "pwd name must have";
			return "error";
		}
		
		this.message = this.userService.judgeCanLogin(userDto);
		if( "can login".equals(this.message)){
			
			UserDto userDtoIndb = this.userService.getUserByUserName(userDto.getUserName());
			
			HttpSession session = ServletActionContext.getRequest().getSession(); 
			session.setAttribute("realName", userDtoIndb.getRealName() );
			session.setAttribute("loginTime", new Date() );
			session.setAttribute("headImage", userDtoIndb.getHeadImage() );
			
			return "success";
		}else{
			return "error";
		}
	}
	
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
