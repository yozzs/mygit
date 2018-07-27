package com.youzi.dao;

import com.youzi.domain.User;

public interface UserDao {

	public abstract void add(User user);

	public abstract User find(String s, String s1);

	public abstract boolean find(String s);
}
