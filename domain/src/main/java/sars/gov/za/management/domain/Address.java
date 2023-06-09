/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sars.gov.za.management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import org.hibernate.envers.Audited;
import sars.gov.za.management.common.AddressType;



/**
 *
 * @author S2028873
 */
@Audited
@Table(name = "address")
@Entity
public class Address extends BaseEntity{

    @Column(name = "address_Line_1")
    private String addressLine1;

    @Column(name = "Address_Line_2")
    private String addressLine2;

    @Column(name = "Street")
    private String street;

    @Column(name = "Area")
    private String area;

    @Column(name = "Code")
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "Address_Type")
    private AddressType addressType;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
