/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sars.gov.za.management.domain.Student;
import sars.gov.za.management.persistence.StudentRepository;


/**
 *
 * @author S2028873
 */
 @Service
public class StudentService implements StudentServiceLocal {
       
        @Autowired
        private StudentRepository studentRepository;
   
        @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("The request id ["+id+"] does not exist"));
    }

    @Override
    public Student update(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteAll() {
        studentRepository.deleteAll();
    }

    @Override
    public Student deleteById(Long id) {
        Student student = findById(id);
        if(student != null){
        studentRepository.deleteById(id);
        }
        return student;
    }

    @Override
    public List<Student> listAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean isExist(Student student) {
        return studentRepository.findById(student.getId())!=null;
    }
}
