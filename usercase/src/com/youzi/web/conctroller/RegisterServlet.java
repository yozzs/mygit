// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   RegisterServlet.java

package com.youzi.web.conctroller;

import com.youzi.domain.User;
import com.youzi.exception.UserExistException;
import com.youzi.service.impl.BusinessServiceImp;
import com.youzi.web.form.RegisterForm;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		RegisterForm form = new RegisterForm();
		for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
			String name = (String) e.nextElement();
			String value = request.getParameter(name);
			if ("username".equals(name.trim()))
				form.setUsername(value);
			else if ("password".equals(name.trim()))
				form.setPassword(value);
			else if ("password2".equals(name.trim()))
				form.setPassword2(value);
			else if ("email".equals(name.trim()))
				form.setEmail(value);
			else if ("nickname".equals(name.trim()))
				form.setNickname(value);
			else if ("checkcode".equals(name.trim()))
				form.setCheckcode(value);
		}

		boolean b = form.volidate();
		String client_checkcode = request.getParameter("checkcode");
		String server_checkcode = (String) request.getSession().getAttribute(
				"imagecheckcode");
		if (client_checkcode == null
				|| server_checkcode == null
				|| !client_checkcode.toLowerCase().equals(
						server_checkcode.toLowerCase())) {
			b = false;
			form.getErrors().put("checkcode", "验证码不正确");
		}
		if (!b) {
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
			return;
		}
		User user = new User();
		user.setUsername(form.getUsername());
		user.setPassword(form.getPassword());
		user.setEmail(form.getEmail());
		user.setNickname(form.getNickname());
		BusinessServiceImp service = new BusinessServiceImp();
		try {
			service.register(user);
			request.setAttribute(
					"message",
					(new StringBuilder("恭喜你，注册成功！浏览器将在3秒后跳转，如未跳转，请点击<a href=\""))
							.append(request.getContextPath())
							.append("/index.jsp\">这里</a>")
							.append("<meta http-equiv='refresh' content='3;url=")
							.append(request.getContextPath())
							.append("/index.jsp'>").toString());
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		} catch (UserExistException e1) {
			form.getErrors().put("username", "用户名已存在");
			request.setAttribute("form", form);
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(
					request, response);
			return;
		} catch (Exception e2) {
			e2.printStackTrace();
			request.setAttribute("message", "服务器出现未知错误");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
			return;
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
