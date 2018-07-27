package com.youzi.service.impl;

import com.youzi.dao.*;
import com.youzi.domain.Book;
import com.youzi.domain.User;
import com.youzi.exception.UserExistException;
import com.youzi.utils.ServiceUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BusinessServiceImp {

	private UserDao userDao;
	private BookDao bookDao;

	public BusinessServiceImp() {
		userDao = DaoFactory.createUserDao("mysql");
		bookDao = DaoFactory.createBookDao("mysql");
	}

	public Map<Integer,Book> getAllBooksMap() {
		return bookDao.getAll();
	}

	public Book findBook(String id) {
		return bookDao.find(id);
	}

	public List<Book> getAllBooksList(){
		Map<Integer,Book> map = this.getAllBooksMap();
		List<Book> list = new ArrayList<Book>();
		for (Map.Entry<Integer, Book> entry : map.entrySet()) {
			list.add(entry.getValue());
		}
		return list;
	}
	
	public List<Book> get18BooksList(int pageCode){
		int begin = (pageCode-1)*18;
		List<Book> list1 = this.getAllBooksList();
		List<Book> list = new ArrayList<Book>(18);
		for (int i = begin; i < begin+18; i++) {
			if (i<list1.size()) {
				list.add(list1.get(i));
			}else{
				return list;
			}
		}
		return list;
	}
	
	public void register(User user) throws UserExistException {
		boolean b = userDao.find(user.getUsername());
		if (b) {
			throw new UserExistException();
		} else {
			user.setPassword(ServiceUtils.md5(user.getPassword()));
			userDao.add(user);
		}
	}

	public User login(String username, String password) {
		password = ServiceUtils.md5(password);
		return userDao.find(username, password);
	}
	
	public void lastPage(String firstBookId){
		
	}
	
	
}















