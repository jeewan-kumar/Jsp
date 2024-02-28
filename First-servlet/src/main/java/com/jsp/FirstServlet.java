package com.jsp;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FirstServlet implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("First servlet");
		
	}

	@Override
	public String getServletInfo() {
	
		return null;
	}

	@Override
	public void destroy() {
	
	}
	
}
