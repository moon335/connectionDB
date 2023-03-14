package com.dinnis0511.blog.controller;

import java.util.ArrayList;

import com.dinnis0511.blog.dto.UserDto;
import com.dinnis0511.blog.service.UserService;

public class UserController {
	
	UserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	// 전체 회원 조회 요청 받기
	public ArrayList<UserDto> requestSelectAll() {
		ArrayList<UserDto> list = userService.selectAll();
		return list;
	}
	
	
	// 특정 회원 조회 요청 받기
	public UserDto requestSelectUserByUsername(String username) {
		UserDto responseDto = userService.selectByUsername(username);
		return responseDto;
	}
	
	// 로그인 요청 받기
	public String requestSignIn(String username, String password) {
		String responseSignIn = userService.userLogin(username, password);
		return responseSignIn;
	}
	
	// 회원 가입 요청 받기
	public String requestSignUp(UserDto dto) {
		String responseSignUp = userService.signUp(dto);
		return responseSignUp;
	}
	
	// 회원 탈퇴 요청 받기
	public String requestDeleteUserInfo(String username, String password) {
		String responseDelete = userService.deleteUserInfo(username, password);
		return responseDelete;
	}
	
	// 회원 정보 수정 요청 받기
	public String requestChangeInfo(UserDto dto) {
		String responseUpdate = userService.updateUserInfo(dto);
		return responseUpdate;
	}
	
	
	
} // end of class
