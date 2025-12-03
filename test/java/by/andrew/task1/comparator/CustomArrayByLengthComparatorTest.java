package by.andrew.task1.comparator;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayByLengthComparatorTest {

  @Test
  void testCompareByLength() throws CustomArrayException {
    CustomArray array1 = new CustomArray(new int[]{1, 2});
    CustomArray array2 = new CustomArray(new int[]{4, 5, 6, 7});
    
    CustomArrayByLengthComparator comparator = new CustomArrayByLengthComparator();
    assertTrue(comparator.compare(array1, array2) < 0);
    assertTrue(comparator.compare(array2, array1) > 0);
  }

  @Test
  void testCompareSameLength() throws CustomArrayException {
    CustomArray array1 = new CustomArray(new int[]{1, 2, 3});
    CustomArray array2 = new CustomArray(new int[]{4, 5, 6});
    
    CustomArrayByLengthComparator comparator = new CustomArrayByLengthComparator();
    assertEquals(0, comparator.compare(array1, array2));
  }
}
