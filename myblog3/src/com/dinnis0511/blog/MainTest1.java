package com.dinnis0511.blog;

import java.util.ArrayList;

import com.dinnis0511.blog.controller.UserController;
import com.dinnis0511.blog.dto.UserDto;

public class MainTest1 {
	
	public static void main(String[] args) {
		
		UserController controller = new UserController();
		
		// 특정 회원 조회 기능 (id번호, 비밀번호, 주소, 사용자 권한은 제외하고 출력) 
//		UserDto result = controller.requestSelectUserByUsername("이춘향");
//		System.out.println(result);
		
		// 로그인 기능
//		String result = controller.requestSignIn("이춘향", "1348");
//		System.out.println(result);
		
//		// 회원 가입 기능
//		UserDto dto = new UserDto("강지", "6589", "j@naver.com", "서울 강남구");
//		String result = controller.requestSignUp(dto);
//		System.out.println(result);
		
		// 회원 탈퇴 기능
		String result = controller.requestDeleteUserInfo("강지", "6589");
		System.out.println(result);
		
		// 회원 정보 수정 기능
//		UserDto dto = new UserDto("이춘향", "1348", "d@naver.com", "서울시 강남구");
//		String result = controller.requestChangeInfo(dto);
//		System.out.println(result);
		
		// 전체 조회 해보기
//		ArrayList<UserDto> list = controller.requestSelectAll();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
	} // end of main
	
} // end of class
