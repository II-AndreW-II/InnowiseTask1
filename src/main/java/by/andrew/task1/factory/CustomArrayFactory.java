package by.andrew.task1.factory;

import by.andrew.task1.entity.CustomArray;

public class CustomArrayFactory {
    public static CustomArray createCustomArray(int[] array) {
        return CustomArray.createCustomArray(array);
    }
}

