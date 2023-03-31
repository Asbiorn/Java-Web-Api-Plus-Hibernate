package org.moviecharactersapi.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
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

    @OneToMany(mappedBy = "franchise")
    private Set<Movie> movies;

}