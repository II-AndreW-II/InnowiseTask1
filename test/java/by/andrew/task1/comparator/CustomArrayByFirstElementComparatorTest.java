package by.andrew.task1.comparator;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayByFirstElementComparatorTest {

  @Test
  void testCompareByFirstElement() throws CustomArrayException {
    CustomArray array1 = new CustomArray(new int[]{1, 2, 3});
    CustomArray array2 = new CustomArray(new int[]{2, 5, 6});

    CustomArrayByFirstElementComparator comparator = new CustomArrayByFirstElementComparator();
    assertTrue(comparator.compare(array1, array2) < 0);
    assertTrue(comparator.compare(array2, array1) > 0);
    assertEquals(0, comparator.compare(array1, array1));
  }
}
