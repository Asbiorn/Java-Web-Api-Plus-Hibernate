package org.moviecharactersapi;

import java.util.List;

public interface CRUDRepository<T, U, S> {
    List<T> findAll();
    List<T> findByName(S name);
    T findById(U id);
    int insert(T object);
    int update(T object);
    int delete(T object);
    int deleteById(U id);
}