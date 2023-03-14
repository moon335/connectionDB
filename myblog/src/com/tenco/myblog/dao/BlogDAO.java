package com.tenco.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tenco.myblog.dto.BlogDTO;
import com.tenco.myblog.utils.DBHelper;

public class BlogDAO implements IBlogDAO{
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Connection conn;
	
	public BlogDAO() {
		conn = DBHelper.getInstance().getConnection();
	}
	
	@Override
	public BlogDTO select() {
		BlogDTO dto = null;
		
		return dto;
	}

	@Override
	public BlogDTO select(int id) {
		BlogDTO dto = null;
		String query = " SELECT * "
				+ " FROM board "
				+ " WHERE id = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new BlogDTO();
				
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setReadCount(rs.getInt("readCount"));
				dto.setUserId(rs.getInt("userId"));
			}
		} catch (SQLException e) {
			System.out.println(">> BlogDao select(int id)에서 에러 발생 <<");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int delete(int boardId) {
		int resultRow = 0;
		
		String sql = " DELETE FROM board WHERE id = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			resultRow = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(">> BlogDao delete(int boardId)에서 에러 발생 <<");
			e.printStackTrace();
		}
		
		return resultRow;
	}
	
} // end of class
