public enum CarType {
  AUDI, BMW, MERCEDES, FORD, VOLKSWAGEN, TOYOTA;

  static CarType returnType() {
    return values()[(int)(Math.random() * values().length)];
  }

}
