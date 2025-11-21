package by.andrew.task1.service;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

public interface ArraySumService {
    long calculateSum(CustomArray customArray) throws CustomArrayException;
}

