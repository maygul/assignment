package com.maygul.assignment.question;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class Q1Test {

    @Test
    public void testIsCurrentVersionHigherOrEqualSimpleCase() {

        boolean result = Q1.isCurrentVersionHigherOrEqual("2.1.8", "2.1.9");


        assertEquals(true, result);
    }

    //fails on schenario where one of the part's digit number gets higher, eve if the version is lower, in comparition it's calculated as bigger as below
    @Test
    public void testIsCurrentVersionHigherOrEqualFailCase() {

        boolean result = Q1.isCurrentVersionHigherOrEqual("2.1.9", "1.11.5");


        assertEquals(false, result);
    }

    @Test
    public void testIsCurrentVersionHigherOrEqualUpdated() {

        boolean result = Q1.isCurrentVersionHigherOrEqualUpdated("2.1.9", "2.1.9");

        assertEquals(true, result);
    }

    @Test
    public void testIsCurrentVersionHigherOrEqualUpdated2() {

        boolean result = Q1.isCurrentVersionHigherOrEqualUpdated("2.1.9", "1.11.5");

        assertEquals(false, result);
    }
}
