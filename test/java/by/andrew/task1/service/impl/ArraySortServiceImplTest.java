package by.andrew.task1.service.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortServiceImplTest {
    private static final int[] UNSORTED_ARRAY = {5, 2, 8, 1, 9, 3};
    private static final int[] EXPECTED_SORTED = {1, 2, 3, 5, 8, 9};
    private static final int[] SINGLE_ELEMENT_ARRAY = {42};
    private static final int[] EMPTY_ARRAY = {};

    @Test
    void testSortBubbleWithUnsortedArray() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(UNSORTED_ARRAY);
        ArraySortServiceImpl service = new ArraySortServiceImpl();
        CustomArray result = service.sortBubble(customArray);
        assertArrayEquals(EXPECTED_SORTED, result.getArray());
    }

    @Test
    void testSortQuickWithUnsortedArray() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(UNSORTED_ARRAY);
        ArraySortServiceImpl service = new ArraySortServiceImpl();
        CustomArray result = service.sortQuick(customArray);
        assertArrayEquals(EXPECTED_SORTED, result.getArray());
    }

    @Test
    void testSortBubbleDoesNotModifyOriginal() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(UNSORTED_ARRAY);
        ArraySortServiceImpl service = new ArraySortServiceImpl();
        service.sortBubble(customArray);
        assertArrayEquals(UNSORTED_ARRAY, customArray.getArray());
    }

    @Test
    void testSortQuickWithSingleElement() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(SINGLE_ELEMENT_ARRAY);
        ArraySortServiceImpl service = new ArraySortServiceImpl();
        CustomArray result = service.sortQuick(customArray);
        assertArrayEquals(SINGLE_ELEMENT_ARRAY, result.getArray());
    }

    @Test
    void testSortBubbleWithEmptyArray() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(EMPTY_ARRAY);
        ArraySortServiceImpl service = new ArraySortServiceImpl();
        CustomArray result = service.sortBubble(customArray);
        assertEquals(0, result.length());
    }

    @Test
    void testSortBubbleWithNull() {
        CustomArray customArray = null;
        ArraySortServiceImpl service = new ArraySortServiceImpl();
        assertThrows(CustomArrayException.class, () -> service.sortBubble(customArray));
    }

    @Test
    void testSortQuickWithNull() {
        CustomArray customArray = null;
        ArraySortServiceImpl service = new ArraySortServiceImpl();
        assertThrows(CustomArrayException.class, () -> service.sortQuick(customArray));
    }

    @Test
    void testBothSortMethodsProduceSameResult() throws CustomArrayException {
        CustomArray customArray = CustomArray.createCustomArray(UNSORTED_ARRAY);
        ArraySortServiceImpl service = new ArraySortServiceImpl();
        CustomArray bubbleResult = service.sortBubble(customArray);
        CustomArray quickResult = service.sortQuick(customArray);
        assertArrayEquals(bubbleResult.getArray(), quickResult.getArray());
    }
}

