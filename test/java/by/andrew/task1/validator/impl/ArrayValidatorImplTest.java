package by.andrew.task1.validator.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorImplTest {
  private static final String VALID_LINE_COMMA = "1, 2, 3";
  private static final String VALID_LINE_DASH = "1 - 2 - 3";
  private static final String VALID_LINE_SPACE = "3 4 7";
  private static final String VALID_EMPTY_LINE = "";
  private static final String VALID_LINE_SEMICOLON = "1; 2; 3";
  private static final String INVALID_LINE = "1y1 21 32";

  @Test
  void testIsValidLineWithCommaSeparated() {
    String line = VALID_LINE_COMMA;
    ArrayValidatorImpl validator = new ArrayValidatorImpl();
    boolean result = validator.isValidLine(line);
    assertTrue(result);
  }

  @Test
  void testIsValidLineWithDashSeparated() {
    String line = VALID_LINE_DASH;
    ArrayValidatorImpl validator = new ArrayValidatorImpl();
    boolean result = validator.isValidLine(line);
    assertTrue(result);
  }

  @Test
  void testIsValidLineWithSpaceSeparated() {
    String line = VALID_LINE_SPACE;
    ArrayValidatorImpl validator = new ArrayValidatorImpl();
    boolean result = validator.isValidLine(line);
    assertTrue(result);
  }

  @Test
  void testIsValidLineWithSemicolonSeparated() {
    String line = VALID_LINE_SEMICOLON;
    ArrayValidatorImpl validator = new ArrayValidatorImpl();
    boolean result = validator.isValidLine(line);
    assertTrue(result);
  }

  @Test
  void testIsValidLineWithEmptyLine() {
    String line = VALID_EMPTY_LINE;
    ArrayValidatorImpl validator = new ArrayValidatorImpl();
    boolean result = validator.isValidLine(line);
    assertTrue(result);
  }

  @Test
  void testIsValidLineWithInvalidLine() {
    String line = INVALID_LINE;
    ArrayValidatorImpl validator = new ArrayValidatorImpl();
    boolean result = validator.isValidLine(line);
    assertFalse(result);
  }

  @Test
  void testIsValidLineWithNull() {
    String line = null;
    ArrayValidatorImpl validator = new ArrayValidatorImpl();
    boolean result = validator.isValidLine(line);
    assertFalse(result);
  }
}

