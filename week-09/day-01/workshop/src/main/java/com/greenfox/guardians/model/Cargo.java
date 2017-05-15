package com.greenfox.guardians.model;

import org.springframework.stereotype.Service;

@Service
public class Cargo {
  int caliber25 = 0;
  int caliber30 = 0;
  int caliber50 = 0;
  String shipstatus = "empty";
  boolean ready = false;

  public Cargo() {
  }

  public int getCaliber25() {
    return caliber25;
  }

  public int getCaliber30() {
    return caliber30;
  }

  public int getCaliber50() {
    return caliber50;
  }

  public String getShipstatus() {
    return shipstatus;
  }

  public boolean isReady() {
    return ready;
  }

  public void setCaliber25(int caliber25) {
    this.caliber25 = caliber25;
  }

  public void setCaliber30(int caliber30) {
    this.caliber30 = caliber30;
  }

  public void setCaliber50(int caliber50) {
    this.caliber50 = caliber50;
  }

  public void setShipstatus(String shipstatus) {
    this.shipstatus = shipstatus;
  }

  public void setReady(boolean ready) {
    this.ready = ready;
  }

  public void addAmmo(String caliber, int amount) {
    if (caliber.equals(".50")) {
      caliber50 += amount;
    } else if (caliber.equals(".25")) {
      caliber25 += amount;
    } else if (caliber.equals(".30")) {
      caliber30 += amount;
    }
    if (caliber30 + caliber50 + caliber25 == 12500) {
      shipstatus = "full";
    } else if (caliber30 + caliber50 + caliber25 < 12500) {
      double percentage = (double)(caliber25 + caliber50 + caliber30) / 12500.0 * 100.0;
      shipstatus = Integer.toString((int)percentage) + "%";
    } else {
      shipstatus = "overloaded";
    }
    if (shipstatus.equals("full")) {
      ready = true;
    }
  }
}
