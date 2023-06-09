/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited; 
import sars.gov.za.management.common.AssessmentStatus;

/**
 *
 * @author S2028873
 */
@Table(name="assessment")
@Entity
@Audited
public class Assessment extends BaseEntity{

    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String discription;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="due_date")
    private Date dueDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="first_submission_date")
    private Date firstSubmissionDate;
    
    @Column(name="full_mark")
    private double fullMark;
    
    @Column(name="pass_mark")
    private double passMark;
    
    @Column(name="student_mark")
    private double studentMark;
    
    @ManyToOne(cascade= CascadeType.MERGE,fetch=FetchType.LAZY)
    private Subject subject;
    
    @Enumerated(EnumType.STRING)
    @Column(name="assessment_status")
    private AssessmentStatus asssessmentStatus;


    public AssessmentStatus getAsssessmentStatus() {
        return asssessmentStatus;
    }

    public void setAsssessmentStatus(AssessmentStatus asssessmentStatus) {
        this.asssessmentStatus = asssessmentStatus;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }
    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Date firstSubmissionDate() {
        return firstSubmissionDate;
    }
    public void setFirstName(Date firstSubmissionDate) {
        this.firstSubmissionDate = firstSubmissionDate;
    }
    public double getFullMark() {
        return fullMark;
    }
    public void setFullMark(double fullMark) {
        this.fullMark = fullMark;
    }
    public double getPassMark() {
        return passMark;
    }

    public void setPassMark(double passMark) {
        this.passMark = passMark;
    }

    public double getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(double studentMark) {
        this.studentMark = studentMark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getFirstSubmissionDate() {
        return firstSubmissionDate;
    }

    public void setFirstSubmissionDate(Date firstSubmissionDate) {
        this.firstSubmissionDate = firstSubmissionDate;
    }
}
   

