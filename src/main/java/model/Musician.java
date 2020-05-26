package model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "MUSICIAN")
public class Musician extends Person{


    public String getMusicianRegistrationId() {
        return musicianRegistrationId;
    }

    public void setMusicianRegistrationId(String musicianRegistrationId) {
        this.musicianRegistrationId = musicianRegistrationId;
    }

    @Column(name = "MUSICIAN_REGISTRATION_ID")
    private String musicianRegistrationId;





    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE }, fetch = FetchType.EAGER)
    private Set<CompactDisc> compactDiscs = new HashSet<>();


    public Set<CompactDisc> getCompactDiscs() {
        return compactDiscs;
    }

    public void setCompactDiscs(HashSet<CompactDisc> compactDiscs) {
        this.compactDiscs = compactDiscs;
    }





}
