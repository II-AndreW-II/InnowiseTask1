package by.andrew.task1.observer;

import by.andrew.task1.entity.CustomArray;

import java.util.EventObject;

public class CustomArrayEvent extends EventObject {

  public CustomArrayEvent(CustomArray source) {
    super(source);
  }

  @Override
  public CustomArray getSource() {
    return (CustomArray) super.getSource();
  }
}