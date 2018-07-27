package com.youzi.web.conctroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.youzi.domain.Book;
import com.youzi.service.impl.BusinessServiceImp;

public class LastPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BusinessServiceImp service = new BusinessServiceImp();
		String pageCode = (String) request.getSession().getAttribute("pageCode");
		if(1==Integer.parseInt(pageCode)){
			List<Book> list2 = service.get18BooksList(Integer.parseInt(pageCode));
			request.getSession().setAttribute("bookList", list2);
			response.sendRedirect(request.getContextPath() + "/main.jsp");
		}else{
			List<Book> list1 = service.get18BooksList(Integer.parseInt(pageCode)-1);
			request.getSession().setAttribute("bookList", list1);
			request.getSession().setAttribute("pageCode", Integer.parseInt(pageCode)-1+"");
			response.sendRedirect(request.getContextPath() + "/main.jsp");
		}
		
		
	/*	String id = request.getParameter("firstBookId");
		List<Book> list = (List<Book>) request.getSession().getAttribute("listBook");
		Map<Integer,Book> map = service.getAllBooksMap();
		int begin=0;
		for (Map.Entry<Integer, Book> entry : map.entrySet()) {
			if (id.equals(entry.getValue().getId())) {
				begin = entry.getKey();
			}
		}
		int pageCount = begin%18 + 1;
		pageCount = pageCount==1 ? 1 : --pageCount;
		if(begin!=0){
			List<Book> list1 = service.get18BooksList(begin-18);
			request.getSession().setAttribute("listBook", list1);
			response.sendRedirect("request.getContextPath()" + "/main.jsp");
		}else{
			List<Book> list2 = service.get18BooksList(0);
			request.getSession().setAttribute("bookList", list2);
		}
		*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
