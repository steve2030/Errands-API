package com.eclectics.errand.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

//    student registration ENDPOINT
    @PostMapping("register")
    public ResponseEntity<Student>register(@RequestBody Student student){
        Student savedStudent=studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

//    All the students Endpoint
    @GetMapping("/students")
    public ResponseEntity<List<Student>>getAllStudents(){
        List<Student>students=studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
// Get student by Id
    @GetMapping ("/{id}")
    public ResponseEntity<Void>getStudentById(@PathVariable Long id){
        Student student=studentService.getStudentById(id);
                return new ResponseEntity<>(student, HttpStatus.OK);
    }

//    #Deleta the Student endpoint
   @DeleteMapping ("/{id}")
    public ResponseEntity<Void>deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }






}

