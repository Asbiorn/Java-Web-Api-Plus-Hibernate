package org.moviecharactersapi.Models;

import jakarta.persistence.*;
import org.moviecharactersapi.CRUDdefaultAbstraction;
import org.moviecharactersapi.enums.Gender;



import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_character")
public class Character extends CRUDdefaultAbstraction {

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return full_name;
    }
    public void setName(String name) {
        this.full_name = full_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;
    @Column(length = 100, nullable = false)
    private String full_name;

    @Column(length = 100, nullable = true)
    private String alias;
    @Enumerated(EnumType.STRING)
    @Column(length = 50, nullable = false)
    private Gender gender;
    @Column(length = 255, nullable = true)
    private String picture_url;

    // Relations
    @ManyToMany
    @JoinTable(
            name = "character_movie",
            joinColumns = {@JoinColumn(name = "character_id")},
            inverseJoinColumns = {@JoinColumn(name = "tb_movie_id")}
    )
    private Set<Movie> movies;



}
