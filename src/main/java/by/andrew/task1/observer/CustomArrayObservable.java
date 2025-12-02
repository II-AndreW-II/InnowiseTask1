package by.andrew.task1.observer;

import by.andrew.task1.exception.CustomArrayException;

public interface CustomArrayObservable {
  void attach(CustomArrayObserver observer);

  void detach(CustomArrayObserver observer);

  void notifyObserver() throws CustomArrayException;
}