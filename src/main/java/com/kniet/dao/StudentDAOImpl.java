package com.kniet.dao;

import com.kniet.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Repository //repository is for catch sql exceptions etc.
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Student> theQuery =
                currentSession.createQuery("from Student", Student.class);

        return new ArrayList<>(theQuery.getResultList());
    }

    @Override
    public void saveStudent(Student student) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.saveOrUpdate(student);
    }

    @Override
    public Student getStudent(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Student.class,id);
    }

    @Override
    public void deleteStudent(Student student) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.delete(student);
    }

    @Override
    public Student getActiveStudent(String studentBook) {

        Student student;
        Session currentSession = sessionFactory.getCurrentSession();

        try {
            student = (Student) currentSession.createQuery("from Student where student_book = :studentBook").
                    setParameter("studentBook", studentBook).getSingleResult();
        } catch (NoResultException e) {
            student = null;
        }
        return student;
    }

    @Override
    public List<Student> searchStudents(String searchedValue) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Student> query;

        if (searchedValue != null && searchedValue.trim().length() > 0) {
            query = currentSession.createQuery("from Student where" +
                    " lower(last_name) like :value or lower(student_book) like :value",Student.class);
            query.setParameter("value", "%" + searchedValue.toLowerCase() + "%");
        } else {
            query = currentSession.createQuery("from Student", Student.class);
        }

        return new ArrayList<>(query.getResultList());
    }
}
