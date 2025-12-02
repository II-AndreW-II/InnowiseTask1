package by.andrew.task1.entity;

import java.util.Arrays;
import java.util.Random;

import by.andrew.task1.exception.CustomArrayException;
import by.andrew.task1.observer.CustomArrayEvent;
import by.andrew.task1.observer.CustomArrayObserver;
import by.andrew.task1.observer.CustomArrayObservable;
import by.andrew.task1.observer.impl.CustomArrayObserverImpl;

public class CustomArray implements CustomArrayObservable {
  private final int id;
  private int[] array;
  private CustomArrayObserver observer;

  public CustomArray(int[] array) throws CustomArrayException {
    this.array = array != null ? array.clone() : new int[0];
    this.id = getRandomId();
    attach(new CustomArrayObserverImpl());
    notifyObserver();
  }

  public int getId() {
    return id;
  }

  public int[] getArray() {
    return array.clone();
  }

  public void setArray(int[] array) throws CustomArrayException {
    this.array = array != null ? array.clone() : new int[0];
    notifyObserver();
  }

  public int length() {
    return array.length;
  }

  private int getRandomId() {
    Random random = new Random();
    return random.nextInt();
  }

  @Override
  public void attach(CustomArrayObserver observer) {
    this.observer = observer;
  }

  @Override
  public void detach(CustomArrayObserver observer) {
    if (this.observer != null && this.observer.equals(observer)) {
      this.observer = null;
    }
  }

  @Override
  public void notifyObserver() throws CustomArrayException {
    if (observer != null) {
      observer.actionPerformed(new CustomArrayEvent(this));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomArray that = (CustomArray) o;
    return Arrays.equals(array, that.array);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(array);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("CustomArray{");
    sb.append("id=").append(id);
    sb.append(", array=").append(Arrays.toString(array));
    sb.append('}');
    return sb.toString();
  }
}
