/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import sars.gov.za.management.domain.Employee;

/**
 *
 * @author S2028873
 */

public interface EmployeeServiceLocal {
 Employee save(Employee employee);
    
    Employee findById(Long id);
    
    Employee update(Employee employee);
    
    void deleteAll();
    
    Employee deleteById(Long id);
    
    List<Employee>listAll();
    
    boolean isExist(Employee employee);   
}
