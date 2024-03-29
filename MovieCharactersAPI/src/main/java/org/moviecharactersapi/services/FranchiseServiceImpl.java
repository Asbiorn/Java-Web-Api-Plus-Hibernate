package org.moviecharactersapi.services;


import org.moviecharactersapi.models.Franchise;
import org.moviecharactersapi.repositories.FranchiseRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }

    @Override
    public Franchise findById(Integer id) {
        return franchiseRepository.findById(id).get();
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        Franchise franchise = findById(id);
        if(franchise.getMovies()!= null) // if the franchise has movies linked to it
            franchise.getMovies().forEach(movie -> movie.setFranchise(null)); // franchise.getMovies().setFranchise(null); remove relations, from the side which owns it.
    franchiseRepository.deleteById(id);
    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }

}
