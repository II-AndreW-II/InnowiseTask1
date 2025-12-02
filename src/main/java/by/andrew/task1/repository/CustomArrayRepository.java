package by.andrew.task1.repository;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.specification.Specification;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface CustomArrayRepository {
  void add(CustomArray array);
  void remove(CustomArray array);
  void update(CustomArray array);
  Optional<CustomArray> findById(int id);
  List<CustomArray> findAll();
  List<CustomArray> findBySpecification(Specification<CustomArray> spec);
  void sort(Comparator<CustomArray> comparator);
}