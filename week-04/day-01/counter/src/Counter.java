public class Counter {
  int value;
  int initValue;

  public Counter() {
    value = 0;
    initValue = 0;
  }

  public Counter(int i) {
    value = i;
    initValue = i;
  }

  public void add() {
    value++;
  }

  public void add(int i) {
    value = value + i;
  }

  public int get() {
    return value;
  }

  public void reset() {
    value = initValue;
  }
}
