/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sars.gov.za.management.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sars.gov.za.management.domain.Assessment;

/**
 *
 * @author S2028873
 */
@Repository
public interface AssessmentRepository  extends JpaRepository<Assessment,Long> {
    
}
