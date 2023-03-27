package com.maygul.assignment.question.q4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component

public class Q4_Initializer implements CommandLineRunner {

    @Autowired
    private HibernateRepository hibernateRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        /*
        INSERT INTO AGENT (ID, NAME, TYPE, GLOBAL_CONFIG) VALUES (1, 'Agent1', 'AGENT', null);

        INSERT INTO ROUTE (ID, NAME, PRIORITY, AGENT_ID) VALUES (1, 'Route1', 1, 1);
        INSERT INTO ROUTE (ID, NAME, PRIORITY, AGENT_ID) VALUES (2, 'Route2', 2, 1);
        INSERT INTO ROUTE (ID, NAME, PRIORITY, AGENT_ID) VALUES (3, 'Route3', 3, 1);


        INSERT INTO MODULE (ID, NAME, TYPE, AGENT_ID) VALUES (1, 'Module1', 'INPUT', 1);
        INSERT INTO MODULE (ID, NAME, TYPE, AGENT_ID) VALUES (2, 'Module2', 'OUTPUT', 1);
        INSERT INTO MODULE (ID, NAME, TYPE, AGENT_ID) VALUES (3, 'Module3', 'OUTPUT', 1);
        INSERT INTO MODULE (ID, NAME, TYPE, AGENT_ID) VALUES (4, 'Module4', 'EXTENSION', 1);
        INSERT INTO MODULE (ID, NAME, TYPE, AGENT_ID) VALUES (5, 'Module5', 'EXTENSION', 1);


        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (1, 1, 1);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (2, 2, 1);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (3, 3, 1);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (4, 4, 1);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (5, 5, 1);

        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (6, 1, 2);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (7, 2, 2);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (8, 3, 2);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (9, 4, 2);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (10, 5, 2);

        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (11, 1, 3);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (12, 2, 3);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (13, 3, 3);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (14, 4, 3);
        INSERT INTO MODULE_ROUTE (ID, MODULE_ID, ROUTE_ID) VALUES (15, 5, 3);

         */


        List<Module> modulesIncludedInCompleteRoutes = hibernateRepository.getModulesIncludedInCompleteRoutes(1l);

        System.out.println("Modules included in complete routes: " + modulesIncludedInCompleteRoutes);

    }

}
