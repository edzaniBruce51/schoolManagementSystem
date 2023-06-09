/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.mb;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import sars.gov.za.management.domain.Subject;
import sars.gov.za.management.service.SubjectServiceLocal;

/**
 *
 * @author S2028873
 */
@ManagedBean
@ViewScoped
public class SubjectBean extends BaseBean<Subject> {
    @Autowired
    private SubjectServiceLocal subjectService;

    @PostConstruct
    public void init() {
        reset().setList(true);
        setPanelTitleName("Grades");
        addCollections(subjectService.listAll());
    }

    public void addOrUpdate(Subject subject) {
        reset().setAdd(true);
        if (subject != null) {
            setPanelTitleName("Update Subject");
            subject.setUpdatedBy(getActiveUser().getIdentifier());
            subject.setUpdateDate(new Date()); 
        } else {
            setPanelTitleName("Add Subject");
            subject = new Subject();
            subject.setCreatedBy(getActiveUser().getIdentifier());
            subject.setCreatedDate(new Date());
            addCollection(subject);
        }
        addEntity(subject);
    }

    public void save(Subject subject) {
        if (subject.getId() != null) {
            subjectService.update(subject);
            addInformationMessage("Subject was successfully updated.");
        } else {
            subjectService.save(subject);
            addInformationMessage("Grade successfully created.");
        }
        reset().setList(true);
        setPanelTitleName("Subject");
    }

    public void cancel(Subject subject) {
        if (subject.getId() == null && getSubjects().contains(subject)) {
            remove(subject);
        }
        reset().setList(true);
        setPanelTitleName("Subject");
    }

    public void delete(Subject subject) {
        subjectService.deleteById(subject.getId());
        remove(subject);
        addInformationMessage("Subject was successfully deleted");
        reset().setList(true);
        setPanelTitleName("Subject");
    }

    public List<Subject> getSubjects() {
        return this.getCollections();
    }  
}
