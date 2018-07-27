// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BookDao.java

package com.youzi.dao;

import com.youzi.domain.Book;

import java.util.Map;

public interface BookDao {
	// 得到所有书
	public abstract Map<Integer,Book> getAll();

	// 根据id查找书并返回Book对象
	public abstract Book find(String s);

	// 根据Book对象添加到数据库
	public abstract void add(Book book);

	// 根据Book的各属性添加到数据库
	public abstract void add(String s, String s1, String s2, double d,
			String s3, String s4);
}
