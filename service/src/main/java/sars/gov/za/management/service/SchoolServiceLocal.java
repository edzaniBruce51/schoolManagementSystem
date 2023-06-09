/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.List;
import sars.gov.za.management.domain.School;


/**
 *
 * @author S2028873
 */
public interface SchoolServiceLocal {

    School save(School school);

    School findById(Long id);

    School update(School school);

    void deleteAll();

    School deleteById(Long id);

    List<School> listAll();

    boolean isExist(School school);

    School findBySchoolname(String schoolname);

}
