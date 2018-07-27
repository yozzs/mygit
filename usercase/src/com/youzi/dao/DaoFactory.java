package com.youzi.dao;

import com.youzi.dao.impl.BookDaoImpl;
import com.youzi.dao.impl.UserDaoImpl;

public class DaoFactory {

	public DaoFactory() {
	}

	public static UserDao createUserDao(String type) {
		if ("mysql".equals(type))
			return new UserDaoImpl();
		else
			return null;
	}

	public static BookDao createBookDao(String type) {
		if ("mysql".equals(type))
			return new BookDaoImpl();
		else
			return null;
	}
}
