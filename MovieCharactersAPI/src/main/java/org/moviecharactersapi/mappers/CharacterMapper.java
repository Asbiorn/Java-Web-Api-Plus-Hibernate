package org.moviecharactersapi.mappers;

import org.moviecharactersapi.models.Character;
import org.moviecharactersapi.models.Movie;
import org.moviecharactersapi.models.dtos.Character.CharacterDTO;
import org.moviecharactersapi.services.CharacterService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.moviecharactersapi.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper( componentModel = "spring")
public abstract class CharacterMapper {


    @Autowired
    protected CharacterService characterService ;
    @Autowired
    protected MovieService movieService ;


    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract CharacterDTO characterToCharacterDTO(Character character);
    @Named("moviesToIds")
    Set<Integer> mapMoviesToIds(Set<Movie> movies) {
        if(movies == null)
            return null;
        return movies.stream()
                .map(Movie::getId).collect(Collectors.toSet());
    }

    public abstract Collection<CharacterDTO> charactersToCharacterDTOs(Collection<Character> characters);


    // CharacterDTO to Character
    // most is auto mapped due to equal names in dto and entity
    @Mapping(target ="movies", source = "movies", qualifiedByName = "movieIdsToMovies")
    public abstract Character characterDTOToCharacter(CharacterDTO characterDTO);


    @Named("movieIdsToMovies") // returns set of movie objects to the character in the Domain
    Set<Movie> mapIdsToSubjects(Set<Integer> movieId) {
        return movieId.stream()
                .map( i -> movieService.findById(i))
                .collect(Collectors.toSet());
    }
}
