package com.greenfox.fox.Enum;

import org.apache.commons.lang3.text.WordUtils;

public enum Food {
  BREAD, STEAK, RAT_POISON, POISONED_RAT, SUNFLOWER_SEEDS, PHO, OYSTER, AIR, GARLIC;

  @Override
  public String toString() {
    return WordUtils.capitalize(name().toLowerCase().replace("_"," "));
  }
}
