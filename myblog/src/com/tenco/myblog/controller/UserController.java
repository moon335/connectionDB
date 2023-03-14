package com.tenco.myblog.controller;

import com.tenco.myblog.dto.UserDTO;
import com.tenco.myblog.service.UserService;

public class UserController {
	
	private UserService service;
	
	public UserController() {
		service = new UserService();
	}

	// 특정 회원을 조회하는 기능
	public UserDTO requestSelectByUsername(String username) {
		UserDTO responseDto = service.selectByUsername(username);
		return responseDto;
	}
	
	// 로그인 요청 받는 기능
	public String requestLogin(String username, String password) {
		String responseString = service.login(username, password);
		return responseString;
	}
	
	// 가입 요청받는 기능
	public String requestSignUp(String username, String password, String email, String address) {
		String responseString = service.signUp(username, password, email, address);
		return responseString;
	}
	
} // end of class
