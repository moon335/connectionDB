package com.tenco.myblog;

import com.tenco.myblog.controller.BlogController;
import com.tenco.myblog.dto.BlogDTO;

public class MainTest1 {

	public static void main(String[] args) {
		
		// 코드 테스트
//		DBHelper dbHelper = DBHelper.getInstance();
//		
//		dbHelper.getConnection();
//		
//		System.out.println("메인에서 주소값 찍음 " + dbHelper);
		
		// 코드 테스트
		BlogController blogController = new BlogController();
		
//		BlogDTO dto = blogController.requestBoardContentById(6);
		
//		System.out.println(dto);
		
		int resultRow = blogController.requestDeleteBoardById(6, 5);
		System.out.println(resultRow);
		
		
	} // end of main

} // end of class
