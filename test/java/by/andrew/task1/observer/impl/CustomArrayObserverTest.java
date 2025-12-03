package by.andrew.task1.observer.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.entity.CustomSummaryStatistic;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.observer.CustomArrayEvent;
import by.andrew.task1.warehouse.Warehouse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayObserverImplTest {

  @Test
  void testActionPerformedUpdatesWarehouse() throws CustomArrayException {
    CustomArrayObserverImpl observer = new CustomArrayObserverImpl();
    CustomArray array = new CustomArray(new int[]{1, 2, 3});
    CustomArrayEvent event = new CustomArrayEvent(array);
    
    observer.actionPerformed(event);
    
    Warehouse warehouse = Warehouse.getInstance();
    CustomSummaryStatistic statistic = warehouse.getCustomSummeryStatisticById(array.getId());
    
    assertNotNull(statistic);
    assertEquals(6L, statistic.getSum());
    assertEquals(3, statistic.getMax());
    assertEquals(1, statistic.getMin());
    
    warehouse.remove(array.getId());
  }
}
