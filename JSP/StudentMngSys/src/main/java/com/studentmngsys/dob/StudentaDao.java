package com.studentmngsys.dob;

import java.util.List;

import com.student_view.Student;

public interface StudentaDao {
    boolean saveStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Student student);
    Student findStudentById(int rollno);
    List<Student> findAllStudents();
}
