package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxGreaterThanSpecificationTest {

  @Test
  void testIsSatisfiedByWhenMaxGreaterThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 5, 3});
    MaxGreaterThanSpecification spec = new MaxGreaterThanSpecification(3);
    assertTrue(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenMaxEqual() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 3, 2});
    MaxGreaterThanSpecification spec = new MaxGreaterThanSpecification(3);
    assertFalse(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenMaxLessThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 2});
    MaxGreaterThanSpecification spec = new MaxGreaterThanSpecification(3);
    assertFalse(spec.isSatisfiedBy(array));
  }
}
