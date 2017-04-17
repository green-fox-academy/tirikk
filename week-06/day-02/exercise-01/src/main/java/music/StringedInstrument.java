package main.java.music;

abstract class StringedInstrument extends Instrument {
  int numberOfStrings;
  final String FORMAT_FOR_PLAY = "%s, a %d-stringed instrument that '%s'-s\n";
}
