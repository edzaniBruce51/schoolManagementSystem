/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sars.gov.za.management.common;

/**
 *
 * @author S2028873
 */
public enum AddressType {

    POSTALADDRESS("Postal Address"),
    RESIDENCIALADDRESS("Residencial Address");

    private final String displayName;

    AddressType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}
