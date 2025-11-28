package by.andrew.task1.factory;

import by.andrew.task1.entity.CustomArray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayFactoryTest {
  private static final int[] TEST_ARRAY = {1, 2, 3, 4, 5};

  @Test
  void testCreateCustomArray() {
    int[] array = TEST_ARRAY;
    CustomArray result = new CustomArray(array);
    assertNotNull(result);
    assertEquals(5, result.length());
    assertArrayEquals(TEST_ARRAY, result.getArray());
  }

  @Test
  void testCreateCustomArrayWithNull() {
    int[] array = null;
    CustomArray result = new CustomArray(array);
    assertNotNull(result);
    assertEquals(0, result.length());
  }
}

