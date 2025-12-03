package by.andrew.task1.comparator;

import by.andrew.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayByIdComparator implements Comparator<CustomArray> {
  @Override
  public int compare(CustomArray o1, CustomArray o2) {
    return Integer.compare(o1.getId(), o2.getId());
  }
}
