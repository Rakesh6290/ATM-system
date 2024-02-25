package services;

import java.io.*;
// import java.io.File;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import database.Account;
import userInterface.MainClass;

public class Updation {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public void depositAmt(Account currAccount) throws IOException {

    System.out.println("\nEnter amount to deposit:");
    int addAmt = Integer.parseInt(br.readLine());
    int amount = Integer.parseInt(currAccount.accData.get(3));
    amount = amount + addAmt;

    if(Authentication.verifyPin(currAccount))
    {
      writeChanges(currAccount, String.valueOf(amount));
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      Date date = new Date();
      String stmt = new String(
          sdf.format(date) + "\t\tAMOUNT DEPOSITED:Rs." + addAmt + "\t\tAVAILABLE BALANCE:Rs." + amount);
      writeTransaction(currAccount, stmt);
      System.out.println("\nDeposit Successful!!\n");
    }
    
  }

  public void withdrawAmt(Account currAccount) throws IOException {

    System.out.println("\nEnter amount to withdraw:");
    int subAmt = Integer.parseInt(br.readLine());
    int amount = Integer.parseInt(currAccount.accData.get(3));

    if(Authentication.verifyPin(currAccount))
    {
      if (amount < subAmt)
        System.out.println("\nINSUFFICIENT FUNDS!!\n");
      else
      {
        amount = amount - subAmt;
        writeChanges(currAccount, String.valueOf(amount));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String stmt = new String(
            sdf.format(date) + "\t\tAMOUNT WITHDRAWN:Rs." + subAmt + "\t\tAVAILABLE BALANCE:Rs." + amount);
        writeTransaction(currAccount, stmt);
        System.out.println("\nWithdrawl Successful!!\n");
      }
    }
      
  }

  public static void writeChanges(Account currAccount, String s) throws IOException {
    currAccount.accData.set(3, s);
    FileWriter fw = new FileWriter(new File(MainClass.path + currAccount.accData.get(1) + ".txt"));
    for (int i = 0; i < currAccount.accData.size(); i++)
      fw.write(currAccount.accData.get(i) + "\n");
    fw.close();
  }

  public static void writeTransaction(Account currAccount, String trSummary) throws IOException {
    FileWriter fw = new FileWriter(new File(MainClass.path + currAccount.accData.get(1) + ".txt"), true);
    fw.write(trSummary + "\n");
    fw.close();
  }

}
