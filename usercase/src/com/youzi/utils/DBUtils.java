package com.youzi.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

	static Properties pros;
	
	static {
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static Connection getMysqlConn() {
		Connection conn = null;
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			conn = DriverManager
					.getConnection(pros.getProperty("mysqlURL"),
							pros.getProperty("mysqlUser"),
							pros.getProperty("mysqlPwd"));
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close(ResultSet rs, Statement ps, Connection conn) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement ps, Connection conn) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
