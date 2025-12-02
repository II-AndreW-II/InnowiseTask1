package by.andrew.task1.factory;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

public interface CustomArrayFactory {
  CustomArray createCustomArray(int[] array) throws CustomArrayException;
}
