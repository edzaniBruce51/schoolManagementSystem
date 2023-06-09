/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sars.gov.za.management.common;

/**
 *
 * @author S2028873
 */
public enum AssessmentStatus {

    // Enum constants with associated display names
    PASSED("passed"),
    FAILED("failed"),
    CONDONED("condoned");

    //a variable declaration. It declares a private, final (constant and can not be mofified) string variable named displayName.
    private final String displayName;
    
    // constructor sets the value of the displayName instance variable of an AssessmentStatus object based on the value passed as an argument when the object is create
    private AssessmentStatus(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }

}
// Enum that represents different assessment statuses

// Enum constants:
// - PASSED: Represents the assessment status "passed"
// - FAILED: Represents the assessment status "failed"
// - CONDONED: Represents the assessment status "condoned"

// Private, final variable:
// - displayName: Stores the display name associated with each assessment status

// Constructor:
// - AssessmentStatus(String displayName): Constructs an AssessmentStatus object with the provided display name.
//   Sets the value of the displayName instance variable for each constant.

// toString() method:
// - Overrides the default toString() method to return the display name when the enum constant is converted to a string.
