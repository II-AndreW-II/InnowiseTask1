package by.andrew.task1.service.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.service.ArrayMinMaxService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayMinMaxServiceImpl implements ArrayMinMaxService {
  private static final Logger logger = LogManager.getLogger(ArrayMinMaxServiceImpl.class);

  @Override
  public int findMin(CustomArray customArray) throws CustomArrayException {
    int[] array = customArray.getArray();
    int min = array[0];

    for (int i = 1; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }

    logger.info("Min value found: {}", min);
    return min;
  }

  @Override
  public int findMax(CustomArray customArray) throws CustomArrayException {
    int[] array = customArray.getArray();
    int max = array[0];

    for (int i = 1; i < array.length; i++) {
      if (array[i] > max) {
          max = array[i];
      }
    }

    logger.info("Max value found: {}", max);
    return max;
  }
}
