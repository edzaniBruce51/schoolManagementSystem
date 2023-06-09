/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.service;

import java.util.Date;
import java.util.List;
import sars.gov.za.management.common.AddressType;
import sars.gov.za.management.common.AssessmentStatus;
import sars.gov.za.management.common.EmployeeType;
import sars.gov.za.management.common.Gender;
import sars.gov.za.management.common.PersonType;
import sars.gov.za.management.common.SystemUserStatus;
import sars.gov.za.management.domain.Address;
import sars.gov.za.management.domain.Assessment;
import sars.gov.za.management.domain.ContactDetail;
import sars.gov.za.management.domain.Employee;
import sars.gov.za.management.domain.Grade;
import sars.gov.za.management.domain.School;
import sars.gov.za.management.domain.Student;
import sars.gov.za.management.domain.Subject;
import sars.gov.za.management.domain.User;

/**
 *
 * @author S2028873
 */
public class SchoolHelper {

    public static School getSchool(String schoolName, String RegistrationNumber) {

        School school = new School();
        school.setCreatedBy("test");
        school.setCreatedDate(new Date());
        school.setSchoolname(schoolName);
        school.setRegistratinNumber(RegistrationNumber);

        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setCreatedBy("Test");
        contactDetail.setCreatedDate(new Date());
        contactDetail.setCellphoneNumber("02837352893");
        contactDetail.setTelephoneNumber("0529875256");
        contactDetail.setEmail("info@kgomotso.ac.za");
        school.setContactDetail(contactDetail);

        Address postalAddress = new Address();
        postalAddress.setCreatedBy("Test");
        postalAddress.setCreatedDate(new Date());
        postalAddress.setAddressLine1("1021");
        postalAddress.setAddressLine2("Kgomotso High");
        postalAddress.setStreet("Pampierstad");
        postalAddress.setCode("0007");
        school.addAddress(postalAddress);

        Address resAddress = new Address();
        resAddress.setCreatedBy("Test");
        resAddress.setCreatedDate(new Date());
        resAddress.setAddressType(AddressType.RESIDENCIALADDRESS);
        resAddress.setAddressLine1("1120 Madiba street");
        resAddress.setAddressLine2("Kgomotso high");
        resAddress.setStreet("Madiba");
        resAddress.setCode("0556");
        school.addAddress(resAddress);

        return school;

    }

    public static Grade addGrade(String description, School school) {

        Grade grade = new Grade();
        grade.setCreatedBy("test");
        grade.setCreatedDate(new Date());
        grade.setDescription(description);
        grade.setSchool(school);
        return (grade);
    }

    public static Subject addSubject(String name, String code, School school) {
        Subject subject = new Subject();
        subject.setCreatedBy("Test");
        subject.setCreatedDate(new Date());
        subject.setName(name);
        subject.setCode(code);
        subject.setSchool(school);
        return subject;
    }

    public static Employee addEmployee(String employeeId, String saceReg, School school, List<Grade> grades, List<Subject> subjects) {
        Employee employee = new Employee();
        employee.setCreatedBy("Test");
        employee.setCreatedDate(new Date());
        employee.setPersonType(PersonType.EMPLOYEE);
        employee.setEmployeeType(EmployeeType.EDUCATOER);
        employee.setEmployeeId(employeeId);
        employee.setSaceReg(saceReg);
        employee.setSchool(school);
        employee.setFirstName("Amogelang");
        employee.setLastName("Phangisa");
        employee.setIdentityNumber("88888888888888");
        employee.setGender(Gender.MALE);
        employee.setGrades(grades);
        employee.setSubjects(subjects);

        Address address = new Address();
        address.setCreatedBy("Test");
        address.setCreatedDate(new Date());
        address.setAddressType(AddressType.POSTALADDRESS);
        address.setAddressLine1("PO BOX 102");
        address.setAddressLine2("TAUNG");
        address.setStreet("mokasa2");
        address.setCode("8580");
        employee.addAddress(address);

        Address resAddress = new Address();
        resAddress.setCreatedBy("Test");
        resAddress.setCreatedDate(new Date());
        resAddress.setAddressType(AddressType.RESIDENCIALADDRESS);
        resAddress.setAddressLine1("Voelvanger");
        resAddress.setAddressLine2("Kathu");
        resAddress.setCode("2555");
        resAddress.setStreet("siyathmba");
        school.addAddress(resAddress);

        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setCreatedBy("Test");
        contactDetail.setCreatedDate(new Date());
        contactDetail.setCellphoneNumber("02837352893");
        contactDetail.setTelephoneNumber("0529875256");
        contactDetail.setEmail("amogelang@gmail.com");
        employee.setContactDetails(contactDetail);

        return employee;
    }

