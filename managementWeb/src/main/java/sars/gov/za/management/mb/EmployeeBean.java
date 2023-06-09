/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import sars.gov.za.management.common.AddressType;
import sars.gov.za.management.common.EmployeeType;
import sars.gov.za.management.common.Gender;
import sars.gov.za.management.common.PersonType;
import sars.gov.za.management.domain.Address;
import sars.gov.za.management.domain.ContactDetail;
import sars.gov.za.management.domain.Employee;
import sars.gov.za.management.domain.Grade;
import sars.gov.za.management.domain.School;
import sars.gov.za.management.domain.Subject;
import sars.gov.za.management.service.EmployeeServiceLocal;
import sars.gov.za.management.service.GradeServiceLocal;
import sars.gov.za.management.service.SchoolServiceLocal;
import sars.gov.za.management.service.SubjectServiceLocal;
/**
 *
 * @author mutem
 */
@ManagedBean
@ViewScoped
public class EmployeeBean extends BaseBean<Employee> {

    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private GradeServiceLocal gradeService;
    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<Grade> grades = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    private List<EmployeeType> employeeTpes = new ArrayList<>();
    private List<AddressType> addressTypes = new ArrayList<>();
    private List<Gender> genders = new ArrayList<>();
    private List<PersonType> personTypes = new ArrayList<>();

    private School school;
    private boolean employeeVisible;

    @PostConstruct
    public void init() {
        reset().setList(true);
        setPanelTitleName("Employee");
        addCollections(employeeService.listAll());
        grades = gradeService.listAll();
        subjects = subjectService.listAll();
        addressTypes.addAll(Arrays.asList(AddressType.values()));
        employeeTpes.addAll(Arrays.asList(EmployeeType.values()));
        genders.addAll(Arrays.asList(Gender.values()));
        personTypes.addAll(Arrays.asList(PersonType.values()));
        school = schoolService.findBySchoolname("Kgomotso High School");
        employeeVisible = Boolean.FALSE;
    }

    public void addOrUpdate(Employee employee) {
        reset().setAdd(true);
        if (employee != null) {
            setPanelTitleName("Update Employee");
            if (getEntity().getEmployeeType().equals(EmployeeType.EDUCATOER) || getEntity().getEmployeeType().equals(EmployeeType.HOD) || getEntity().getEmployeeType().equals(EmployeeType.PRINCIPAL)) {
                employeeVisible = Boolean.TRUE;
            } else {
                employeeVisible = Boolean.FALSE;
            }
            employee.setUpdateDate(new Date());
            employee.setUpdatedBy(getActiveUser().getIdentifier());
        } else {
            setPanelTitleName("Add new Employee");
            employee = new Employee();
            employee.setCreatedBy(getActiveUser().getIdentifier());
            employee.setCreatedDate(new Date());
            employee.setPersonType(PersonType.EMPLOYEE);
            employee.setSchool(school);

            Address postalAddress = new Address();
            postalAddress.setAddressType(AddressType.POSTALADDRESS);
            postalAddress.setCreatedBy(getActiveUser().getIdentifier());
            postalAddress.setCreatedDate(new Date());
            employee.addAddress(postalAddress);

            Address resAddress = new Address();
            resAddress.setAddressType(AddressType.RESIDENCIALADDRESS);
            resAddress.setCreatedBy(getActiveUser().getIdentifier());
            resAddress.setCreatedDate(new Date());
            employee.addAddress(resAddress);

            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            employee.setContactDetails(contactDetail);

            addCollection(employee);
        }
        addEntity(employee);
    }

    public void save(Employee employee) {
        if (employee.getId() != null) {
            employeeService.update(employee);
            addInformationMessage("Employee was successfully updated");
        } else {
            employeeService.save(employee);
            addInformationMessage("Employee was successfully created");
        }
        reset().setList(true);
        setPanelTitleName("Employees");
    }

    public void cancel(Employee employee) {
        if (employee.getId() == null && getEmployees().contains(employee)) {
            remove(employee);
        }
        reset().setList(true);
        setPanelTitleName("Employees");
    }

    public void delete(Employee employee) {
        employeeService.deleteById(employee.getId());
        addInformationMessage("Employee was successully deleted");
        reset().setList(true);
    }

    public void sychronizeEmployee(Employee employee) {
        if (getCollections().contains(employee)) {
            getCollections().remove(employee);
        }
    }

    public void employeeTypeListener() {
        if (getEntity().getEmployeeType().equals(EmployeeType.EDUCATOER) || getEntity().getEmployeeType().equals(EmployeeType.HOD) || getEntity().getEmployeeType().equals(EmployeeType.PRINCIPAL)) {
            employeeVisible = Boolean.TRUE;
        } else {
            employeeVisible = Boolean.FALSE;
        }

    }

    public List<Employee> getEmployees() {
        return this.getCollections();
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<EmployeeType> getEmployeeTpes() {
        return employeeTpes;
    }

    public void setEmployeeTpes(List<EmployeeType> employeeTpes) {
        this.employeeTpes = employeeTpes;
    }

    public List<AddressType> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(List<AddressType> addressTypes) {
        this.addressTypes = addressTypes;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public List<PersonType> getPersonTypes() {
        return personTypes;
    }

    public void setPersonTypes(List<PersonType> personTypes) {
        this.personTypes = personTypes;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public boolean isEmployeeVisible() {
        return employeeVisible;
    }

    public void setEmployeeVisible(boolean employeeVisible) {
        this.employeeVisible = employeeVisible;
    }
}

