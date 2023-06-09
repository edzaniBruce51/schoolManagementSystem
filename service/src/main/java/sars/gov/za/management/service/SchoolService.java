/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sars.gov.za.management.domain.School;
import sars.gov.za.management.persistence.SchoolRepository;



/**
 *
 * @author S2028873
 */
@Service
public class SchoolService implements SchoolServiceLocal {
    
    @Autowired
    private SchoolRepository schoolRepository;

    
    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("the requested id[ "+ id + "] does not exist."));
    }

    @Override
    public School update(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void deleteAll() {
        schoolRepository.deleteAll();
    }

    @Override
    public School deleteById(Long id) {
        School school =findById(id);
       if (school!=null){
           schoolRepository.deleteById(id);
    } 
        return school;
    }

    @Override
    public List<School> listAll() {
        return schoolRepository.findAll();
    }

    @Override
    public boolean isExist(School school) {
        return schoolRepository.findById(school.getId()) != null;
    }

    @Override
    public School findBySchoolname(String schoolname) {
      return schoolRepository.findBySchoolname(schoolname);
    }   
}

