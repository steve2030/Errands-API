package com.eclectics.errand.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return studentRepository.findByUsername(username)
                orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


//    Saving Student data

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
//    Get all the student
    public List<Student>getAllStudents(){
        return studentRepository.findAll();
    }
//    Get STUDENT BY id
    public Student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(()->new NoSuchElementException("student not found"));


}
//Delete student
public void deleteStudent(Long id){
        studentRepository.deleteById(id);
}



    }




