package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumEqualSpecificationTest {

  @Test
  void testIsSatisfiedByWhenSumEqual() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{5, 6, 4});
    SumEqualSpecification spec = new SumEqualSpecification(15L);
    assertTrue(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenSumNotEqual() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    SumEqualSpecification spec = new SumEqualSpecification(10L);
    assertFalse(spec.isSatisfiedBy(array));
  }
}
