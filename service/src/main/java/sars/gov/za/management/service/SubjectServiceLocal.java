/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import sars.gov.za.management.domain.Subject;


/**
 *
 * @author S2028873
 */
public interface SubjectServiceLocal {

    Subject save(Subject subject);

    Subject findById(Long id);

    Subject update(Subject subject);

    void deleteAll();

    Subject deleteById(Long id);

    List<Subject> listAll();

    boolean isExist(Subject subject);
}
