package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumLessThanSpecificationTest {

  @Test
  void testIsSatisfiedByWhenSumLessThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    SumLessThanSpecification spec = new SumLessThanSpecification(10L);
    assertTrue(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenSumEqual() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{5, 6, 4});
    SumLessThanSpecification spec = new SumLessThanSpecification(15L);
    assertFalse(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenSumGreaterThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{5, 6, 7});
    SumLessThanSpecification spec = new SumLessThanSpecification(15L);
    assertFalse(spec.isSatisfiedBy(array));
  }
}
