package by.andrew.task1.service;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;

public interface ArraySortService {
    CustomArray sortBubble(CustomArray customArray) throws CustomArrayException;

    CustomArray sortQuick(CustomArray customArray) throws CustomArrayException;
}

