package com.maygul.assignment.util;

public class ValidationUtils {
    public static boolean isEmptyString(String currentAgentVersion) {
        return currentAgentVersion == null || currentAgentVersion.trim().isEmpty();
    }
}
