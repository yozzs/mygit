package com.youzi.web.conctroller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogoutSerlvet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.removeAttribute("user");
		request.setAttribute("message",(new StringBuilder("ע���ɹ������������3�����ת����δ��ת������<a href=\""))
						.append(request.getContextPath())
						.append("/index.jsp\">����</a>")
						.append("<meta http-equiv='refresh' content='3;url=")
						.append(request.getContextPath())
						.append("/index.jsp'>").toString());
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
