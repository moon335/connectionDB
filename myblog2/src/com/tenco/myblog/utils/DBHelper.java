package com.tenco.myblog.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
	
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306";
	private static final String DB_DATABASE_NAME = "myblog";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "bloguser";
	private static final String DB_PASSWORD = "1q2w3e4r5t";
	
	// db 프로그램이 매우 많기 때문에 각각 커넥션을 만들면 매우 복잡해지기 때문에
	// 인터페이스 사용
	private Connection conn;
	
	// 싱글톤 패턴
	// 1. 기본생성자 private로 만들기
	private DBHelper() {}
	
	// 2. 자기자신을 private으로 선언해준다.
	private static DBHelper dbHelper;
	
	// 객체가 메모리에 올라갔을 때(new했을 때) 인스턴스라고 한다.
	public static DBHelper getInstance() {
		if(dbHelper == null) {
			dbHelper = new DBHelper();
		}
		return dbHelper;
	}
	
	public Connection getConnection() {
		// 한번도 생성하지 않았다면 동작
		if(conn == null) {
			String urlFormat = "jdbc:mysql://%s:%s/%s?serverTimezone=Asia/Seoul&characterEncoding=%s";
			String url = String.format(urlFormat, DB_HOST, DB_PORT, DB_DATABASE_NAME, DB_CHARSET);
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(url, DB_USER_NAME, DB_PASSWORD);
				System.out.println(">> DB 연결 완료 <<");
			} catch (Exception e) {
				System.out.println(">> DBHelper에서 오류가 발생 했어! <<");
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
} // end of class
