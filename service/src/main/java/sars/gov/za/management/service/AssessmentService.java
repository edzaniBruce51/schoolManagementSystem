/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sars.gov.za.management.domain.Assessment;
import sars.gov.za.management.persistence.AssessmentRepository;


/**
 *
 * @author S2028873
 */
@Service
public class AssessmentService implements AssessmentServiceLocal{
    
    @Autowired
  private AssessmentRepository assessmentRepository;

    @Override
    public Assessment save(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public Assessment findById(Long id) {
        return assessmentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("the requested id [" +id+ "] does not exist"));
    }

    @Override
    public Assessment update(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public void deleteAll() {
        assessmentRepository.deleteAll();
    }

    @Override
    public Assessment deleteById(Long id) {
        Assessment assessment=findById(id);
        if (assessment != null){
            assessmentRepository.findById(id);
    }
        return assessment;
    }

    @Override
    public List<Assessment> listAll() {
        return assessmentRepository.findAll();
    }

    @Override
    public boolean isExist(Assessment assessment) {
  return assessmentRepository.findById(assessment.getId()) != null;
    }
}
