package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "COMPACT_DISC")
public class CompactDisc extends Item{

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Musician> getMusicians() {
        return musicians;
    }

    public void setMusicians(HashSet<Musician> musicians) {
        this.musicians = musicians;
    }

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Musician> musicians = new HashSet<>();




}
