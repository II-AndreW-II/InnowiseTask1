package by.andrew.task1.observer.impl;

import by.andrew.task1.entity.CustomArray;
import by.andrew.task1.entity.CustomSummaryStatistic;
import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.observer.CustomArrayEvent;
import by.andrew.task1.observer.CustomArrayObserver;
import by.andrew.task1.service.ArraySumService;
import by.andrew.task1.service.ArrayMinMaxService;
import by.andrew.task1.service.impl.ArraySumServiceImpl;
import by.andrew.task1.service.impl.ArrayMinMaxServiceImpl;
import by.andrew.task1.warehouse.Warehouse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomArrayObserverImpl implements CustomArrayObserver {
  private static final Logger LOGGER = LogManager.getLogger();

  @Override
  public void actionPerformed(CustomArrayEvent event) throws CustomArrayException {
    CustomArray customArray = event.getSource();
    ArrayMinMaxService arrayMinMaxService = new ArrayMinMaxServiceImpl();
    ArraySumService arraySumService = new ArraySumServiceImpl();
    long sum = arraySumService.calculateSum(customArray);
    int max = arrayMinMaxService.findMax(customArray);
    int min = arrayMinMaxService.findMin(customArray);
    CustomSummaryStatistic customSummaryStatistic = new CustomSummaryStatistic(sum, max, min);
    int id = customArray.getId();
    Warehouse.getInstance().put(id, customSummaryStatistic);
    LOGGER.info("Statistics for CustomArray with ID {} have been updated in warehouse", customArray.getId());
  }
}
