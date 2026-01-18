package com.Springboot.StudentManagement.DAO;

import com.Springboot.StudentManagement.Entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student theStudent);
    public List<Student> findAll();
    public Student findById(int id);
    public void update(Student theStudent);
    public void deleteByid(int id);
    public int deleteAll();
}
