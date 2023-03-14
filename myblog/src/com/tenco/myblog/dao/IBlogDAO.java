package com.tenco.myblog.dao;

import com.tenco.myblog.dto.BlogDTO;

public interface IBlogDAO {
	
	BlogDTO select(); // 전체 조회
	BlogDTO select(int id); // 특정 행 조회
	int delete(int boardId);
	
}
