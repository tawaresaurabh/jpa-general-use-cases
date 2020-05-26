package entitylisteners;



import model.Person;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import java.time.LocalDate;
import java.time.Period;

public class CalculateAgeListener {

    @PostLoad
    @PostUpdate
    @PostPersist
    public void calculateAge(Person person){
        if(person.getDateOfBirth() != null){
            person.setAge(Period.between(person.getDateOfBirth(), LocalDate.now()).getYears());
        }
    }
}
