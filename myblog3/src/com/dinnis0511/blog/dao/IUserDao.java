package com.dinnis0511.blog.dao;

import java.util.ArrayList;

import com.dinnis0511.blog.dto.UserDto;

public interface IUserDao {
	
	// 모든 회원 조회하기
	ArrayList<UserDto> select();
	
	// 특정 회원 조회하기
	UserDto select(String username);
	
	// 회원가입 메서드
	int insert(UserDto dto);
	
	// 회원 탈퇴 메서드
	int delete(String username, String password);
	
	// 회원 정보 수정 메서드
	int update(UserDto dto);
	
	
} // end of interface
