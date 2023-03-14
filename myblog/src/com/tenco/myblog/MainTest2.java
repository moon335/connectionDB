package com.tenco.myblog;

import com.tenco.myblog.controller.UserController;
import com.tenco.myblog.dto.UserDTO;

public class MainTest2 {

	public static void main(String[] args) {
		
		// 특정 회원 조회하기
		UserController controller = new UserController();
//		UserDTO dto = controller.requestSelectByUsername("이춘향");
//		System.out.println(dto);
		
		// 로그인 기능 만들기
//		UserDTO dto = new UserDTO("이춘향", "3478");
//		String result = controller.requestLogin(dto.getUsername(), dto.getPassword());
//		System.out.println(result);
		
		// 가입하기
		UserDTO dto = new UserDTO("강지", "4654", "v@naver.com", "인천 서구");
		String result = controller.requestSignUp(dto.getUsername(), dto.getPassword(), dto.getEmail(), dto.getAddress());
		System.out.println(result);
		
		
	} // end of main

} // end of class
