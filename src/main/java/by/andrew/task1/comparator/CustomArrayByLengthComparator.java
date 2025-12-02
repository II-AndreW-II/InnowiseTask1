package by.andrew.task1.comparator;

import by.andrew.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayByLengthComparator implements Comparator<CustomArray> {
  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    return o1.getArray().length - o2.getArray().length;
  }
}