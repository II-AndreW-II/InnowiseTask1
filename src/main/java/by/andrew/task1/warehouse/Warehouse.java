package by.andrew.task1.warehouse;

import by.andrew.task1.entity.CustomSummaryStatistic;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
  private static Warehouse instance;

  private final Map<Integer, CustomSummaryStatistic> statisticMap = new HashMap<>();

  private Warehouse() {
  }

  public static Warehouse getInstance() {
    if (instance == null) {
      instance = new Warehouse();
    }
    return instance;
  }

  public CustomSummaryStatistic getCustomSummeryStatisticById(int id) {
    return statisticMap.get(id);
  }

  public CustomSummaryStatistic put(int id, CustomSummaryStatistic customSummaryStatistic) {
    return statisticMap.put(id, customSummaryStatistic);
  }

  public CustomSummaryStatistic remove(int id) {
    return statisticMap.remove(id);
}
}