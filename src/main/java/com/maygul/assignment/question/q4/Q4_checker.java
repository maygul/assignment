package com.maygul.assignment.question.q4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component

public class Q4_checker implements CommandLineRunner {

    @Autowired
    private HibernateRepository hibernateRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        //before calling this, make sure that data.sql values are inserted into the database.

        List<Module> modulesIncludedInCompleteRoutes = hibernateRepository.getModulesIncludedInCompleteRoutes(1l);

        System.out.println("Modules included in complete routes: " + modulesIncludedInCompleteRoutes);

    }

}
