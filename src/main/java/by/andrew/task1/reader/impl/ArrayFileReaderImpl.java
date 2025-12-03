package by.andrew.task1.reader.impl;

import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.reader.ArrayFileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayFileReaderImpl implements ArrayFileReader {
  private static final Logger logger = LogManager.getLogger();

  public List<String> readLines(String filePath) throws CustomArrayException {
    Path path = Paths.get(filePath);

    if (!Files.exists(path)) {
      logger.error("File does not exist: {}", filePath);
      throw new CustomArrayException("File does not exist: " + filePath);
    }

    try (Stream<String> lines = Files.lines(path)) {
      List<String> result = lines.collect(Collectors.toList());
      logger.info("Read {} lines from file: {}", result.size(), filePath);
      return result;
    } catch (IOException e) {
      logger.error("Error reading file: {}", filePath, e);
      throw new CustomArrayException("Error reading file: " + filePath, e);
    }
  }
}
