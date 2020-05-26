package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
public class Author extends Person{



    @Column(name = "AUTHOR_REGISTRATION_ID")
    private String authorRegistrationId;



    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<>();




    public String getAuthorRegistrationId() {
        return authorRegistrationId;
    }

    public void setAuthorRegistrationId(String authorRegistrationId) {
        this.authorRegistrationId = authorRegistrationId;
    }


    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(HashSet<Book> books) {
        this.books = books;
    }
}
