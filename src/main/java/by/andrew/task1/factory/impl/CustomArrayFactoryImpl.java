package by.andrew.task1.factory.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.factory.CustomArrayFactory;

public class CustomArrayFactoryImpl implements CustomArrayFactory{
  public CustomArray createCustomArray(int[] array) throws CustomArrayException {
    return new CustomArray(array);
  }
}
