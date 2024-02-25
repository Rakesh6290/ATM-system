package services;

// import java.util.*;
import java.io.*;

import userInterface.MainClass;

public class CreatingAccount {
    public void create() throws IOException {
        // Scanner sc = new Scanner(System.in);
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("\nEnter user name:");
        String userName = sc.readLine();

        String fileName = new String(MainClass.path + userName + ".txt");
        // System.out.println(fileName);

        File newUser = new File(fileName);
        Boolean exists = newUser.createNewFile();
        while (!exists) {
            System.out.println("Choose another user name:");
            userName = sc.readLine();
            fileName = new String(MainClass.path + userName + ".txt");
            newUser = new File(fileName);
            exists = newUser.createNewFile();
        }
        System.out.println("Enter password:");
        String password = sc.readLine();

        System.out.println("Set PIN:");
        String pin = sc.readLine();

        System.out.println("\nACCOUNT CREATION SUCCESSFUL\n");

        FileWriter writer = new FileWriter(fileName);
        writer.write(password + "\n");
        writer.write(userName + "\n");
        writer.write(pin + "\n");
        writer.write("0\n");
        writer.close();
    }

}
