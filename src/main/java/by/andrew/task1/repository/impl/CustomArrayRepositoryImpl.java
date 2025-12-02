package by.andrew.task1.repository.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.repository.CustomArrayRepository;
import by.andrew.task1.specification.Specification;
import by.andrew.task1.warehouse.Warehouse;

import java.util.*;
import java.util.stream.Collectors;

public class CustomArrayRepositoryImpl implements CustomArrayRepository {
    private static CustomArrayRepositoryImpl instance;
    private final List<CustomArray> arrays = new ArrayList<>();

    private CustomArrayRepositoryImpl() {}

    public static CustomArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new CustomArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(CustomArray array) {
        if (array != null && !arrays.contains(array)) {
            arrays.add(array);
        }
    }

    @Override
    public void remove(CustomArray array) {
        if (array != null) {
            arrays.remove(array);
            Warehouse.getInstance().remove(array.getId());
        }
    }

    @Override
    public void update(CustomArray array) {
        if (array != null) {
            Optional<CustomArray> existing = findById(array.getId());
            existing.ifPresent(arr -> {
                int index = arrays.indexOf(arr);
                arrays.set(index, array);
            });
        }
    }

    @Override
    public Optional<CustomArray> findById(int id) {
        return arrays.stream()
                .filter(array -> array.getId() == id)
                .findFirst();
    }

    @Override
    public List<CustomArray> findAll() {
        return new ArrayList<>(arrays);
    }

    @Override
    public List<CustomArray> findBySpecification(Specification<CustomArray> spec) {
        return arrays.stream()
                .filter(spec::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    @Override
    public void sort(Comparator<CustomArray> comparator) {
        arrays.sort(comparator);
    }
}