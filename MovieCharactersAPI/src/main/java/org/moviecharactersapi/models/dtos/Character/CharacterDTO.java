package org.moviecharactersapi.models.dtos.Character;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.moviecharactersapi.enums.Gender;
import org.moviecharactersapi.models.Movie;

import java.util.Set;


@Getter
@Setter
@Data
public class CharacterDTO {
    private int id;
    private String full_name;
    private String alias;
    private Gender gender;
    private String picture_url;
    private Set<Integer> movies;
}
