package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.service.ArraySumService;
import by.andrew.task1.service.impl.ArraySumServiceImpl;
import by.andrew.task1.specification.Specification;

public class SumGreaterThanSpecification implements Specification<CustomArray> {
    private final long value;
    private final ArraySumService sumService = new ArraySumServiceImpl();

    public SumGreaterThanSpecification(long value) {
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(CustomArray array) {
        try {
            return sumService.calculateSum(array) > value;
        } catch (CustomArrayException e) {
            return false;
        }
    }
}