    public static Student addStudent(String studentNumber, Grade grade, School school, List<Subject> subjectsList) {
        Student student = new Student();
        student.setCreatedBy("Test");
        student.setCreatedDate(new Date());
        student.setPersonType(PersonType.LEARNER);
        student.setStudentNumber(studentNumber);
        student.setSchool(school);
        student.setFirstName("Phatshimo");
        student.setLastName("Phangisa");
        student.setIdentityNumber("22222222222");
        student.setGender(Gender.MALE);
        student.setGrade(grade);
        student.setSubjects(subjectsList);

        Address address = new Address();
        address.setCreatedBy("Test");
        address.setCreatedDate(new Date());
        address.setAddressType(AddressType.POSTALADDRESS);
        address.setAddressLine1("PO BOX 102");
        address.setAddressLine2("TAUNG");
        address.setStreet("mokasa2");
        address.setCode("8580");
        student.addAddress(address);

        Address resAddress = new Address();
        resAddress.setCreatedBy("Test");
        resAddress.setCreatedDate(new Date());
        resAddress.setAddressType(AddressType.RESIDENCIALADDRESS);
        resAddress.setAddressLine1("Voelvanger");
        resAddress.setAddressLine2("Kathu");
        resAddress.setCode("2555");
        resAddress.setStreet("siyathmba");
        student.addAddress(resAddress);

        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setCreatedBy("Test");
        contactDetail.setCreatedDate(new Date());
        contactDetail.setCellphoneNumber("02837352893");
        contactDetail.setTelephoneNumber("0529875256");
        contactDetail.setEmail("phatshimo@gmail.com");
        student.setContactDetails(contactDetail);
        return student;
    }
    public static Assessment addAssessment(String name, String discription, Date dueDate, Date firstSubmissionDate, double fullMark, double passMark, double studentMark, Subject subject,AssessmentStatus asssessmentStatus) {
        Assessment assessment = new Assessment();
        assessment.setCreatedBy("test");
        assessment.setCreatedDate(dueDate);
        assessment.setName(name);
        assessment.setDiscription(discription);
        assessment.setDueDate(dueDate);
        assessment.setFirstSubmissionDate(firstSubmissionDate);
        assessment.setFullMark(fullMark);
        assessment.setPassMark(passMark);
        assessment.setStudentMark(studentMark);
        assessment.setSubject(subject);
        assessment.setAsssessmentStatus(asssessmentStatus);

        return assessment;

    }
     public static User addUser(String UserName,String password,String confirmPassword,String changePassword,SystemUserStatus systemUserStatus,School school) {
       
        User user = new User();
        user.setCreatedBy("Test");
        user.setCreatedDate(new Date());
        user.setPersonType(PersonType.ADMINISTRATOR);
        user.setUserName(UserName);
        user.setPassword(password);
        user.setChangePassword(changePassword);
        user.setConfirmPassword(confirmPassword);
        user.setSystemUserStatus(systemUserStatus);
        user.setSchool(school);
        user.setFirstName("Amo");
        user.setLastName("Park");
        user.setIdentityNumber("777777");
        user.setIdentifer(user.getIdentityNumber());
        user.setGender(Gender.MALE);
          
        Address address = new Address();
        address.setCreatedBy("Test");
        address.setCreatedDate(new Date());
        address.setAddressType(AddressType.POSTALADDRESS);
        address.setAddressLine1("PO BOX 102");
        address.setAddressLine2("Zone 2");
        address.setStreet("Zone 2");
        address.setCode("8580");
        user.addAddress(address);

        Address resAddress = new Address();
        resAddress.setCreatedBy("Test");
        resAddress.setCreatedDate(new Date());
        resAddress.setAddressType(AddressType.RESIDENCIALADDRESS);
        resAddress.setAddressLine1("K town");
        resAddress.setAddressLine2("K town downside");
        resAddress.setCode("2555");
        resAddress.setStreet("Siya");
        user.addAddress(resAddress);

        ContactDetail contactDetail = new ContactDetail();
        contactDetail.setCreatedBy("Test");
        contactDetail.setCreatedDate(new Date());
        contactDetail.setCellphoneNumber("000000");
        contactDetail.setTelephoneNumber("00000");
        contactDetail.setEmail("amogee@gmail.com");
        user.setContactDetails(contactDetail);

        return user;
    }
}
