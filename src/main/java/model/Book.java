package model;

import javax.persistence.*;

@Entity
@Table(name = "BOOK")

public class Book extends Item {
    @Column(name = "TITLE")
    private String title;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name="NUMBER_OF_PAGES")
    private int numberOfPages;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    private Author author;




    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }


}
