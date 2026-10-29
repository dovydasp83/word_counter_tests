package com.example.wordcounter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UserTests {
    private final TextCounter textCounter = new TextCounter();

    @Test
    public void countWords_withEmptyString_returnsZero() {
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = textCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWords_withSingleSpace_returnsZero() {
        final String givenString = " ";

        final int expectedResult = 0;
        final int actualResult = textCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWords_onlySymbols_returnsZero() {
        final String givenString = "# $ ^ # @ * (";

        final int expectedResult = 0;
        final int actualResult = textCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWords_symbolsWithWords_ignoresSymbols() {
        final String givenString = "Hello $ World #&^ ";

        final int expectedResult = 2;
        final int actualResult = textCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countWords_numbersWithWords_ignoresNumbers() {
        final String givenString = "Hello 1 World 2";

        final int expectedResult = 2;
        final int actualResult = textCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countSent_withEmptyString_returnsZero() {
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = textCounter.countSent(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countSent_withSingleSpace_returnsZero() {
        final String givenString = " ";

        final int expectedResult = 0;
        final int actualResult = textCounter.countSent(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countSent_withOneSentence_returnsOne() {
        final String givenString = "Hello world.";

        final int expectedResult = 1;
        final int actualResult = textCounter.countSent(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countSent_withDifferentEndings_returnsThree() {
        final String givenString = "Hello world. Hello World? Hello World!";

        final int expectedResult = 3;
        final int actualResult = textCounter.countSent(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countSent_withRepeatedPunctuation_returnsOne() {
        final String givenString = "Hello world!!!";

        final int expectedResult = 1;
        final int actualResult = textCounter.countSent(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countSent_withOnlyPunctuation_returnsZero() {
        final String givenString = ". ! ?";

        final int expectedResult = 0;
        final int actualResult = textCounter.countSent(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countChars_withEmptyString_returnsZero() {
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = textCounter.countChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countChars_withSingleSpace_returnsOne() {
        final String givenString = " ";

        final int expectedResult = 1;
        final int actualResult = textCounter.countChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countChars_withWord_returnsFive() {
        final String givenString = "Hello";

        final int expectedResult = 5;
        final int actualResult = textCounter.countChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countChars_withSpaces_countsSpaces() {
        final String givenString = "Hello world";

        final int expectedResult = 11;
        final int actualResult = textCounter.countChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countChars_withSymbols_countsSymbols() {
        final String givenString = "Hi! #";

        final int expectedResult = 5;
        final int actualResult = textCounter.countChars(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countChars_withNumbers_countsDigits() {
        final String givenString = "12345";

        final int expectedResult = 5;
        final int actualResult = textCounter.countChars(givenString);

        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void countNums_withEmptyString_returnsZero() {
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = textCounter.countNums(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countNums_withOnlyWords_returnsZero() {
        final String givenString = "Hello world";

        final int expectedResult = 0;
        final int actualResult = textCounter.countNums(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countNums_withSingleDigit_returnsOne() {
        final String givenString = "7";

        final int expectedResult = 1;
        final int actualResult = textCounter.countNums(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countNums_withMultipleDigits_returnsFive() {
        final String givenString = "12345";

        final int expectedResult = 5;
        final int actualResult = textCounter.countNums(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countNums_withWordsAndDigits_countsDigits() {
        final String givenString = "I have 12 apples and 3 oranges";

        final int expectedResult = 3;
        final int actualResult = textCounter.countNums(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void countNums_withSymbolsAndDigits_ignoresSymbols() {
        final String givenString = "-12.5";

        final int expectedResult = 3;
        final int actualResult = textCounter.countNums(givenString);

        assertEquals(expectedResult, actualResult);
    }
}


