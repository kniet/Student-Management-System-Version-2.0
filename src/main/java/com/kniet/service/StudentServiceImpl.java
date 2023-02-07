package com.kniet.service;

import com.kniet.dao.StudentDAO;
import com.kniet.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //our service is used for business logic
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    @Transactional //spring handle start and stop of transactions for us
    public List<Student> getStudents() {

        return studentDAO.getStudents();
    }

    @Override
    @Transactional
    public void saveStudent(Student student) {
        studentDAO.saveStudent(student);
    }

    @Override
    @Transactional
    public Student getStudent(int id) {

        return studentDAO.getStudent(id);
    }

    @Override
    @Transactional
    public void deleteStudent(Student student) {

        studentDAO.deleteStudent(student);
    }

    @Override
    @Transactional
    public boolean ifExists(String studentBook) {

        boolean userInDb = true;
        if (studentDAO.getActiveStudent(studentBook) == null) {
            userInDb = false;
        }
        return userInDb;
    }

    @Override
    @Transactional
    public List<Student> searchStudents(String searchedValue) {

        return studentDAO.searchStudents(searchedValue);
    }
}
