package entitylisteners;



import model.Person;

import javax.persistence.*;
import java.util.List;

public class UserNameListener {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("PU1");
    private EntityManager em = entityManagerFactory.createEntityManager();


    @PrePersist
    @PreUpdate
    public void validate(Person person){
        if(person.getUserName() != null){
            TypedQuery<Person> personTypedQuery = em.createNamedQuery("person.userName.validate",Person.class);
            personTypedQuery.setParameter("userName",person.getUserName());
            List<Person> personList = personTypedQuery.getResultList();
            if(personList != null && personList.size() > 0){
                throw new IllegalArgumentException("Username exists");
            }
        }

    }

}
