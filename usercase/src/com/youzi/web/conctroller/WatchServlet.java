package com.youzi.web.conctroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youzi.domain.Book;
import com.youzi.service.impl.BusinessServiceImp;

public class WatchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookId = request.getParameter("bookId");
		BusinessServiceImp service = new BusinessServiceImp();
		Book book = service.findBook(bookId);
		request.setAttribute("watchbook", book);
		request.getRequestDispatcher("/main.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
