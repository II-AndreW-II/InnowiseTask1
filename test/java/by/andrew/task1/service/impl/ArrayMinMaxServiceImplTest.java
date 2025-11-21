package by.andrew.task1.service.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMinMaxServiceImplTest {
    private static final int[] TEST_ARRAY = {5, 2, 8, 1, 9, 3};
    private static final int[] SINGLE_ELEMENT_ARRAY = {42};
    private static final int[] EMPTY_ARRAY = {};

    @Test
    void testFindMinWithValidArray() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(TEST_ARRAY);
        ArrayMinMaxServiceImpl service = new ArrayMinMaxServiceImpl();
        int result = service.findMin(customArray);
        assertEquals(1, result);
    }

    @Test
    void testFindMaxWithValidArray() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(TEST_ARRAY);
        ArrayMinMaxServiceImpl service = new ArrayMinMaxServiceImpl();
        int result = service.findMax(customArray);
        assertEquals(9, result);
    }

    @Test
    void testFindMinWithSingleElement() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(SINGLE_ELEMENT_ARRAY);
        ArrayMinMaxServiceImpl service = new ArrayMinMaxServiceImpl();
        int result = service.findMin(customArray);
        assertEquals(42, result);
    }

    @Test
    void testFindMinWithEmptyArray() {
        CustomArray customArray = CustomArray.createCustomArray(EMPTY_ARRAY);
        ArrayMinMaxServiceImpl service = new ArrayMinMaxServiceImpl();
        assertThrows(CustomArrayException.class, () -> service.findMin(customArray));
    }

    @Test
    void testFindMinWithNull() {
        CustomArray customArray = null;
        ArrayMinMaxServiceImpl service = new ArrayMinMaxServiceImpl();
        assertThrows(CustomArrayException.class, () -> service.findMin(customArray));
    }

    @Test
    void testFindMaxWithNull() {
        CustomArray customArray = null;
        ArrayMinMaxServiceImpl service = new ArrayMinMaxServiceImpl();
        assertThrows(CustomArrayException.class, () -> service.findMax(customArray));
    }
}

