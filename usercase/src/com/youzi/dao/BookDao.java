// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BookDao.java

package com.youzi.dao;

import com.youzi.domain.Book;

import java.util.Map;

public interface BookDao {
	// �õ�������
	public abstract Map<Integer,Book> getAll();

	// ����id�����鲢����Book����
	public abstract Book find(String s);

	// ����Book������ӵ����ݿ�
	public abstract void add(Book book);

	// ����Book�ĸ�������ӵ����ݿ�
	public abstract void add(String s, String s1, String s2, double d,
			String s3, String s4);
}
