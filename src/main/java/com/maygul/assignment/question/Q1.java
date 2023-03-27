package com.maygul.assignment.question;


import com.maygul.assignment.util.ValidationUtils;

public class Q1 {
    public static boolean isCurrentVersionHigherOrEqual(String agentVersion, String currentAgentVersion) {
        boolean result = false;
        if (!ValidationUtils.isEmptyString(currentAgentVersion) && !ValidationUtils.isEmptyString(agentVersion)) {
            String _currentAgentVersion = currentAgentVersion.replaceAll("\\.", "");
            String _agentVersion = agentVersion.replaceAll("\\.", "");
            result = Integer.valueOf(_currentAgentVersion) >= Integer.valueOf(_agentVersion);
        }

        return result;
    }

    public static boolean isCurrentVersionHigherOrEqualUpdated(String agentVersion, String currentAgentVersion) {
        String[] agentVersionParts = agentVersion.split("\\.");
        String[] currentAgentVersionParts = currentAgentVersion.split("\\.");

        // Compare major_version first
        if (Integer.parseInt(currentAgentVersionParts[0]) < Integer.parseInt(agentVersionParts[0])) {
            return false;
        } else if (Integer.parseInt(currentAgentVersionParts[0]) > Integer.parseInt(agentVersionParts[0])) {
            return true;
        }

        // Compare minor_version second
        if (Integer.parseInt(currentAgentVersionParts[1]) < Integer.parseInt(agentVersionParts[1])) {
            return false;
        } else if (Integer.parseInt(currentAgentVersionParts[1]) > Integer.parseInt(agentVersionParts[1])) {
            return true;
        }

        // Compare build_number last
        if (Integer.parseInt(currentAgentVersionParts[2]) < Integer.parseInt(agentVersionParts[2])) {
            return false;
        }

        // If all parts are equal, the versions are the same
        return true;
    }
}