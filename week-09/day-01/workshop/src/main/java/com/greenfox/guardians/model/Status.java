package com.greenfox.guardians.model;

public class Status {
  String received;
  int amount;
  String shipstatus;
  boolean ready = false;

  public Status() {
  }

  public Status(String received, int amount) {
    this.received = received;
    this.amount = amount;
  }

  public String getReceived() {
    return received;
  }

  public int getAmount() {
    return amount;
  }

  public String getShipstatus() {
    return shipstatus;
  }

  public boolean isReady() {
    return ready;
  }

  public void setReceived(String received) {
    this.received = received;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void setShipstatus(String shipstatus) {
    this.shipstatus = shipstatus;
  }

  public void setReady(boolean ready) {
    this.ready = ready;
  }
}
