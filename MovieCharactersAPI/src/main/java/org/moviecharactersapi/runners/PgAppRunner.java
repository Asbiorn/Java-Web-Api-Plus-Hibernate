package org.moviecharactersapi.runners;

import jakarta.transaction.Transactional;
import org.moviecharactersapi.services.FranchiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class PgAppRunner implements ApplicationRunner {

    @Autowired
    private final FranchiseService franchiseService;


    public PgAppRunner( FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {



    }

}