package com.Springboot.StudentManagement.Rest;

import com.Springboot.StudentManagement.Entity.Student;
import com.Springboot.StudentManagement.Services.StudentServices;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RestStudent {

    private StudentServices services;
    private JsonMapper jsonMapper;
    public RestStudent(StudentServices services,JsonMapper jsonMapper) {
        this.services = services;
        this.jsonMapper=jsonMapper;
    }

    @PostMapping("/student")
    public void post(@RequestBody Student theStudent){
        theStudent.setId(0);
        services.save(theStudent);
    }
    @GetMapping("/student")
    public List<Student> findall(){
        return services.findAll();
    }
    @GetMapping("/student/{id}")
    public Student getById(@PathVariable int id){
        Student tempStudent=services.findById(id);
        if(tempStudent==null){
            throw new StudentNotFound("Student not found"+id);
        }
        return tempStudent;
    }
    @PatchMapping("/student/{id}")
    public void update(@PathVariable int id,@RequestBody Map<String,Object> payload){
        Student theStudent=services.findById(id);
        if(theStudent==null){
            throw new RuntimeException("invalid id "+id);
        }
        if(payload.containsKey(id)){
            throw new RuntimeException("id value cant be modified "+id);
        }
        Student patchedStudent=jsonMapper.updateValue(theStudent,payload);
        services.update(patchedStudent);
    }
    @DeleteMapping("/student/{id}")
    public void deleteId(@PathVariable int id){
        services.deleteByid(id);
    }

    @DeleteMapping("/student")
        public int deleteAll(){
            return services.deleteAll();

    }
    @PutMapping("/student")
    public void updatestudent(@RequestBody  Student theStudent){
        services.update(theStudent);
    }

}
