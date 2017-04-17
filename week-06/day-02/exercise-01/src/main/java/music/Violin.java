package main.java.music;

public class Violin extends StringedInstrument {
  String sound;

  public Violin() {
    name = "Violin";
    numberOfStrings = 4;
    sound = "Screech";
  }

  public Violin(int i) {
    name = "Violin";
    numberOfStrings = i;
    sound = "Screech";
  }

  public void play() {
    System.out.printf(FORMAT_FOR_PLAY, name, numberOfStrings, sound);
  }
}
