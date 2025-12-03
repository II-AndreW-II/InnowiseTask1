package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SumGreaterThanSpecificationTest {

  @Test
  void testIsSatisfiedByWhenSumGreaterThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{5, 6, 7});
    SumGreaterThanSpecification spec = new SumGreaterThanSpecification(15L);
    assertTrue(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenSumEqual() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{5, 6, 4});
    SumGreaterThanSpecification spec = new SumGreaterThanSpecification(15L);
    assertFalse(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenSumLessThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    SumGreaterThanSpecification spec = new SumGreaterThanSpecification(10L);
    assertFalse(spec.isSatisfiedBy(array));
  }
}
