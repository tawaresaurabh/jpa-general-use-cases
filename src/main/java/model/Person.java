package model;

import entitylisteners.CalculateAgeListener;
import entitylisteners.UserNameListener;
import org.eclipse.persistence.annotations.CascadeOnDelete;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@CascadeOnDelete
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.JOINED)
@EntityListeners({UserNameListener.class, CalculateAgeListener.class})
@NamedQuery(name = "person.userName.validate",query = "select p from Person p where p.userName = :userName")
public abstract  class Person {

    @Id
    @GeneratedValue
    private Long Id;

    @Transient
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Prefix prefix;

    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;


    @Column(name = "USER_NAME")
    private String userName;


    @OneToOne(cascade = CascadeType.ALL)
    private ContactInfo contactInfo;

    @Column(name="DATE_OF_BIRTH")
    private LocalDate dateOfBirth;




    public Prefix getPrefix() {
        return prefix;
    }

    public void setPrefix(Prefix prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public void setAge(Integer age) {
            this.age = age;
    }


    public Integer getAge() {
        return age;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }





    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }



}
