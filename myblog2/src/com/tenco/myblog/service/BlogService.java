package com.tenco.myblog.service;

import com.tenco.myblog.dao.BlogDAO;
import com.tenco.myblog.dto.BlogDTO;

public class BlogService {
	
	private BlogDAO blogDAO;
	
	public BlogService() {
		blogDAO = new BlogDAO();
	}
	
	
	// 하나의 게시글을 찾는 로직 만들기
	public BlogDTO selectByBoardId(int id) {
		BlogDTO resultDto = blogDAO.select(id);
		
		return resultDto;
	}
	
	public int deleteBoardById(int boardId, int userId) {
		int resultRow = 0;
		// 유저 아이디 값과
		// board 테이블에 있는 작성자의 userId 값이 같은지 확인
		BlogDTO blogDto = selectByBoardId(boardId);
		// blogDto가 null일 때 방어적 코드 작성
		if(blogDto != null) {
			int blogWriterId = blogDto.getUserId();
			if(userId == blogWriterId) {
				// 삭제 요청 가능
				resultRow = blogDAO.delete(boardId);
			}
		}
		return resultRow;
	}
	
} // end of class
