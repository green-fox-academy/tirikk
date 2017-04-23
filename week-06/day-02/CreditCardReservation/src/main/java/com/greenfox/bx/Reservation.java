package com.greenfox.bx;

public class Reservation implements Reservationy {
  private StringBuilder code = new StringBuilder();
  private String dow;

  public Reservation() {
    generateCode();
    generateDow();
  }

  private void generateCode() {
    String allChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    for (int i = 0; i < 8; i++) {
      code.append(allChars.charAt((int) (Math.random() * allChars.length())));
    }
  }

  private void generateDow() {
    String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    dow = days[(int) (Math.random() * 7)];
  }

  @Override
  public String getDowBooking() {
    return dow;
  }

  @Override
  public String getCodeBooking() {
    return code.toString();
  }

  @Override
  public String toString() {
    return String.format("Booking# %s for %s", code, dow);
  }
}
