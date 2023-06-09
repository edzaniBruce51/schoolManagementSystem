/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sars.gov.za.management.mb;


import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import sars.gov.za.management.domain.Grade;
import sars.gov.za.management.service.GradeServiceLocal;

/**
 *
 * @author S2028398
 */
@ManagedBean
@ViewScoped
public class GradeBean extends BaseBean<Grade> {

    @Autowired
    private GradeServiceLocal gradeService;

    @PostConstruct
    public void init() {
        reset().setList(true);
        setPanelTitleName("Grades");
        addCollections(gradeService.listAll());
    }

    public void addOrUpdate(Grade grade) {
        reset().setAdd(true);
        if (grade != null) {
            setPanelTitleName("Update Grade");
            grade.setUpdatedBy(getActiveUser().getIdentifier());
            grade.setUpdateDate(new Date()); 
        } else {
            setPanelTitleName("Add Grade");
            grade = new Grade();
            grade.setCreatedBy(getActiveUser().getIdentifier());
            grade.setCreatedDate(new Date());
            addCollection(grade);
        }
        addEntity(grade);
    }

    public void save(Grade grade) {
        if (grade.getId() != null) {
            gradeService.update(grade);
            addInformationMessage("Grade was successfully updated.");
        } else {
            gradeService.save(grade);
            addInformationMessage("Grade successfully created.");
        }
        reset().setList(true);
        setPanelTitleName("Grades");
    }

    public void cancel(Grade grade) {
        if (grade.getId() == null && getGrades().contains(grade)) {
            remove(grade);
        }
        reset().setList(true);
        setPanelTitleName("Grades");
    }

    public void delete(Grade grade) {
        gradeService.deleteById(grade.getId());
        remove(grade);
        addInformationMessage("Grade was successfully deleted");
        reset().setList(true);
        setPanelTitleName("Grades");
    }

    public List<Grade> getGrades() {
        return this.getCollections();
    }  
 
}
