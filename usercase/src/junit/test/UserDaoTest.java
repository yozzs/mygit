// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   UserDaoTest.java

package junit.test;

import com.youzi.dao.UserDao;
import com.youzi.dao.impl.UserDaoImpl;
import java.io.PrintStream;

import org.junit.Test;

public class UserDaoTest {

	public UserDaoTest() {
	}

	public void testFind() {
		UserDao dao = new UserDaoImpl();
		com.youzi.domain.User user = dao.find("youzi", "123456");
		System.out.println(user);
	}

	@Test
	public void testFind2() {
		UserDao dao = new UserDaoImpl();
		System.out.println(dao.find("youzi"));
	}
}
