package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountGreaterThanSpecificationTest {

  @Test
  void testIsSatisfiedByWhenCountGreaterThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 3, 4});
    CountGreaterThanSpecification spec = new CountGreaterThanSpecification(3);
    assertTrue(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenCountEqual() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    CountGreaterThanSpecification spec = new CountGreaterThanSpecification(3);
    assertFalse(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenCountLessThan() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2});
    CountGreaterThanSpecification spec = new CountGreaterThanSpecification(3);
    assertFalse(spec.isSatisfiedBy(array));
  }
}
