/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03tempworkers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * @author 0639300
 */
public class Day03TempWorkers {

    static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    /**
     * @param args the command line arguments
     */
    public static void readData() {

        try (Scanner fileInput = new Scanner(new File("data.txt"))) {
            while (fileInput.hasNextLine()) {
                String line = fileInput.nextLine();
                String[] data = line.split(";");
                Date startDate = new Date();
                Date endDate = new Date();
                try {
                    startDate = dateFormat.parse(data[1]);                    
                    endDate = dateFormat.parse(data[2]);
                } catch (ParseException e) {
                    System.out.println("Error Parsing Date from line");
                }
                String name = data[0];
                Worker e = new Worker(name,startDate,endDate);
                personel.add(e);
            }
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }

    }

    public static void saveData() {

    }
    static Scanner input = new Scanner(System.in);
    static ArrayList<Worker> personel = new ArrayList<>();

    public static void main(String[] args) {

        readData();
        try {
            while (true) {
                displayMenu();
                int choice = getMenuChoice();
                switch (choice) {
                    case 1:
                        listAllPersonel();
                        break;
                    case 2:
                        whoWorksOnDate();
                        break;
                    case 3:
                        unmannedDaysInYear();
                        break;
                    case 4:
                        addWorker();
                        break;
                    case 5:
                        deleteWorker();
                        break;
                    case 0:
                        System.out.println("Exiting.");
                        return;
                    default:
                        System.out.println("Fatal error. Saving data and exiting.");
                        return;
                }
            }
        } finally {
            saveData();
        }
    }

    private static void displayMenu() {
        System.out.println("1. List all personel\n"
                + "2. Find out who works on a specific date\n"
                + "3. Ask for a year number and print out all dates\n"
                + "in that year that nobody is scheduled to work on\n"
                + "4. Add worker\n"
                + "5. Delete worker by name\n"
                + "0. Exit");
    }

    private static int getMenuChoice() {
        while (true) {
            // what if user enters non-number?
            // what if number is not within range 0-5 ? - try again
            try{
            int choice = input.nextInt();
            input.nextLine();
            if(choice <0 | choice >5)
            {
                System.out.println("Choice is out of range. Try again");
                choice = input.nextInt();
                input.nextLine();
            }
            return choice;
            }catch (InputMismatchException e){
                System.out.println("Error. Non-number recognized");
                
            }
           
            // if (choice is not 0-5) then ask user for input again
            //if it is valid => then return choice
        }
    }

    private static void listAllPersonel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void whoWorksOnDate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void unmannedDaysInYear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void addWorker() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void deleteWorker() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
