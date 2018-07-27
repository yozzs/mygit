// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ListBookServlet.java

package com.youzi.web.conctroller;

import com.youzi.service.impl.BusinessServiceImp;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ListBookServlet extends HttpServlet {

	public ListBookServlet() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessServiceImp service = new BusinessServiceImp();
		java.util.Map map = service.getAllBooksMap();
		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/jsp/listbook.jsp").forward(
				request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
