/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import sars.gov.za.management.domain.Student;


/**
 *
 * @author S2028873
 */
public interface StudentServiceLocal {
     Student save(Student student);
    
    Student findById(Long id);
    
    Student update(Student student);
    
    void deleteAll();
    
    Student deleteById(Long id);
    
    List<Student>listAll();
    
    boolean isExist(Student student);
}
