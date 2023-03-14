package com.dinnis0511.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dinnis0511.blog.dto.UserDto;
import com.dinnis0511.blog.utils.DBHelper;

public class UserDao implements IUserDao{

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDao() {
		conn = DBHelper.getInstance().getConnection();
	}
	
	// 모든 회원 조회
	@Override
	public ArrayList<UserDto> select() {
		ArrayList<UserDto> list = new ArrayList<>();
		String sql = "SELECT * FROM user";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				UserDto dto = new UserDto();
				dto.setId(rs.getInt("id"));
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setUserRole(rs.getString("userRole"));
				dto.setCreateDate(rs.getString("createDate"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			System.out.println(">> UserDao select 메서드에서 오류 발생 <<");
			e.printStackTrace();
		}
		return list;
	}
	
	// 특정 회원 select 메서드
	@Override
	public UserDto select(String username) {
		UserDto dto = null;
		String query = " SELECT * FROM user "
				+ " WHERE username = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new UserDto();
				dto.setId(rs.getInt("id"));
				dto.setUsername(rs.getString("username"));
				dto.setPassword(rs.getString("password"));;
				dto.setEmail(rs.getString("email"));
				dto.setAddress(rs.getString("address"));
				dto.setUserRole(rs.getString("userRole"));
				dto.setCreateDate(rs.getString("createDate"));
			}
		} catch (Exception e) {
			System.out.println(">> UserDao select(username) 메서드에서 오류 발생 <<");
			e.printStackTrace();
		}
		return dto;
	}
	
	// 회원가입용 insert
	@Override
	public int insert(UserDto dto) {
		int resultRow = 0;
		String query = " INSERT INTO user(username, password, email, address, userRole, createDate) "
				+ " VALUES (?, ?, ?, ?, ?, now()) ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getUserRole());
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(">> UserDao insert 메서드에서 오류 발생 <<");
			e.printStackTrace();
		}
		return resultRow;
	}

	@Override
	public int delete(String username, String password) {
		int resultRow = 0;
		String query = "DELETE FROM user WHERE username = ? AND password = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultRow;
	}

	@Override
	public int update(UserDto dto) {
		int resultRow = 0;
		String sql = "UPDATE user "
				+ " SET password = ?, email = ?, address = ? "
				+ " WHERE username = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getAddress());
			pstmt.setString(4, dto.getUsername());
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(">> UserDao update 메서드에서 오류 발생 <<");
			e.printStackTrace();
		}
		return resultRow;
	}


}
