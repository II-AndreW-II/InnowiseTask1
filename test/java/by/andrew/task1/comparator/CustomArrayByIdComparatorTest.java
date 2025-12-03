package by.andrew.task1.comparator;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayByIdComparatorTest {

  @Test
  void testCompareById() throws CustomArrayException {
    CustomArray array1 = new CustomArray(new int[]{1, 2, 3});
    CustomArray array2 = new CustomArray(new int[]{4, 5, 6});
    
    CustomArrayByIdComparator comparator = new CustomArrayByIdComparator();
    
    int result = comparator.compare(array1, array2);
    assertTrue(result != 0 || array1.getId() == array2.getId());
  }

  @Test
  void testCompareSameId() throws CustomArrayException {
    CustomArray array1 = new CustomArray(new int[]{1, 2, 3});
    CustomArrayByIdComparator comparator = new CustomArrayByIdComparator();
    assertEquals(0, comparator.compare(array1, array1));
  }
}
