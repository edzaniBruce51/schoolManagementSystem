/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import sars.gov.za.management.domain.Grade;


/**
 *
 * @author S2028873
 */
public interface GradeServiceLocal {
    Grade save(Grade grade);
    
    Grade findById(Long id);
    
    Grade update(Grade grade);
    
    void deleteAll();
    
    Grade deleteById(Long id);
    
    List<Grade>listAll();
    
    boolean isExist(Grade grade);   
}
