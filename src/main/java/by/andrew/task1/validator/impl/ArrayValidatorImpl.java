package by.andrew.task1.validator.impl;

import by.andrew.task1.validator.ArrayValidator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class ArrayValidatorImpl implements ArrayValidator {
  private static final Logger logger = LogManager.getLogger(ArrayValidatorImpl.class);
  private static final String STRING_LINE_REGEX = "^\\s*((-?\\d+)(\\s*[,\\s;\\-]+\\s*-?\\d+)*\\s*)?$";
  

  @Override
  public boolean isValidLine(String line) {
    final Pattern pattern = Pattern.compile(STRING_LINE_REGEX);
    boolean isValid = pattern.matcher(line).matches();
    logger.info("Line [" + line + "] is valid: " + isValid + ". "  + pattern);
    return isValid;
  }
}

