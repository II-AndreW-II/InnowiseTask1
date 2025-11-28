package by.andrew.task1.service;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

public interface ArrayMinMaxService {
  int findMin(CustomArray customArray) throws CustomArrayException;

  int findMax(CustomArray customArray) throws CustomArrayException;
}

