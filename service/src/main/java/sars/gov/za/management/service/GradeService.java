/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sars.gov.za.management.domain.Grade;
import sars.gov.za.management.persistence.GradeRepository;


/**
 *
 * @author S2028873
 */
@Service
public class GradeService implements GradeServiceLocal {

    @Autowired
    private GradeRepository gradeRepository;

    @Override
    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade findById(Long id) {
        return gradeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("the requested id [" + id + "] does not exist"));
    }

    @Override
    public Grade update(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public void deleteAll() {
        gradeRepository.deleteAll();
    }

    @Override
    public Grade deleteById(Long id) {
        Grade grade = findById(id);
        if (grade != null) {
            gradeRepository.deleteById(id);
        }
        return grade;
    }

    @Override
    public List<Grade> listAll() {
        return gradeRepository.findAll();
    }

    @Override
    public boolean isExist(Grade grade) {

        return gradeRepository.findById(grade.getId()) != null;
    }

}

