package com.Springboot.StudentManagement.Services;

import com.Springboot.StudentManagement.DAO.StudentDAO;
import com.Springboot.StudentManagement.Entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicesImplementation implements StudentServices{


    private StudentDAO studentDAO;

    public ServicesImplementation(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public void save(Student theStudent) {
        studentDAO.save(theStudent);
    }

    @Override
    public Student findById(int id) {
        Student theStudent=studentDAO.findById(id);
        return theStudent;
    }

    @Override
    public List<Student> findAll() {

        return studentDAO.findAll();
    }

    @Override
    public void update(Student theStudent) {
        studentDAO.update(theStudent);
    }

    @Override
    public void deleteByid(int id) {
        studentDAO.deleteByid(id);
    }

    @Override
    public int deleteAll() {

        return studentDAO.deleteAll();
    }
}
