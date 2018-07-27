package com.youzi.web.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	protected FilterConfig filterConfig = null;
	private Set notCheckURLList = new HashSet();

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		if( null==request.getSession().getAttribute("user")&&request.getRequestURI().indexOf("index.jsp")==-1){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		arg2.doFilter(arg0, arg1);
	}
	
//	private boolean checkRequestURIInNotFilterList(HttpServletRequest request){
//		String uri = request.getServletPath() + (request.getPathInfo()==null?"":request.getPathInfo());
//		String temp = request.getRequestURI();
//		temp = temp.substring(request.getContextPath().length()+1);
//		return notCheckURLList.contains(uri);
//	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
		String notCheckURLListStr = filterConfig.getInitParameter("notCheckURLList");
		String[] params = notCheckURLListStr.split(",");
		for (int i = 0; i < params.length; i++) {
			notCheckURLList.add(params[i].trim());
		}
	}

}
