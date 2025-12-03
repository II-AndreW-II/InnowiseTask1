package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdSpecificationTest {

  @Test
  void testIsSatisfiedByWhenIdMatches() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    int arrayId = array.getId();
    IdSpecification spec = new IdSpecification(arrayId);
    assertTrue(spec.isSatisfiedBy(array));
  }

  @Test
  void testIsSatisfiedByWhenIdDoesNotMatch() throws CustomArrayException {
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    IdSpecification spec = new IdSpecification(999);
    assertFalse(spec.isSatisfiedBy(array));
  }
}
