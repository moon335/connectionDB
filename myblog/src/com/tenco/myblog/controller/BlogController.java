package com.tenco.myblog.controller;

import com.tenco.myblog.dto.BlogDTO;
import com.tenco.myblog.service.BlogService;

public class BlogController {
	
	private BlogService blogService;
	
	public BlogController() {
		blogService = new BlogService();
	}
	
	// 외부에서 오는 요청을 담당하는 녀석
	public BlogDTO requestBoardContentById(int id) {
		BlogDTO responseDTO = blogService.selectByBoardId(id);
		
		return responseDTO;
	}
	
	// 하나의 게시글 삭제하기
	public int requestDeleteBoardById(int boardId, int userId) {
		int responseRow = blogService.deleteBoardById(boardId, userId);
		
		return responseRow;
	}
	
} // end of class
