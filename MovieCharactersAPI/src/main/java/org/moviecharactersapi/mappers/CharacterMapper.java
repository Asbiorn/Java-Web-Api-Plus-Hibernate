package org.moviecharactersapi.mappers;

/*import noroff.mefit.dtos.SetCountDto;
import noroff.mefit.models.Exercise;
import noroff.mefit.models.SetCount;*/
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
    protected MovieService movieService ;

    // purpose of the mapper is to map or "convert" Character objects to CharacterDTOs

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


/*    // CharacterDTO to Character
    @Mapping(target ="exercise", source = "exercise", qualifiedByName = "characterDTO-IdsToCharacter")
    public abstract Character setCountDtoToSetCount(CharacterDTO characterDTO);

    @Named("characterDTO-IdsToCharacter")
    Character mapExerciseDtoIdsToExercise(int id) {
        return characterService.findById(id);
    }*/
/*
    //@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target ="exercise", source = "exercise", qualifiedByName = "exerciseDtoIdsToExercise")
    public abstract SetCount updateSetCountFromSetCountDto(SetCountDto setCountDto, @MappingTarget SetCount setCount);
*/

}
