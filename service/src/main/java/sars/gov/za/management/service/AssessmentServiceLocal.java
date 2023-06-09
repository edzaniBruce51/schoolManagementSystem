/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import sars.gov.za.management.domain.Assessment;


/**
 *
 * @author S2028873
 */
public interface AssessmentServiceLocal {
       
    Assessment save(Assessment assessment);
    
    Assessment findById(Long id);
    
    Assessment update(Assessment assessment);
    
    void deleteAll();
    
    Assessment deleteById(Long id);
    
    List<Assessment>listAll();
    
    boolean isExist(Assessment assessment);
    
}
