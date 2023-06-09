/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sars.gov.za.management.common;

/**
 *
 * @author S2028873
 */
public enum PersonType {
    ADMINISTRATOR("Administrator"),
    LEARNER("Learner"),
    EMPLOYEE("Employee");

    private final String displayName;

    PersonType(String dislayName) {
        this.displayName = dislayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
