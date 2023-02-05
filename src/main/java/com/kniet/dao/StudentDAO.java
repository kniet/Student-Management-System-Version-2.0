package com.kniet.dao;

import com.kniet.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getStudents();
    void saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(Student student);
    Student getActiveStudent(String studentBook);
    List<Student> searchStudents(String searchedValue);
}
