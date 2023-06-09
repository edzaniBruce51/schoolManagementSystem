/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sars.gov.za.management.domain.Subject;
import sars.gov.za.management.persistence.SubjectRepository;


/**
 *
 * @author S2028873
 */
@Service
public class SubjectService implements SubjectServiceLocal {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }
    @Override
    public Subject findById(Long id) {
        return subjectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("this requested id [" + id + "] does not exist"));
    }
    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }
    @Override
    public void deleteAll() {
        subjectRepository.deleteAll();
    }
    @Override
    public Subject deleteById(Long id) {
        Subject subject=findById(id);
        if(subject!=null){
        subjectRepository.deleteById(id);
        }
        return subject;
    }
    @Override
    public List<Subject> listAll() {
        return subjectRepository.findAll();
    }
    @Override
    public boolean isExist(Subject subject) {
        return subjectRepository.findById(subject.getId())!=null;
    }
}
