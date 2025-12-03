package by.andrew.task1.service.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.service.ArraySumService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySumServiceImpl implements ArraySumService {
  private static final Logger logger = LogManager.getLogger();

  @Override
  public long calculateSum(CustomArray customArray) throws CustomArrayException {
    int[] array = customArray.getArray();
    long sum = 0;

    for (int value : array) {
      sum += value;
    }

    logger.info("Sum calculated: {}", sum);
    return sum;
  }
}
