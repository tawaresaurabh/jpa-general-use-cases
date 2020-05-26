import model.Author;
import model.Book;
import model.CompactDisc;
import model.Musician;
import service.ItemService;
import service.PersonService;

public class Main {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        ItemService itemService = new ItemService();

        Book b = itemService.createBook(itemService.getDummyBook1());
        b.setAuthor(personService.getDummyAuthor());
        itemService.removeBook(b);
        System.out.println("Book removed  | "+ b.getTitle() +" Author not removed :- " + b.getAuthor().getFirstName());


        //@OneToMany cascade all for Author->Book
        Author author1 = personService.getDummyAuthor();
        author1.setBooks(itemService.getBooksSet());
        Author author2 = personService.createAuthor(author1);
        Author author3 = personService.removeAuthor(author2);
        System.out.println("Author removed  | "+ author3.getFirstName() +" , " + author3.getLastName()+ " Books are also removed :-");
        author3.getBooks().forEach(book -> System.out.println(book.getTitle()));

        // InheritanceType.JOINED for CD->Item
        CompactDisc cd = itemService.createCD(itemService.getCompactDisc1());
        itemService.removeDisk(cd);
        System.out.println("CD removed  | "+ cd.getDescription());

        // @Many to Many for CD<->Musician & InheritanceType.JOINED for CD->Item
        CompactDisc cd1 = itemService.getCompactDisc1();
        cd1.setMusicians(personService.getMusicians());
        CompactDisc cd2 = itemService.createCD(cd1);
        itemService.removeDisk(cd2);
        System.out.println("CD removed | " + cd2.getDescription()+" CD Artists not removed :- ");
        cd2.getMusicians().forEach(musician -> System.out.println(musician.getFirstName()));



        //@One to One for Person->ContactInfo & InheritanceType.JOINED for Person->Musician
        Musician musician = personService.createMusician(personService.getDummyMusician());
        personService.removeMusician(musician);
        System.out.println("Musician removed | " + musician.getFirstName()+","+musician.getLastName());


        //Many to many relation Musician <-> CDs
        Musician musician1 = personService.getDummyMusician();
        musician1.setCompactDiscs(itemService.getCDSet());
        Musician musician2 = personService.createMusician(musician1);
        Musician musician3 = personService.removeMusician(musician2);
        System.out.println("Musician with CD set removed | " + musician3.getFirstName()+","+musician3.getLastName() +" CDs not removed : -");
        musician3.getCompactDiscs().forEach(compactDisc -> System.out.println(compactDisc.getDescription()));



    }
}

