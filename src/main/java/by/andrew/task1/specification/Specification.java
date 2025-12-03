package by.andrew.task1.specification;

public interface Specification<T> {
  boolean isSatisfiedBy(T item);
}
