package service;

import model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;


public class PersonService {
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU1");
    private EntityManager em = entityManagerFactory.createEntityManager();
    private EntityTransaction tx =  em.getTransaction();






    public Author getDummyAuthor(){
        Author author = new Author();
        author.setAuthorRegistrationId("A1-R1");
        author.setContactInfo(getDummyContactInfo1());
        author.setDateOfBirth(LocalDate.parse("2007-12-03"));
        author.setFirstName("Dummy");
        author.setLastName("Author");
        author.setPrefix(Prefix.Mr);

        author.setUserName("auth_100");
        return author;
    }

    public ContactInfo getDummyContactInfo1(){
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddressLine1("Naperville");
        contactInfo.setAddressLine2("Chicago");
        contactInfo.setCountry(Country.US);
        contactInfo.setPhoneNumber(1234567);
        contactInfo.setPostalCode(1234);
        return contactInfo;
    }

    public ContactInfo getDummyContactInfo2(){
        ContactInfo contactInfo = new ContactInfo();
        contactInfo.setAddressLine1("Pune");
        contactInfo.setAddressLine2("MH");
        contactInfo.setCountry(Country.INDIA);
        contactInfo.setPhoneNumber(1234567);
        contactInfo.setPostalCode(1234);
        return contactInfo;
    }

    public HashSet<Musician> getMusicians(){
        HashSet<Musician> musicians = new HashSet<>();
        musicians.add(getDummyMusician());
        musicians.add(getDummyMusician2());
        musicians.add(getDummyMusician3());
        return musicians;

    }



    public Musician getDummyMusician(){
        Musician musician = new Musician();
        musician.setContactInfo(getDummyContactInfo2());
        musician.setDateOfBirth(LocalDate.parse("1990-01-10"));
        musician.setFirstName("Dummy");
        musician.setLastName("Musician");
        musician.setPrefix(Prefix.Ms);
        musician.setUserName("music_1");
        musician.setMusicianRegistrationId("M1-R1");
        return musician;
    }


    public Musician getDummyMusician2(){
        Musician musician = new Musician();
        musician.setContactInfo(getDummyContactInfo2());
        musician.setDateOfBirth(LocalDate.parse("2000-01-10"));
        musician.setFirstName("Dummy2");
        musician.setLastName("Musician2");
        musician.setPrefix(Prefix.Mr);
        musician.setUserName("music_2");
        musician.setMusicianRegistrationId("M2-R2");
        return musician;
    }

    public Musician getDummyMusician3(){
        Musician musician = new Musician();
        musician.setContactInfo(getDummyContactInfo2());
        musician.setDateOfBirth(LocalDate.parse("2005-01-10"));
        musician.setFirstName("Dummy3");
        musician.setLastName("Musician3");
        musician.setPrefix(Prefix.Mr);
        musician.setUserName("music_3");
        musician.setMusicianRegistrationId("M3-R3");
        return musician;
    }

    public Author createAuthor(Author author){
        Author author1 = em.merge(author);
        tx.begin();
        em.persist(author1);
        tx.commit();
        return author1;
    }


    public Musician createMusician(Musician musician){
        Musician  musician1 = em.merge(musician);
        tx.begin();
        em.persist(musician1);
        tx.commit();
        return musician1;
    }

    public Author findAuthor(Long id){
        return em.find(Author.class,id);
    }

    public Musician findMusician(Long id){
        return em.find(Musician.class,id);
    }



    public Author removeAuthor(Author author){
        Author authorToBeRemoved = em.merge(author);
        tx.begin();
        em.remove(authorToBeRemoved);
        tx.commit();
        return authorToBeRemoved;
    }


    public Musician removeMusician(Musician musician){
        Musician musicianToBeRemoved = em.merge(musician);
        tx.begin();
        em.remove(musicianToBeRemoved);
        tx.commit();
        return musicianToBeRemoved;
    }




}
