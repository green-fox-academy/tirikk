package com.greenfox.fox.Enum;

import org.apache.commons.lang3.text.WordUtils;

public enum Drink {
  WHISKEY, WATER, BATTERY_ACID, ANTIFREEZE, COKE, ABSINTHE, BLOOD;

  @Override
  public String toString() {
    return WordUtils.capitalize(name().toLowerCase().replace("_"," "));
  }
}
