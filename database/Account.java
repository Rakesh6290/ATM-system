package database;

import java.io.*;
import java.util.*;

import userInterface.MainClass;

public class Account {
  public ArrayList<String> accData = new ArrayList<String>();

  public void fetchAccount(String str) throws IOException {

    String fileName = new String(MainClass.path + str + ".txt");
    File customer = new File(fileName);
    BufferedReader br = new BufferedReader(new FileReader(customer));
    String line = br.readLine();

    while (line != null) {
      accData.add(line);
      line = br.readLine();
    }

    // System.out.println(accData);
    br.close();
  }

}
