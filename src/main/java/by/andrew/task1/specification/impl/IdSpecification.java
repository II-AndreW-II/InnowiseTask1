package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.specification.Specification;

public class IdSpecification implements Specification<CustomArray> {
    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean isSatisfiedBy(CustomArray array) {
        return array.getId() == this.id;
    }
}
