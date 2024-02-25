package userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import database.Account;
import services.Enquiry;
import services.Transfer;
import services.Updation;


public class UserFunctions {
  public void services(Account currAccount) throws IOException {
    do{
      System.out.print("\n1.Enquiry\n2.Withdraw\n3.Deposit\n4.Transfer\n(Anything else to Logout)\nEnter option:");
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String ch = br.readLine();

      if(ch.equals("1"))
      {
        Enquiry enq = new Enquiry();
        enq.display(currAccount);
      }

      else if(ch.equals("2"))
      {
        Updation up = new Updation();
        up.withdrawAmt(currAccount);
      }

      else if(ch.equals("3"))
      {
        Updation upd = new Updation();
        upd.depositAmt(currAccount);
      }

      else if(ch.equals("4"))
      {
        Transfer transfer = new Transfer();
        transfer.transferAmount(currAccount);
      }
      else 
      {
        System.out.println("LOGOUT BY USER");
        break;
      }
        
    }while(true);
    
  }
}
