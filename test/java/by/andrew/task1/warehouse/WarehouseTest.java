package by.andrew.task1.warehouse;

import by.andrew.task1.entity.CustomSummaryStatistic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {
  private static final int TEST_ID_1 = 1001;
  private static final int TEST_ID_2 = 1002;
  private static final long TEST_SUM = 15L;
  private static final int TEST_MAX = 5;
  private static final int TEST_MIN = 1;

  @AfterEach
  void tearDown() {
    Warehouse warehouse = Warehouse.getInstance();
    warehouse.getAllStatistics().keySet().forEach(warehouse::remove);
  }

  @Test
  void testGetInstanceReturnsSameInstance() {
    Warehouse instance1 = Warehouse.getInstance();
    Warehouse instance2 = Warehouse.getInstance();
    assertSame(instance1, instance2);
  }

  @Test
  void testPutAndGetStatistic() {
    Warehouse warehouse = Warehouse.getInstance();
    CustomSummaryStatistic statistic = new CustomSummaryStatistic(TEST_SUM, TEST_MAX, TEST_MIN);
    
    warehouse.put(TEST_ID_1, statistic);
    CustomSummaryStatistic retrieved = warehouse.getCustomSummeryStatisticById(TEST_ID_1);
    
    assertNotNull(retrieved);
    assertEquals(TEST_SUM, retrieved.getSum());
    assertEquals(TEST_MAX, retrieved.getMax());
    assertEquals(TEST_MIN, retrieved.getMin());
  }

  @Test
  void testRemoveStatistic() {
    Warehouse warehouse = Warehouse.getInstance();
    CustomSummaryStatistic statistic = new CustomSummaryStatistic(TEST_SUM, TEST_MAX, TEST_MIN);
    
    warehouse.put(TEST_ID_1, statistic);
    CustomSummaryStatistic removed = warehouse.remove(TEST_ID_1);
    
    assertNotNull(removed);
    assertEquals(TEST_SUM, removed.getSum());
    assertNull(warehouse.getCustomSummeryStatisticById(TEST_ID_1));
  }

  @Test
  void testGetAllStatistics() {
    Warehouse warehouse = Warehouse.getInstance();
    CustomSummaryStatistic statistic1 = new CustomSummaryStatistic(TEST_SUM, TEST_MAX, TEST_MIN);
    CustomSummaryStatistic statistic2 = new CustomSummaryStatistic(25L, 10, 2);
    
    warehouse.put(TEST_ID_1, statistic1);
    warehouse.put(TEST_ID_2, statistic2);
    
    var allStats = warehouse.getAllStatistics();
    assertEquals(2, allStats.size());
    assertTrue(allStats.containsKey(TEST_ID_1));
    assertTrue(allStats.containsKey(TEST_ID_2));
  }

  @Test
  void testGetNonExistentStatistic() {
    Warehouse warehouse = Warehouse.getInstance();
    CustomSummaryStatistic retrieved = warehouse.getCustomSummeryStatisticById(99999);
    assertNull(retrieved);
  }
}