package by.andrew.task1.observer;

import by.andrew.task1.exception.CustomArrayException;

public interface CustomArrayObserver {
  void actionPerformed(CustomArrayEvent event) throws CustomArrayException;
}