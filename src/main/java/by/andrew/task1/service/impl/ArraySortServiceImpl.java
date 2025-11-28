package by.andrew.task1.service.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.service.ArraySortService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortServiceImpl implements ArraySortService {
  private static final Logger logger = LogManager.getLogger(ArraySortServiceImpl.class);

  @Override
  public CustomArray sortBubble(CustomArray customArray) throws CustomArrayException {
    int[] array = customArray.getArray();
    int n = array.length;

    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }

    logger.info("Array sorted using bubble sort");
    return new CustomArray(array);
  }

  @Override
  public CustomArray sortQuick(CustomArray customArray) throws CustomArrayException {
    int[] array = customArray.getArray();
    quickSort(array, 0, array.length - 1);

    logger.info("Array sorted using quick sort");
    return new CustomArray(array);
  }

  private void quickSort(int[] array, int low, int high) {
    if (low < high) {
      int pivotIndex = partition(array, low, high);
      quickSort(array, low, pivotIndex - 1);
      quickSort(array, pivotIndex + 1, high);
    }
  }

  private int partition(int[] array, int low, int high) {
    int pivot = array[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
      }
    }

    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    return i + 1;
  }
}

