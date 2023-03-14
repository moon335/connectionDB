package com.tenco.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tenco.myblog.dto.UserDTO;
import com.tenco.myblog.utils.DBHelper;

public class UserDAO implements IUserDAO{

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		conn = DBHelper.getInstance().getConnection();
	}
	
	
	@Override
	public UserDTO select(String username) {
		UserDTO dto = null;
		String sql = "SELECT * FROM user WHERE username = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new UserDTO();
				dto.setId(rs.getInt("id"));
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setUserRole(rs.getString("userRole"));
				dto.setCreateDate(rs.getString("createDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}


	@Override
	public int insert(String username, String password, String email, String address) {
		int resultRow = 0;
		String query = " INSERT INTO user(username, password, email, address) "
				+ " VALUES (?, ?, ?, ?) ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			pstmt.setString(4, address);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultRow;
	}
	
	
	
	
} // end of class
