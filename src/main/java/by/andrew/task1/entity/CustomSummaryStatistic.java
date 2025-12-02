package by.andrew.task1.entity;

public class CustomSummaryStatistic {
  private long sum;
  private int max;
  private int min;

  public CustomSummaryStatistic(long sum, int max, int min) {
		this.sum = sum;
    this.max = max;
    this.min = min;
  }

  public long getSum() {
    return sum;
  }

  public void setSum(long sum) {
    this.sum = sum;
  }

  public int getMax() {
    return max;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public int getMin() {
    return min;
  }

  public void setMin(int min) {
    this.min = min;
  }
}