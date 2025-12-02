package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.specification.Specification;

public class CountGreaterThanSpecification implements Specification<CustomArray> {
    private final int value;

    public CountGreaterThanSpecification(int value) {
        this.value = value;
    }

    @Override
    public boolean isSatisfiedBy(CustomArray array) {
        return array.getArray().length > value;
    }
}