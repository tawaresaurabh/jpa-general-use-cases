package model;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_INFO")
public class ContactInfo {


    @Id
    @GeneratedValue
    private Long id;
    @Column(length = 100)
    private String addressLine1;
    @Column(length = 100)
    private String addressLine2;
    @Column(length = 10)
    private int phoneNumber;
    @Column(length = 10)
    private int postalCode;

    @Enumerated(EnumType.STRING)
    private Country country;


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }



}
