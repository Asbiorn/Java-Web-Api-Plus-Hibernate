package org.moviecharactersapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class PgAppRunner implements ApplicationRunner {

    @Autowired
    private final CustomerRepositoryImpl customerRepoImpl;


    public PgAppRunner(CustomerRepositoryImpl customerRepoImpl) {
        this.customerRepoImpl = customerRepoImpl;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        customerRepoImpl.test();
        System.out.println("test complete");

        //customerRepoImpl.printNice(customerRepoImpl.findAll());
        //customerRepoImpl.printNice(customerRepoImpl.findById(2));
        //customerRepoImpl.printNice(customerRepoImpl.findByName("0")); // returns all if empty




    }

}