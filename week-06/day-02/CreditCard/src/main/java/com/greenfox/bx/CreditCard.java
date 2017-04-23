package com.greenfox.bx;

public class CreditCard implements CreditCardy {
  private int sumCVV;
  private String name;
  private StringBuilder code = new StringBuilder();

  public CreditCard(String name) {
    this.name = name;
    generateCode();
    sumCVV = cumeSumCVV(code.toString());
  }

  private void generateCode() {
    for (int i = 0; i < 16; i++) {
      code.append((int) (Math.random() * 10));
    }
  }

  @Override
  public int cumeSumCVV(String codeAccount) {
    int sum = 0;
    for (Character number : codeAccount.toCharArray()) {
      sum += Character.getNumericValue(number);
    }
    return sum;
  }

  @Override
  public int getSumCVV() {
    return sumCVV;
  }

  @Override
  public String getNameCardholder() {
    return name;
  }

  @Override
  public String getCodeAccount() {
    return code.toString();
  }

  @Override
  public String toString() {
    return String.format("Name=%s CC#=%s CVV=%d", name, code, sumCVV);
  }
}
