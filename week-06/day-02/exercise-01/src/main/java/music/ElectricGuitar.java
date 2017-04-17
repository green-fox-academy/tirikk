package main.java.music;

public class ElectricGuitar extends StringedInstrument{
  String sound;

  public ElectricGuitar() {
    name = "ElectricGuitar";
    numberOfStrings = 6;
    sound = "Twang";
  }

  public ElectricGuitar(int i) {
    name = "ElectricGuitar";
    numberOfStrings = i;
    sound = "Twang";
  }

  public void play() {
    System.out.printf(FORMAT_FOR_PLAY, name, numberOfStrings, sound);
  }
}
