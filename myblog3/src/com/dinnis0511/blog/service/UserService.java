package com.dinnis0511.blog.service;

import java.util.ArrayList;

import com.dinnis0511.blog.dao.UserDao;
import com.dinnis0511.blog.dto.UserDto;

public class UserService {
	
	UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	// 모든 회원 조회 로직 만들기
	public ArrayList<UserDto> selectAll() {
		ArrayList<UserDto> list = userDao.select();
		return list;
	}
	
	// 특정 회원 조회 로직 만들기
	public UserDto selectByUsername(String username) {
		UserDto resultDto = userDao.select(username);
		return resultDto;
	}
	
	// 로그인 로직 만들기
	public String userLogin(String username, String password) {
		String result = "";
		UserDto targetDto = userDao.select(username);
		// 매개변수의 아이디 비번과 조회 대상의 아이디 비번이 일치할 시 문구 출력
		if(username.equals(targetDto.getUsername()) && password.equals(targetDto.getPassword())) {
			result = "로그인에 성공했습니다.";
		} else {
			result = "로그인에 실패했습니다.";
		}
		return result;
	}
	
	// 회원 가입 로직 만들기
	public String signUp(UserDto dto) {
		String result = "회원가입에 실패했습니다.";
		dto.setUserRole("USER");
		int resultRow = userDao.insert(dto);
		if(resultRow != 0) {
			result = "회원가입에 성공했습니다.";
		}
		return result;
	}
	
	// 회원 탈퇴 로직 만들기
	public String deleteUserInfo(String username, String password) {
		String result = "정보와 일치하는 회원이 없습니다.";
		int resultRow = userDao.delete(username, password);
		if(resultRow != 0) {
			result = "탈퇴에 성공했습니다.";
		}
		return result;
	}
	
	// 회원 정보 수정 로직 만들기
	public String updateUserInfo(UserDto dto) {
		String result = "정보 수정에 실패했습니다.";
		int resultRow = userDao.update(dto);
		if(resultRow != 0) {
			result = "정보 수정에 성공했습니다.";
		}
		return result;
	}
	
} // end of class
