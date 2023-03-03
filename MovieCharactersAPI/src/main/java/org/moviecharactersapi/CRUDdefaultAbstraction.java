package org.moviecharactersapi;

import org.moviecharactersapi.Models.Character;

import java.util.List;

public abstract class CRUDdefaultAbstraction implements CRUDRepository<Character, Integer, String> {

    // find by id or other extremely common value.
    // could maybe be instead of the second interface,

    @Override
    public List<Character> findAll() {
        return null;
    }

    @Override
    public List<Character> findByName(String name) {
        return null;
    }

    @Override
    public Character findById(Integer id) {
        return null;
    }

    @Override
    public int insert(Character object) {
        return 0;
    }

    @Override
    public int update(Character object) {
        return 0;
    }

    @Override
    public int delete(Character object) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}
