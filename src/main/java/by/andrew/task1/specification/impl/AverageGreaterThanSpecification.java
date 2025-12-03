package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.service.ArraySumService;
import by.andrew.task1.service.impl.ArraySumServiceImpl;
import by.andrew.task1.specification.Specification;

public class AverageGreaterThanSpecification implements Specification<CustomArray> {
  private final double value;
  private final ArraySumService sumService = new ArraySumServiceImpl();

  public AverageGreaterThanSpecification(double value) {
    this.value = value;
  }

  @Override
  public boolean isSatisfiedBy(CustomArray array) {
    try {
      long sum = sumService.calculateSum(array);
      double average = (double) sum / array.getArray().length;
      return average > value;
    } catch (CustomArrayException e) {
      return false;
    }
  }
}
