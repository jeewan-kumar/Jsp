package com.web_app;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login1")

public class Servlet3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		String name = (String) s.getAttribute("a");
		String name1 = (String) s.getAttribute("b");
		User user = (User) s.getAttribute("user");
		
		PrintWriter writer = resp.getWriter();
	 	writer.write("<html><body>");
        writer.write("<h1>"+ name + name1+user+"</h1>");
        writer.write("</body></html>");
	}
	
}
