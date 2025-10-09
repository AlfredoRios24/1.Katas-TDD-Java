package com.kata;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BankOcrTest {

    @Test
    public void shouldHandleEmptyInputGracefully() {
        assertThrows(IllegalArgumentException.class, () -> BankOcr.parseAccount(List.of()));
    }

    @Test
    public void shouldReturnQuestionMarksForAllUnknownDigits() {
        List<String> input = List.of(
                "                           ",
                "                           ",
                "                           "
        );
        String result = BankOcr.parseAccount(input);
        assertEquals("?????????", result);
    }

    @Test
    public void shouldThrowExceptionWhenParsingIncompleteAccountBlock() {
        List<String> incomplete = List.of(
                " _  _  _ ",
                "| || || |"
                // Falta la tercera línea
        );
        assertThrows(IllegalArgumentException.class, () -> BankOcr.parseMultipleAccounts(incomplete));
    }

    @Test
    public void shouldRejectChecksumIfWrongLength() {
        assertFalse(BankOcr.isValidChecksum("12345"));
        assertFalse(BankOcr.isValidChecksum("1234567890"));
    }

    @Test
    public void shouldReturnFalseForAccountWithLettersOrSymbols() {
        assertFalse(BankOcr.isValidChecksum("12A45678B"));
        assertFalse(BankOcr.isValidChecksum("12#45*789"));
        assertFalse(BankOcr.isValidChecksum(""));
        assertFalse(BankOcr.isValidChecksum(null));
    }

    @Test
    public void shouldReturnFalseForNegativeAccountNumbers() {
        assertFalse(BankOcr.isValidChecksum("-12345678"));
        assertFalse(BankOcr.isValidChecksum("-000000001"));
    }

    @Test
    public void shouldReturnQuestionMarkForUnknownDigit() {
        List<String> input = List.of(
                " _ ",
                "| |",
                "|  "
        );
        String result = BankOcr.parseAccount(input);
        assertEquals("?", result);
    }

    @Test
    public void shouldThrowExceptionForInvalidInputLines() {
        List<String> input = List.of(" _ ", "|_|");
        assertThrows(IllegalArgumentException.class, () -> BankOcr.parseAccount(input));
    }

    @Test
    public void shouldReturnFalseForNonNumericChecksum() {
        assertFalse(BankOcr.isValidChecksum("12?45?789"));
    }

    @Test
    public void shouldReturnFalseForAccountWithMoreThanNineDigits() {
        assertFalse(BankOcr.isValidChecksum("1234567890"));
        assertFalse(BankOcr.isValidChecksum("111111111111"));
        assertFalse(BankOcr.isValidChecksum("987654321012345"));
    }

    @Test
    public void shouldParseOneAccountCorrectly() {
        List<String> input = List.of(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|"
        );
        String result = BankOcr.parseAccount(input);
        assertEquals("?234567?9", result);
    }

    @Test
    public void shouldParseMultipleAccounts() {
        List<String> input = List.of(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|",
                "",
                " _  _  _  _  _  _  _  _  _ ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|"
        );
        List<String> results = BankOcr.parseMultipleAccounts(input);
        assertEquals(List.of("?234567?9", "000000000"), results);
    }

    @Test
    public void shouldValidateChecksumCorrectly() {
        assertTrue(BankOcr.isValidChecksum("345882865"));
        assertFalse(BankOcr.isValidChecksum("123456788"));
    }
}
