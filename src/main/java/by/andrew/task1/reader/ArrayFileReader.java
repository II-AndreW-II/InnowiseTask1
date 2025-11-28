package by.andrew.task1.reader;

import java.util.List;

import by.andrew.task1.exception.CustomArrayException;

public interface ArrayFileReader {

  public List<String> readLines(String filePath) throws CustomArrayException;
}

