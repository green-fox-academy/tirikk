package main.java.music;

public class Violin extends StringedInstrument {
  String sound = "Screech";

  public Violin() {
    name = "Violin";
    numberOfStrings = 4;
  }

  public Violin(int i) {
    name = "Violin";
    numberOfStrings = i;
  }

  public void play() {
    System.out.printf(FORMAT_FOR_PLAY, name, numberOfStrings, sound);
  }
}
