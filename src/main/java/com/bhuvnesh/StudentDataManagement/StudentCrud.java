package com.bhuvnesh.StudentDataManagement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class StudentCrud {
    
    private SessionFactory sessionFactory;

    public StudentCrud() {
        Configuration config = new Configuration().configure().addAnnotatedClass(Student.class);
        sessionFactory = config.buildSessionFactory();
    }

    // Create Student
    public void saveStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(student);
        tx.commit();
        session.close();
    }

    // Read (Get Student by Rollno)
    public Student getStudent(int rollno) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, rollno);
        session.close();
        return student;
    }

    // Read (Get all students)
    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents() {
        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("FROM Student").list();
        session.close();
        return students;
    }

    // Update Student
    public void updateStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(student);
        tx.commit();
        session.close();
    }

    // Delete Student
    public void deleteStudent(int rollno) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = session.get(Student.class, rollno);
        if (student != null) {
            session.delete(student);
        }
        tx.commit();
        session.close();
    }
}
