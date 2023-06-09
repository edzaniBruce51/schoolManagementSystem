/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import sars.gov.za.management.common.AssessmentStatus;
import sars.gov.za.management.common.SystemUserStatus;
import sars.gov.za.management.common.TestDataSourceConfiguration;
import sars.gov.za.management.domain.Assessment;
import sars.gov.za.management.domain.Employee;
import sars.gov.za.management.domain.Grade;
import sars.gov.za.management.domain.School;
import sars.gov.za.management.domain.Student;
import sars.gov.za.management.domain.Subject;
import sars.gov.za.management.domain.User;

;

/**
 *
 * @author S2028873
 */
@EnableJpaAuditing
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestDataSourceConfiguration.class)
public class ServiceLayerTest {

    @Autowired
    private SchoolServiceLocal schoolService;

    @Autowired
    private GradeServiceLocal gradeService;

    @Autowired
    private SubjectServiceLocal subjectService;

    @Autowired
    private EmployeeServiceLocal employeeService;

    @Autowired
    private StudentServiceLocal studentService;

    @Autowired
    private AssessmentServiceLocal assessmentService;

    @Autowired
    private UserServiceLocal userService;

    public ServiceLayerTest() {

    }

    @BeforeClass
    public static void getUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void TestA() {
        School school = SchoolHelper.getSchool("Kgomotso High", "Kg125");
        schoolService.save(school);
    }

    @Test
    public void TestB() {
        School school = schoolService.findBySchoolname("Kgomotso High");
        Grade grade1 = SchoolHelper.addGrade("grade 1", school);
        gradeService.save(grade1);
        Grade grade2 = SchoolHelper.addGrade("grade 2", school);
        gradeService.save(grade2);
        Grade grade3 = SchoolHelper.addGrade("grade 3", school);
        gradeService.save(grade3);
        Grade grade4 = SchoolHelper.addGrade("grade 4", school);
        gradeService.save(grade4);
        Grade grade5 = SchoolHelper.addGrade("grade 5", school);
        gradeService.save(grade5);
    }

    @Test
    public void TestC() {
        School school = schoolService.findBySchoolname("Kgomotso High");
        Subject subject1 = SchoolHelper.addSubject("MATHEMATIC", "MAT77", school);
        subjectService.save(subject1);
        Subject subject2 = SchoolHelper.addSubject("AGRICULTURE", "AGRIC77", school);
        subjectService.save(subject2);
        Subject subject3 = SchoolHelper.addSubject("PHYSCIAL SCIENCES", "PHYS77", school);
        subjectService.save(subject3);
        Subject subject4 = SchoolHelper.addSubject("GEOGRAPHY", "GEO77", school);
        subjectService.save(subject4);
    }

    @Test
    public void TestD() {
        School school = schoolService.findBySchoolname("Kgomotso High");
        Employee employee = SchoolHelper.addEmployee("0222", "c12", school, gradeService.listAll(), subjectService.listAll());
        employeeService.save(employee);
    }

    @Test
    public void TestE() {
        School school = schoolService.findBySchoolname("Kgomotso High");
        Student student = SchoolHelper.addStudent("254455", gradeService.listAll().get(gradeService.listAll().size() - 2), school, subjectService.listAll());
        studentService.save(student);
    }

    @Test
    public void TestF() {
        Assessment assessment = SchoolHelper.addAssessment("AGRICULTURE", "soil test", new Date(), new Date(), 100D, 75D, 95D, subjectService.listAll().get(subjectService.listAll().size() - 1), AssessmentStatus.PASSED);
        assessmentService.save(assessment);
    }

    @Test
    public void TestG() {
        School school = schoolService.findBySchoolname("Kgomotso High");
        User user = SchoolHelper.addUser("amogelang", "password1", "password1", "", SystemUserStatus.ACTIVE, school);
        userService.save(user);
    }
}
