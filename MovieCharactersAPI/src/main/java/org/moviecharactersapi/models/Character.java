package org.moviecharactersapi.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.moviecharactersapi.enums.Gender;

import java.util.Set;


@Entity
@Getter
@Setter
@Table(name = "tb_character")
public class Character {

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
            inverseJoinColumns = {@JoinColumn(name = "movie_id")}
    )
    private Set<Movie> movies;



}
