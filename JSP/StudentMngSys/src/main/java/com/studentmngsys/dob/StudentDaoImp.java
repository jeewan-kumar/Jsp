package com.studentmngsys.dob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student_view.Student;

public class StudentDaoImp implements StudentaDao {
    Connection connection = ConnectionConfig.getConnection();

    @Override
    public boolean saveStudent(Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, student.getRollno());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setLong(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.setInt(5, student.getAge());
            preparedStatement.setString(6, student.getAddress());
            preparedStatement.setString(7, student.getPassword());

            int execute = preparedStatement.executeUpdate();
            return execute > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name=?, phone=?, email=?, age=?, address=?, password=? WHERE rollno=?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setLong(2, student.getPhone());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setInt(4, student.getAge());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6, student.getPassword());
            preparedStatement.setInt(7, student.getRollno());

            int execute = preparedStatement.executeUpdate();
            return execute > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(Student student) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE rollno=?");
            preparedStatement.setInt(1, student.getRollno());

            int execute = preparedStatement.executeUpdate();
            return execute > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Student findStudentById(int rollno) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE rollno=?");
            preparedStatement.setInt(1, rollno);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Student student = new Student();
                student.setRollno(resultSet.getInt("rollno"));
                student.setName(resultSet.getString("name"));
                student.setPhone(resultSet.getLong("phone"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setAddress(resultSet.getString("address"));
                student.setPassword(resultSet.getString("password"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setRollno(resultSet.getInt("rollno"));
                student.setName(resultSet.getString("name"));
                student.setPhone(resultSet.getLong("phone"));
                student.setEmail(resultSet.getString("email"));
                student.setAge(resultSet.getInt("age"));
                student.setAddress(resultSet.getString("address"));
                student.setPassword(resultSet.getString("password"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
