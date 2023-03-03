package org.moviecharactersapi.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = true)
    private String genre;

    @Column(length = 4, nullable = false)
    private int  relase_year;

    @Column(length = 100, nullable = false)
    private String  director;

    @Column(length = 255, nullable = false)
    private String picture_url;

    @Column(length = 100, nullable = true)
    private String trailer_url;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @ManyToMany(mappedBy = "movies")
    private Set<Character> characters;

}
