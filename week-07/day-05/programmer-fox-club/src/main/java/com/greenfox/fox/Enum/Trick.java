package com.greenfox.fox.Enum;

import org.apache.commons.lang3.text.WordUtils;

public enum Trick {
  ROLL, SIT, FETCH, CHASE_TAIL, SAY_RINGDINGDING, STEAL_LIVESTOCK, GIVE_FINGER, CODE;

  @Override
  public String toString() {
    return WordUtils.capitalize(name().toLowerCase().replace("_"," "));
  }
}
