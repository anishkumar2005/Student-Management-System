package com.Springboot.StudentManagement.DAO;

import com.Springboot.StudentManagement.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOimpl implements StudentDAO{

    private EntityManager entityManager;

    public StudentDAOimpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student>theQuery=entityManager.createQuery("FROM Student",Student.class);

        return theQuery.getResultList();
    }

    @Override
    public Student findById(int id) {
        Student theStudent=entityManager.find(Student.class,id);
        return theStudent;
    }

    @Override
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    public void deleteByid(int id) {
        Student theStudent=entityManager.find(Student.class,id);
        entityManager.remove(theStudent);
    }

    @Override
    public int deleteAll() {
        Query theQuery= entityManager.createQuery("DELETE FROM Student");
        return theQuery.executeUpdate();
    }
}
