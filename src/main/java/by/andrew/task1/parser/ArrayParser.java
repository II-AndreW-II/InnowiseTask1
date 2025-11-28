package by.andrew.task1.parser;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

public interface ArrayParser {
  public CustomArray parseLine(String line) throws CustomArrayException;
}

