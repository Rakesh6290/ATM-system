package services;
// import database.*;

// import bank.*;

import java.io.*;
// import java.util.Scanner;

import database.Account;
import userInterface.MainClass;

public class Authentication {
    static BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

    public Account authenticate() throws IOException {
        // Scanner sc= new Scanner(System.in);

        int chances = 2;

        System.out.println("\nEnter user name:");
        String userName = sc.readLine();

        String fileName = new String(MainClass.path + userName + ".txt");
        File user = new File(fileName);
        // System.out.println(user.exists());

        while (!user.exists()) {
            System.out.println("Enter a valid user name (enter e to exit):");
            userName = sc.readLine();

            if (userName.equals("e"))
                MainClass.endSession("UNAUTHORIZED LOGIN ATTEMPT!!");

            fileName = new String(MainClass.path + userName + ".txt");
            user = new File(fileName);
        }

        BufferedReader readPswd = new BufferedReader(new FileReader(user));
        String Pswd = readPswd.readLine();

        System.out.println("Enter password:");
        String inputPswd = sc.readLine();

        while (chances > 0 && !Pswd.equals(inputPswd)) {
            System.out.println("Wrong password (" + chances-- + ") attempt(s) remaining!!");
            System.out.println("Enter password:");
            inputPswd = sc.readLine();
        }
        readPswd.close();

        if (chances == 0)
            MainClass.endSession("UNAUTHORIZED LOGIN ATTEMPT!!");

        Account acc = new Account();
        acc.fetchAccount(userName);
        System.out.println("\nLOGIN SUCCESSFUL!!\n");
        return acc;
    }

    public static boolean verifyPin(Account ca) throws IOException {
        // Account acc =new Account();
        String inputPin;
        System.out.print("Enter your pin:");
        inputPin = sc.readLine();
        String accPin = ca.accData.get(2);
        if (!(inputPin.equals(accPin)))
        {
            System.out.println("\nINVALID ACCESS ATTEMPT (WRONG PIN)\n");
            return false;
        }
        else return true;
            
            
    }

}
