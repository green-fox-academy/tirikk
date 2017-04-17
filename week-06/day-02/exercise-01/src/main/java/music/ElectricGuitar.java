package main.java.music;

public class ElectricGuitar extends StringedInstrument{
  String sound = "Twang";

  public ElectricGuitar() {
    name = "ElectricGuitar";
    numberOfStrings = 6;
  }

  public ElectricGuitar(int i) {
    name = "ElectricGuitar";
    numberOfStrings = i;
  }

  public void play() {
    System.out.printf(FORMAT_FOR_PLAY, name, numberOfStrings, sound);
  }
}
