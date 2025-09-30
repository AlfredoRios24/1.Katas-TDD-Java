package com.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeapYearTest {

    @Test
    public void testYearsDivisibleBy400 () {
        assertTrue(LeapYear.isLeapYear(1600));
        assertTrue(LeapYear.isLeapYear(2000));
        assertTrue(LeapYear.isLeapYear(2400));
    }

    @Test
    public void testYearsDivisibleBy100ButNot400() {
        assertFalse(LeapYear.isLeapYear(1700));
        assertFalse(LeapYear.isLeapYear(1800));
        assertFalse(LeapYear.isLeapYear(1900));
        assertFalse(LeapYear.isLeapYear(2100));
    }

    @Test
    public void testYearsDivisibleBy4ButNot100() {
        assertTrue(LeapYear.isLeapYear(1996));
        assertTrue(LeapYear.isLeapYear(2004));
        assertTrue(LeapYear.isLeapYear(2020));
    }

    @Test
    public void testYearsNotDivisibleBy4() {
        assertFalse(LeapYear.isLeapYear(2019));
        assertFalse(LeapYear.isLeapYear(2021));
        assertFalse(LeapYear.isLeapYear(2022));
    }

    @Test
    public void testInvalidYears() {
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(0));
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(-1));
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(-400));
    }

    @Test
    public void testYearsBeforeGregorianCalendar() {
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(1500));
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(1200));
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(100));
    }

    @Test
    public void testLeapYearBulkValidation() {
        int[] years = {1600, 1700, 1800, 2000, 2004, 2019, 2020};
        boolean[] expected = {true, false, false, true, true, false, true};

        boolean[] results = LeapYear.validateLeapYears(years);

        assertArrayEquals(expected, results, "Validación masiva de años bisiestos incorrecta");
    }

}
