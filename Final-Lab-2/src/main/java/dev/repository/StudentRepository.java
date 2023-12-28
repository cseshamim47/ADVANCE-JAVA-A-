package dev.repository;


import dev.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.Queue;

@Repository
public class StudentRepository {

    private final SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Student student) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    public List<Student> getAll() throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Query<Student> studentQuery = session.createQuery("from Student", Student.class);
        return studentQuery.getResultList();

    }
    public Student findById(int id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    public void updateStudent(Student updatedStudent) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        session.update(updatedStudent);
    }

    public void delete(int id) throws SQLException {
        Session session = sessionFactory.getCurrentSession();
        Student student = findById(id);
        session.delete(student);
    }

    public int getCount() {
        Session session = sessionFactory.getCurrentSession();
        Object result = session.createQuery("SELECT COUNT(*) FROM Student").uniqueResult();
        return result != null ? ((Number) result).intValue() : 0;
    }


}
