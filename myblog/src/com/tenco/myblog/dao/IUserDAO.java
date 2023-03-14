package com.tenco.myblog.dao;

import com.tenco.myblog.dto.UserDTO;

public interface IUserDAO {
	
	// 특정 회원 조회 메서드
	UserDTO select(String username);
	// 회원가입 메서드
	int insert(String username, String password, String email, String address);
	
}
