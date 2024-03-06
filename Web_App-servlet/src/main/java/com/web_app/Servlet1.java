package com.web_app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Servlet1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		System.out.println(email);
		System.out.println(password);
		
		Cookie cookie = new Cookie("email", email);
		Cookie cookie2 = new Cookie("password", password);
		resp.addCookie(cookie);
		resp.addCookie(cookie2);
		
		req.setAttribute("email", email);
		
		PrintWriter writer = resp.getWriter();
	 	writer.write("<html><body>");
        writer.write("<h1>"+ email + "</h1>");
        writer.write("</body></html>");
	}
	
}
