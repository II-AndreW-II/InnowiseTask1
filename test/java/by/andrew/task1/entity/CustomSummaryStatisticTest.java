package by.andrew.task1.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSummaryStatisticTest {
  private static final long TEST_SUM = 15L;
  private static final int TEST_MAX = 5;
  private static final int TEST_MIN = 1;

  @Test
  void testConstructorAndGetters() {
    CustomSummaryStatistic statistic = new CustomSummaryStatistic(TEST_SUM, TEST_MAX, TEST_MIN);
    
    assertEquals(TEST_SUM, statistic.getSum());
    assertEquals(TEST_MAX, statistic.getMax());
    assertEquals(TEST_MIN, statistic.getMin());
  }

  @Test
  void testSetters() {
    CustomSummaryStatistic statistic = new CustomSummaryStatistic(0L, 0, 0);
    
    statistic.setSum(TEST_SUM);
    statistic.setMax(TEST_MAX);
    statistic.setMin(TEST_MIN);
    
    assertEquals(TEST_SUM, statistic.getSum());
    assertEquals(TEST_MAX, statistic.getMax());
    assertEquals(TEST_MIN, statistic.getMin());
  }
}
