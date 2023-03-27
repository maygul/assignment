package com.maygul.assignment.question.q4;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class HibernateRepository {

    private Session session;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Returns all modules for agent which are included in a complete route.
     * A complete route contains at least 1 INPUT module and at least 1 OUTPUT module.
     */

    /**
     * implementation uses a subquery to first select all routes for the given agentId,
     * and then filters the result based on the ModuleType criteria.
     * <p>
     * The subquery groups by Route ID and counts the number of distinct Module IDs that have the ModuleType.INPUT or ModuleType.OUTPUT.
     * <p>
     * Finally, it filters the result to only include routes where the count is greater than or equal to the required number of ModuleTypes.
     *
     * @param agentId
     * @return
     */
    public List<Module> getModulesIncludedInCompleteRoutes(Long agentId) {

        session = entityManager.unwrap(Session.class);

        String hql = "SELECT DISTINCT mr.module FROM ModuleRoute mr "
                + "INNER JOIN mr.route r "
                + "INNER JOIN mr.module m "
                + "WHERE r.agent.id = :agentId "
                + "AND m.type IN (:inputOutputTypes) "
                + "AND r.id IN "
                + "(SELECT r2.id FROM Route r2 "
                + "INNER JOIN r2.moduleRoutes mr2 "
                + "INNER JOIN mr2.module m2 "
                + "WHERE r2.agent.id = :agentId "
                + "GROUP BY r2.id "
                + "HAVING COUNT(DISTINCT CASE WHEN m2.type IN (:inputOutputTypes) THEN m2.id END) >= :requiredModuleTypesCount)";

        List<ModuleType> inputOutputTypes = Arrays.asList(ModuleType.INPUT, ModuleType.OUTPUT);
        int requiredModuleTypesCount = inputOutputTypes.size();

        Query<Module> query = session.createQuery(hql, Module.class)
                .setParameter("agentId", agentId)
                .setParameterList("inputOutputTypes", inputOutputTypes)
                .setParameter("requiredModuleTypesCount", (long) requiredModuleTypesCount);

        return new ArrayList<>(query.list());
    }

    public void lazyConfigDataUsage(long id) {
        session = entityManager.unwrap(Session.class);
        //this won't call a additional query for GlobalConfigData
        Agent agent = session.createQuery("SELECT a FROM Agent a WHERE a.id = :id", Agent.class)
                .setParameter("id", id)
                .getSingleResult();

        //this will call a additional query for GlobalConfigData
        agent.getGlobalConfigData();

        System.out.println("completed!");

    }
}
