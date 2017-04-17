package main.java.music;

public class BassGuitar extends StringedInstrument {
  String sound;

  public BassGuitar() {
    name = "BassGuitar";
    numberOfStrings = 4;
    sound = "Duum-duum-duum";
  }

  public BassGuitar(int i) {
    name = "BassGuitar";
    numberOfStrings = i;
    sound = "Duum-duum-duum";
  }

  public void play() {
    System.out.printf(FORMAT_FOR_PLAY, name, numberOfStrings, sound);
  }
}
