package by.andrew.task1.specification.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.service.ArrayMinMaxService;
import by.andrew.task1.service.impl.ArrayMinMaxServiceImpl;
import by.andrew.task1.specification.Specification;

public class MinGreaterThanSpecification implements Specification<CustomArray> {
  private final int value;
  private final ArrayMinMaxService minMaxService = new ArrayMinMaxServiceImpl();

  public MinGreaterThanSpecification(int value) {
    this.value = value;
  }

  @Override
  public boolean isSatisfiedBy(CustomArray array) {
    try {
      return minMaxService.findMin(array) > value;
    } catch (CustomArrayException e) {
      return false;
    }
  }
}
