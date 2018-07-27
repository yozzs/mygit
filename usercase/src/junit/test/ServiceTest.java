// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ServiceTest.java

package junit.test;

import com.youzi.domain.User;
import com.youzi.exception.UserExistException;
import com.youzi.service.impl.BusinessServiceImp;
import java.io.PrintStream;

public class ServiceTest
{

	public ServiceTest()
	{
	}

	public void testRegister()
	{
		User user = new User("youzi", "123456", "yozzs@foxmail.com", "柚子");
		BusinessServiceImp service = new BusinessServiceImp();
		try
		{
			service.register(user);
			System.out.println("注册成功");
		}
		catch (UserExistException e)
		{
			System.out.println("用户已存在");
		}
	}

	public void testLogin()
	{
		BusinessServiceImp service = new BusinessServiceImp();
		User user = service.login("柚子啊", "123456");
		System.out.println(user);
	}
}
