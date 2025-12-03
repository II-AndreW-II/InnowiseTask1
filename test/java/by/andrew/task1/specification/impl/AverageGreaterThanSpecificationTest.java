package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AverageGreaterThanSpecificationTest {

  @Test
  void testIsSatisfiedByWhenAverageGreaterThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{4, 5, 6});
    AverageGreaterThanSpecification spec = new AverageGreaterThanSpecification(4.0);
    assertTrue(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenAverageEqual() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{3, 3, 3});
    AverageGreaterThanSpecification spec = new AverageGreaterThanSpecification(3.0);
    assertFalse(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenAverageLessThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 2});
    AverageGreaterThanSpecification spec = new AverageGreaterThanSpecification(2.0);
    assertFalse(spec.isSatisfiedBy(array));
  }
}
