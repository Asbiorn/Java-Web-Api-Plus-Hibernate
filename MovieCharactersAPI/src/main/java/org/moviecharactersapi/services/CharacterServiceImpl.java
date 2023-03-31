package org.moviecharactersapi.services;


import org.moviecharactersapi.repositories.CharacterRepository;
import org.springframework.stereotype.Service;
import org.moviecharactersapi.models.Character;

import java.util.Collection;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public Character findById(Integer id) {
        return characterRepository.findById(id).get();
    }

    @Override
    public Collection<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character add(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public Character update(Character entity) {
        return characterRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        if (!exists(id)){
            return;
        }
       Character character = findById(id);
        if(character.getMovies()!= null){
            // if the character has movies linked to it
            //maybe possible to just delete rightaway, when character owns the relation
            //character.getMovies().forEach(movie -> movie.setCharacter(null)); // character.getMovies().setCharacter(null); remove relations, from the side which owns it.
            System.out.println("has movies");
        }
    characterRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer integer) {
        return characterRepository.existsById(integer);
    }

}
