package com.maygul.assignment.question;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q3_JavaStreams {

    public static void main(String[] args) {


        /**
         *
         *         final List<AgentInfoBean> agentInfos = fetchItems();
         *         List<AgentInfoBean> filteredResults = new LinkedList<AgentInfoBean>();
         *         for (AgentInfoBean item : agentInfos) {
         *             if (states.contains(item.getStatus())) {
         *                 filteredResults.add(item);
         *             }
         *         }
         */
        // states was missing in given code block so I've added it as below
        List<String> states = Arrays.asList("A", "B", "C");

        List<AgentInfoBean> filteredResults = fetchItems().stream()
                .filter(item -> states.contains(item.getStatus()))
                .collect(Collectors.toList());

    }

    private static List<AgentInfoBean> fetchItems() {
        return Arrays.asList(
                new AgentInfoBean("A"),
                new AgentInfoBean("B"),
                new AgentInfoBean("C"),
                new AgentInfoBean("D"),
                new AgentInfoBean("E"),
                new AgentInfoBean("F"),
                new AgentInfoBean("G"),
                new AgentInfoBean("H"),
                new AgentInfoBean("I"),
                new AgentInfoBean("J"),
                new AgentInfoBean("A"),
                new AgentInfoBean("B"),
                new AgentInfoBean("C")
        );
    }
}

class AgentInfoBean {

    AgentInfoBean(String status) {
        this.status = status;
    }

    private String status;

    public String getStatus() {
        return status;
    }
}