package by.andrew.task1.service.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySumServiceImplTest {
  private static final int[] TEST_ARRAY = {1, 2, 3, 4, 5};
  private static final int[] EMPTY_ARRAY = {};
  private static final int[] SINGLE_ELEMENT_ARRAY = {10};
  private static final int[] NEGATIVE_ARRAY = {-1, -2, -3};

  @Test
  void testCalculateSumWithValidArray() throws CustomArrayException {
    CustomArray customArray = new CustomArray(TEST_ARRAY);
    ArraySumServiceImpl service = new ArraySumServiceImpl();
    long result = service.calculateSum(customArray);
    assertEquals(15, result);
  }

  @Test
  void testCalculateSumWithEmptyArray() throws CustomArrayException {
    CustomArray customArray = new CustomArray(EMPTY_ARRAY);
    ArraySumServiceImpl service = new ArraySumServiceImpl();
    long result = service.calculateSum(customArray);
    assertEquals(0, result);
  }

  @Test
  void testCalculateSumWithSingleElement() throws CustomArrayException {
    CustomArray customArray = new CustomArray(SINGLE_ELEMENT_ARRAY);
    ArraySumServiceImpl service = new ArraySumServiceImpl();
    long result = service.calculateSum(customArray);
    assertEquals(10, result);
  }

  @Test
  void testCalculateSumWithNegativeNumbers() throws CustomArrayException {
    CustomArray customArray = new CustomArray(NEGATIVE_ARRAY);
    ArraySumServiceImpl service = new ArraySumServiceImpl();
    long result = service.calculateSum(customArray);
    assertEquals(-6, result);
  }

  @Test
  void testCalculateSumWithNull() {
    CustomArray customArray = null;
    ArraySumServiceImpl service = new ArraySumServiceImpl();
    assertThrows(CustomArrayException.class, () -> service.calculateSum(customArray));
  }
}

