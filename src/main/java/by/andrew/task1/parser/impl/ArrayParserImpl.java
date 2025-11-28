package by.andrew.task1.parser.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.parser.ArrayParser;
import by.andrew.task1.validator.ArrayValidator;
import by.andrew.task1.validator.impl.ArrayValidatorImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayParserImpl implements ArrayParser{
  private static final Logger logger = LogManager.getLogger(ArrayParserImpl.class);
  private static final String STRING_SEPARATOR_REGEX = "[,\\s+;\\-]+";


  public CustomArray parseLine(String line) throws CustomArrayException {
    final ArrayValidator validator = new ArrayValidatorImpl();
    if (validator.isValidLine(line)) {
      logger.error("Invalid line format: {}", line);
      throw new CustomArrayException("Invalid line format: " + line);
    }

    String[] parts = line.strip().split(STRING_SEPARATOR_REGEX);

    int[] array = Arrays.stream(parts)
            .mapToInt(Integer::parseInt)
            .toArray();
            
    logger.info("Parsed {} numbers from line", array.length);
    return new CustomArray(array);
  }
}
