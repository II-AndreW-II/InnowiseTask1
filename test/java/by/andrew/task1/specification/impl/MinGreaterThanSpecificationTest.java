package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinGreaterThanSpecificationTest {

  @Test
  void testIsSatisfiedByWhenMinGreaterThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{3, 5, 7});
    MinGreaterThanSpecification spec = new MinGreaterThanSpecification(2);
    assertTrue(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenMinEqual() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{2, 5, 7});
    MinGreaterThanSpecification spec = new MinGreaterThanSpecification(2);
    assertFalse(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenMinLessThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 5, 7});
    MinGreaterThanSpecification spec = new MinGreaterThanSpecification(2);
    assertFalse(spec.isSatisfiedBy(array));
  }
}
