package com.youzi.web.conctroller;

import com.youzi.domain.Book;
import com.youzi.domain.User;
import com.youzi.service.impl.BusinessServiceImp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		BusinessServiceImp service = new BusinessServiceImp();
		User user = service.login(username, password);
		
		if (user != null) {
			List<Book> list = service.get18BooksList(1);
			request.getSession().setAttribute("bookList", list);
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("pageCode", "1");
			response.sendRedirect(request.getContextPath() + "/main.jsp");
			// response.sendRedirect((new StringBuilder(String.valueOf(request
			// .getContextPath()))).append("/main.jsp").toString());
		} else {
			request.setAttribute("message", "”√ªß√˚√‹¬Î¥ÌŒÛ");
			request.getRequestDispatcher("/message.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
