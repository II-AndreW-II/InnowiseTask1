package by.andrew.task1.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayTest {
  private static final int[] TEST_ARRAY = {1, 2, 3, 4, 5};
  private static final int[] EMPTY_ARRAY = {};
  private static final int[] SINGLE_ELEMENT_ARRAY = {42};

  @Test
  void testCreateCustomArrayWithValidArray() {
    int[] array = TEST_ARRAY;
    CustomArray customArray = new CustomArray(array);
    assertNotNull(customArray);
    assertEquals(5, customArray.length());
  }

  @Test
  void testCreateCustomArrayWithNull() {
    int[] array = null;
    CustomArray customArray = new CustomArray(array);
    assertNotNull(customArray);
    assertEquals(0, customArray.length());
  }

  @Test
  void testGetArrayReturnsClone() {
    int[] array = TEST_ARRAY;
    CustomArray customArray = new CustomArray(array);
    int[] retrievedArray = customArray.getArray();
    retrievedArray[0] = 999;
    assertNotEquals(999, customArray.getArray()[0]);
    assertEquals(1, customArray.getArray()[0]);
  }

  @Test
  void testSetArray() {
    CustomArray customArray = new CustomArray(EMPTY_ARRAY);
    int[] newArray = SINGLE_ELEMENT_ARRAY;
    customArray.setArray(newArray);
    assertEquals(1, customArray.length());
    assertEquals(42, customArray.getArray()[0]);
  }

  @Test
  void testEquals() {
    int[] array1 = TEST_ARRAY;
    int[] array2 = {1, 2, 3, 4, 5};
    int[] array3 = {1, 2, 3, 4, 6};
    CustomArray customArray1 = new CustomArray(array1);
    CustomArray customArray2 = new CustomArray(array2);
    CustomArray customArray3 = new CustomArray(array3);
    assertEquals(customArray1, customArray2);
    assertNotEquals(customArray1, customArray3);
  }

  @Test
  void testHashCode() {
    int[] array1 = TEST_ARRAY;
    int[] array2 = {1, 2, 3, 4, 5};
    CustomArray customArray1 = new CustomArray(array1);
    CustomArray customArray2 = new CustomArray(array2);
    assertEquals(customArray1.hashCode(), customArray2.hashCode());
  }
}

