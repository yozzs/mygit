// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BookDaoImp.java

package com.youzi.dao.impl;

import com.youzi.dao.BookDao;
import com.youzi.domain.Book;
import com.youzi.utils.DBUtils;
import com.youzi.utils.WebUtils;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BookDaoImpl implements BookDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public BookDaoImpl() {
		conn = DBUtils.getMysqlConn();
		ps = null;
		rs = null;
	}
	
	public Map<Integer,Book> getAll() {
		Map<Integer,Book> map = new LinkedHashMap<Integer , Book>();
		try {
			String sql = "select * from book";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Book book;
			for (int i = 0; rs.next();i++){
				book = new Book(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getString(6), rs.getString(7));
				map.put(i,book);
			}
			return map;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtils.close(rs, ps, conn);
		}
	}

//	public Map<String, Book> getAll() {
//		Map<String, Book> map = new LinkedHashMap<String, Book>();
//		try {
//			String sql = "select * from book";
//			ps = conn.prepareStatement(sql);
//			Book book;
//			for (rs = ps.executeQuery(); rs.next(); map.put(rs.getString(1),book)){
//				book = new Book(rs.getString(1), rs.getString(2),
//						rs.getString(3), rs.getString(4), rs.getDouble(5),
//						rs.getString(6), rs.getString(7));
//			}
//			return map;
//		} catch (SQLException e) {
//			throw new RuntimeException(e);
//		} finally {
//			DBUtils.close(rs, ps, conn);
//		}
//	}

	public Book find(String id) {
		label0: {
			Book book1;
			try {
				String sql = "select * from book where id=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				rs = ps.executeQuery();
				if (!rs.next())
					break label0;
				Book book = new Book(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getString(6), rs.getString(7));
				book1 = book;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				DBUtils.close(rs, ps, conn);
			}
			return book1;
		}
		DBUtils.close(rs, ps, conn);
		return null;
	}

	public void add(Book book) {
		String id = book.getId();
		String bookname = book.getBookname();
		String author = book.getAuthor();
		String press = book.getPress();
		double price = book.getPrice();
		String description = book.getDescription();
		String imguri = book.getImguri();
		try {
			String sql = "insert into book values (?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, bookname);
			ps.setString(3, author);
			ps.setString(4, press);
			ps.setDouble(5, price);
			ps.setString(6, description);
			ps.setString(7, imguri);
			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			DBUtils.close(ps, conn);
		}
	}

	public void add(String bookname, String author, String press, double price,
			String description, String imguri) {
		String id = WebUtils.generateID();
		Book book = new Book(id, bookname, author, press, price, description,
				imguri);
		add(book);
	}
}
