package org.moviecharactersapi.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_franchise")
public class Franchise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="franchise_name",length = 100, nullable = false)
    private String name;
    @Column(length = 255, nullable = false)
    private String description;

    // Relations
   // @OneToMany(mappedBy = "professor")
   // private Set<Character> characters;
    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;
}