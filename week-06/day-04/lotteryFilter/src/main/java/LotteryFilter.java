import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class LotteryFilter {
  List<String[]> lines;

  void readFromFile() {
    try {
      CSVReader reader = new CSVReader(new FileReader("assets/otos.csv"), ';');
      lines = reader.readAll();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  void writeToFile(String path) {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter("path"), ';', CSVWriter.NO_QUOTE_CHARACTER);
      writer.writeAll(lines);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
