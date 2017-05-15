package com.greenfox.guardians.model;

public class Arrow {
  long distance;
  long time;
  long speed;

  public Arrow() {
  }

  public Arrow(long distance, long time) {
    this.distance = distance;
    this.time = time;
    speed = distance / time;
  }

  public long getDistance() {
    return distance;
  }

  public long getTime() {
    return time;
  }

  public long getSpeed() {
    return speed;
  }

  public void setDistance(long distance) {
    this.distance = distance;
  }

  public void setTime(long time) {
    this.time = time;
  }

  public void setSpeed(long speed) {
    this.speed = speed;
  }
}
