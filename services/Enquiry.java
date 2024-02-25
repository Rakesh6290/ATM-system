package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import database.Account;
// import userInterface.MainClass;

// import database.*;

public class Enquiry {

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public void display(Account currAccount) throws IOException {
    do{
      System.out.print("\n1.Balance Enquiry\n2.Display Transactions\nAnything else to return to previous menu\nEnter option:");
      String ch = br.readLine();

    
      if (ch.equals("1")) {
        if(Authentication.verifyPin(currAccount))
          getBalance(currAccount);
        else break;
      } 

      else if (ch.equals("2")) {
        if(Authentication.verifyPin(currAccount))
          getStatements(currAccount);
        else break;
      } 

      else{
        break;
      }

    }while(true); 
  }

  public void getBalance(Account ca) throws IOException {
    // Account acc =new Account();
    System.out.println("\nCURRENT BALANCE:Rs." + ca.accData.get(3) + "\n");
    
  }

  public void getStatements(Account ca) throws IOException {
    // Account acc =new Account();
    if (ca.accData.size() == 4)
      System.out.println("\nNO TRANSACTIONS!!\n");

    else{
      for (int i = 4; i < ca.accData.size(); i++) {
       System.out.println("\n" + (i - 3) + ". " + ca.accData.get(i));
    }
    System.out.println("\nTransaction Log End\n");
    }
    
  
  }
}
