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
		User user = new User("youzi", "123456", "yozzs@foxmail.com", "����");
		BusinessServiceImp service = new BusinessServiceImp();
		try
		{
			service.register(user);
			System.out.println("ע��ɹ�");
		}
		catch (UserExistException e)
		{
			System.out.println("�û��Ѵ���");
		}
	}

	public void testLogin()
	{
		BusinessServiceImp service = new BusinessServiceImp();
		User user = service.login("���Ӱ�", "123456");
		System.out.println(user);
	}
}
