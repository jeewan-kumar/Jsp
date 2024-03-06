package com.web_app;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class Servlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet2");

        String email = null;
        Cookie[] cookies = req.getCookies();
       
            for (Cookie cookie : cookies) {
            	System.out.println(cookie.getName());
                
                    email = cookie.getValue();                    
                
            }  

            PrintWriter write = resp.getWriter();
            write.write("<body><html>");
            write.write("<h1>Email: " + email + "</h1>");  
       
            write.write("</body></html>");
    }
}
