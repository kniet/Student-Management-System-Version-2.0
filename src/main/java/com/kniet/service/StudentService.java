package com.kniet.service;

import com.kniet.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getStudents();
    void saveStudent(Student student);
    Student getStudent(int id);
    void deleteStudent(Student student);
    boolean ifExists(String studentBook);
    List<Student> searchStudents(String searchedValue);
}
