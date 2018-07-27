package com.youzi.web.conctroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.youzi.domain.Book;
import com.youzi.service.impl.BusinessServiceImp;

public class NextPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessServiceImp service = new BusinessServiceImp();
		String pageCode = (String) request.getSession().getAttribute("pageCode");
		if(3==Integer.parseInt(pageCode)){
			List<Book> list2 = service.get18BooksList(Integer.parseInt(pageCode));
			request.getSession().setAttribute("bookList", list2);
			response.sendRedirect(request.getContextPath() + "/main.jsp");
		}else{
			List<Book> list1 = service.get18BooksList(Integer.parseInt(pageCode)+1);
			request.getSession().setAttribute("bookList", list1);
			request.getSession().setAttribute("pageCode", Integer.parseInt(pageCode)+1+"");
			response.sendRedirect(request.getContextPath() + "/main.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
