package service;

import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.HashSet;

public class ItemService {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU1");
    private final EntityManager em = entityManagerFactory.createEntityManager();
    private final EntityTransaction tx =  em.getTransaction();



    public HashSet<Book> getBooksSet(){
        HashSet<Book> books = new HashSet<>();
        Book book1 = getDummyBook1();
        Book book2 = getDummyBook2();
        Book book3 = getDummyBook3();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;


    }

    public Book getDummyBook3() {
        Book book3 = new Book();
        book3.setCategory(Category.PRACTICAL);
        book3.setTitle("50 habits to change your future");
        book3.setNumberOfPages(100);
        book3.setDescription("Book about habits");
        book3.setUnitCost(new BigDecimal(130));
        return book3;
    }

    public Book getDummyBook2() {
        Book book2 = new Book();
        book2.setCategory(Category.PHILOSOPHICAL);
        book2.setTitle("Values of sea");
        book2.setNumberOfPages(500);
        book2.setDescription("Book about deep thoughts");
        book2.setUnitCost(new BigDecimal(10.50));
        return book2;
    }

    public Book getDummyBook1() {
        Book book1 = new Book();
        book1.setCategory(Category.MYSTERY);
        book1.setTitle("Mystery beyond");
        book1.setNumberOfPages(100);
        book1.setDescription("Book about universe");
        book1.setUnitCost(new BigDecimal(100));
        return book1;
    }

    public HashSet<CompactDisc> getCDSet(){
        HashSet<CompactDisc> compactDiscs = new HashSet<>();
        CompactDisc compactDisc1 = getCompactDisc1();
        CompactDisc compactDisc2 = getCompactDisc2();
        CompactDisc compactDisc3 = getCompactDisc3();
        compactDiscs.add(compactDisc1);
        compactDiscs.add(compactDisc2);
        compactDiscs.add(compactDisc3);

        return compactDiscs;

    }

    public CompactDisc getCompactDisc3() {
        CompactDisc compactDisc3 = new CompactDisc();
        compactDisc3.setDescription("Best band");
        compactDisc3.setUnitCost(new BigDecimal(50));
        compactDisc3.setGenre(Genre.ROCK);
        return compactDisc3;
    }

    public CompactDisc getCompactDisc2() {
        CompactDisc compactDisc2 = new CompactDisc();
        compactDisc2.setDescription("Good band");
        compactDisc2.setUnitCost(new BigDecimal(50.5));
        compactDisc2.setGenre(Genre.PUNK);
        return compactDisc2;
    }

    public CompactDisc getCompactDisc1() {
        CompactDisc compactDisc1 = new CompactDisc();
        compactDisc1.setDescription("Rubber band");
        compactDisc1.setUnitCost(new BigDecimal(50));
        compactDisc1.setGenre(Genre.COUNTRY);
        return compactDisc1;
    }


    public CompactDisc createCD(CompactDisc compactDisc){
        tx.begin();
        em.persist(compactDisc);
        tx.commit();
        return compactDisc;
    }

    public CompactDisc findCD(Long id){
        return em.find(CompactDisc.class,id);
    }

    public CompactDisc removeDisk(CompactDisc compactDisc){
        CompactDisc cd = em.merge(compactDisc);
        if(cd!=null){
            tx.begin();
            em.remove(cd);
            tx.commit();
        }
        return cd;
    }



    public Book createBook(Book book){
        tx.begin();
        em.persist(book);
        tx.commit();
        return book;
    }

    public Book findBook(Long id){
        return em.find(Book.class,id);
    }

    public Book removeBook(Book book){
        Book b = em.merge(book);
        if(b!=null){
            tx.begin();
            em.remove(b);
            tx.commit();
        }
        return b;
    }


    public Item removeItem(Item item){
        Item item1 = em.merge(item);
        if(item1!=null){
            tx.begin();
            em.remove(item1);
            tx.commit();
        }
        return item;
    }


}


