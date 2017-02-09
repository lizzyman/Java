package com.ktds.lizzy.hr.dao.support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class JDBCDaoSupport {
	
	public List selectList(QueryHandler queryHandler) {
		
		loadOracleDriver();
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String query = queryHandler.preparedQuery();
			stmt = conn.prepareStatement(query);
			
			rs = stmt.executeQuery();
			
			List result = new ArrayList();
			while(rs.next()) {
				result.add(queryHandler.getData(rs));
			}
			
			return result;
			
		} catch (SQLException e) {
			System.out.println("oracle 인스턴스를 가져오지 못함.");
			throw new RuntimeException(e.getMessage(), e);
		} finally {
			close(conn, stmt, rs);
		}
	}

	private Connection getConnection() throws SQLException {
		String oracleUrl = "jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn = DriverManager.getConnection(oracleUrl, "hr", "chzhqhf486");
		return conn;
	}

	private void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("oracle driver 로딩 실패");
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	private void close(Connection conn, PreparedStatement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
}
