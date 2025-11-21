package by.andrew.task1.parser;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayParserTest {
    private static final String VALID_LINE_COMMA = "1, 2, 3";
    private static final String VALID_LINE_DASH = "1 - 2 - 3";
    private static final String VALID_LINE_SPACE = "3 4 7";
    private static final String VALID_EMPTY_LINE = "";
    private static final String VALID_LINE_SEMICOLON = "1; 2; 3";
    private static final String INVALID_LINE = "1y1 21 32";
    private static final int[] EXPECTED_ARRAY_COMMA = {1, 2, 3};
    private static final int[] EXPECTED_ARRAY_SPACE = {3, 4, 7};

    @Test
    void testParseLineWithCommaSeparated() throws CustomArrayException {
        String line = VALID_LINE_COMMA;
        ArrayParser parser = new ArrayParser();
        CustomArray result = parser.parseLine(line);
        assertArrayEquals(EXPECTED_ARRAY_COMMA, result.getArray());
    }

    @Test
    void testParseLineWithDashSeparated() throws CustomArrayException {
        String line = VALID_LINE_DASH;
        ArrayParser parser = new ArrayParser();
        CustomArray result = parser.parseLine(line);
        assertArrayEquals(EXPECTED_ARRAY_COMMA, result.getArray());
    }

    @Test
    void testParseLineWithSpaceSeparated() throws CustomArrayException {
        String line = VALID_LINE_SPACE;
        ArrayParser parser = new ArrayParser();
        CustomArray result = parser.parseLine(line);
        assertArrayEquals(EXPECTED_ARRAY_SPACE, result.getArray());
    }

    @Test
    void testParseLineWithSemicolonSeparated() throws CustomArrayException {
        String line = VALID_LINE_SEMICOLON;
        ArrayParser parser = new ArrayParser();
        CustomArray result = parser.parseLine(line);
        assertArrayEquals(EXPECTED_ARRAY_COMMA, result.getArray());
    }

    @Test
    void testParseLineWithEmptyLine() throws CustomArrayException {
        String line = VALID_EMPTY_LINE;
        ArrayParser parser = new ArrayParser();
        CustomArray result = parser.parseLine(line);
        assertEquals(0, result.length());
    }

    @Test
    void testParseLineWithInvalidLine() {
        String line = INVALID_LINE;
        ArrayParser parser = new ArrayParser();
        assertThrows(CustomArrayException.class, () -> parser.parseLine(line));
    }

    @Test
    void testParseLineWithNull() {
        String line = null;
        ArrayParser parser = new ArrayParser();
        assertThrows(CustomArrayException.class, () -> parser.parseLine(line));
    }
}

