package com.studentmngsys.dob;

import java.io.IOException;

import com.student_view.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class UserController extends HttpServlet {
    private StudentaDao dao = new StudentDaoImp();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        student.setRollno(Integer.parseInt(req.getParameter("rollno")));
        student.setName(req.getParameter("name"));
        student.setPhone(Long.parseLong(req.getParameter("phone")));
        student.setEmail(req.getParameter("email"));
        student.setAge(Integer.parseInt(req.getParameter("age")));
        student.setAddress(req.getParameter("address"));
        student.setPassword(req.getParameter("password"));
    	
    	
    	
    	
    	int rollno = Integer.parseInt(req.getParameter("rollno"));
        String name = req.getParameter("name");
        long phone = Long.parseLong(req.getParameter("phone"));
        String email = req.getParameter("email");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        
         

        Student student = new Student(rollno, name, phone, email, age, address, password);

        String message;
        if (dao.saveStudent(student)) {
            resp.sendRedirect("Welcome.jsp");
        } else {
            message = "Data not saved";
            req.setAttribute("message", "student data not saved");
            req.getRequestDispatcher("Register.jsp").forward(req, resp);
        }
    }
}
