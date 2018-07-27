package com.youzi.dao.impl;

import com.youzi.dao.UserDao;
import com.youzi.domain.User;
import com.youzi.utils.DBUtils;
import java.io.PrintStream;
import java.sql.*;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
	}

	public void add(User user) {
		Connection conn = DBUtils.getMysqlConn();
		PreparedStatement ps = null;
		try {
			String sql = "INSERT INTO user(username,password,email,nickname) VALUES(?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getNickname());
			ps.execute();
			System.out.println("插入一条记录");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtils.close(ps, conn);
		}
	}

	public User find(String username, String password) {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		label0: {
			conn = DBUtils.getMysqlConn();
			ps = null;
			rs = null;
			User user1;
			try {
				String sql = "select * from user where username=? and password=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery();
				if (!rs.next())
					break label0;
				User user = new User(rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
				user1 = user;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				DBUtils.close(rs, ps, conn);
			}
			return user1;
		}
		return null;
	}

	public boolean find(String username) {
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		conn = DBUtils.getMysqlConn();
		ps = null;
		rs = null;
		try {
			String sql = "select * from user where username=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return false;

	}
}
