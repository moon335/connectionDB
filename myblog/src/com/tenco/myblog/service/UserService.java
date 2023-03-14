package com.tenco.myblog.service;

import com.tenco.myblog.dao.UserDAO;
import com.tenco.myblog.dto.UserDTO;

public class UserService {
	
	UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	// 회원정보 한명만 조회
	public UserDTO selectByUsername(String username) {
		UserDTO resultDto = userDAO.select(username);
		return resultDto;
	}
	
	// 매개 변수의 아이디와 비밀번호가 데이터베이스에 있는 값과 일치하는지
	// 조회하는 기능
	public String login(String username, String password) {
		String result = "";
		UserDTO selectUser = userDAO.select(username);
		if(selectUser != null) {
			if(username.equals(selectUser.getUsername()) && password.equals(selectUser.getPassword())) {
				result = "로그인에 성공했습니다.";
			}
		}
		return result;
	}
	
	// 회원가입 dao에 요청
	public String signUp(String username, String password, String email, String address) {
		int resultRow = userDAO.insert(username, password, email, address);
		String result = "";
		if(resultRow == 0) {
			result = "회원가입에 실패했습니다.";
		} else {
			result = "회원가입에 성공했습니다.";
		}
		return result;
	}
	
	
} // end of class
