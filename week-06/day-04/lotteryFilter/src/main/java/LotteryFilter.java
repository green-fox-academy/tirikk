import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LotteryFilter {
  private List<String[]> lines;
  private List<String[]> filteredLines = new ArrayList<String[]>();
  private String source = "assets/otos.csv";
  private String destination = "assets/output.csv";

  void checkArguments(String[] args) {
    OptionParser parser = new OptionParser();
    parser.accepts("y").withRequiredArg();
    parser.accepts("f").withRequiredArg();
    parser.accepts("o").withRequiredArg();
    OptionSet options = parser.parse(args);

    if (options.has("y")) {
      if (options.has("f")) {
        source = options.valueOf("f").toString();
      }
      if (options.has("o")) {
        destination = options.valueOf("o").toString();
      }
      readFromFile();
      filterLines(options.valueOf("y").toString());
      writeToFile();
    } else {
      System.out.println("No year provided to filter by");
    }
  }

  private void filterLines(String year) {
    for (String[] line : lines) {
      if (line[0].equals(year)) {
        filteredLines.add(line);
      }
    }
  }

  private void readFromFile() {
    try {
      CSVReader reader = new CSVReader(new FileReader(source), ';');
      lines = reader.readAll();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeToFile() {
    try {
      CSVWriter writer = new CSVWriter(new FileWriter(destination), ';', CSVWriter.NO_QUOTE_CHARACTER);
      writer.writeAll(filteredLines);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
