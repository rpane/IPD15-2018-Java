package quiz1airporttravel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author 0639300
 */
public class Quiz1AirportTravel {

    static final String FILE_NAME = "airports.txt";
    static Scanner input = new Scanner(System.in);
    static ArrayList<Airport> airportList = new ArrayList<>();

    public static void readData() throws InvalidDataException {

        try (Scanner fileInput = new Scanner(new File(FILE_NAME))) {
            while (fileInput.hasNextLine()) {

                String line = fileInput.nextLine();
                String[] data = line.split(";");

                String code = data[0];
                String city = data[1];
                try {
                    double latitude = Double.parseDouble(data[2]);
                    double longitude = Double.parseDouble(data[3]);
                    Airport e = new Airport(code, city, latitude, longitude);
                    airportList.add(e);
                } catch (NumberFormatException ex) {
                    System.out.println("Error. " + ex.getMessage());
                }

            }
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }

    }

    private static void saveData() {
        try (PrintWriter outputFile = new PrintWriter(FILE_NAME)) {
            for (int i = 0; i < airportList.size(); i++) {
                outputFile.println(airportList.get(i).getCode() + ";" + airportList.get(i).getCity() + ";"
                        + airportList.get(i).getLatitude() + ";" + airportList.get(i).getLongitude());
            }
            outputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error. "+e.getMessage());            
        }
    }

    public static void main(String[] args) throws InvalidDataException {
        readData();
        try {
            while (true) {
                displayMenu();
                int choice = getMenuChoice();
                switch (choice) {
                    case 1:
                        listAllAirports();
                        break;
                    case 2:
                        distanceBetween();
                        break;
                    case 3:
                        nearestAirport();
                        break;
                    case 4:
                        addAirport();
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
        System.out.println("1. Show all airports (codes and city names)\n"
                + "2. Find distance between two airports by codes.\n"
                + "3. Find the airports nearest to an airport given by code and display the distance.\n"
                + "4. Add a new airport to the list.\n"
                + "0. Exit.");
    }

    private static int getMenuChoice() {
        while (true) {
            try {
                int choice = input.nextInt();
                input.nextLine();
                if (choice < 0 || choice > 4) {
                    System.out.println("Choice is out of range. Try again");
                    choice = input.nextInt();

                }
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Error. Non-number recognized");
                input.nextLine();
            }
        }
    }

    private static void listAllAirports() {
        for (Airport e : airportList) {
            System.out.println(e.getCode() + " " + e.getCity());
        }
    }

    private static void distanceBetween() {
        System.out.println("Please enter first airport code:");
        String airOne = input.nextLine();
        System.out.println("Please enter second airport code:");
        String airTwo = input.nextLine();
        double cordx1 = 0, cordx2 = 0, cordy1 = 0, cordy2 = 0, distance;
        for (int i = 0; i < airportList.size(); i++) {
            if (airportList.get(i).getCode().equalsIgnoreCase(airOne)) {
                cordy1 = airportList.get(i).getLatitude();
                cordx1 = airportList.get(i).getLongitude();
            }
            if (airportList.get(i).getCode().equalsIgnoreCase(airTwo)) {
                cordy2 = airportList.get(i).getLatitude();
                cordx2 = airportList.get(i).getLongitude();
            }
        }
        distance = Math.sqrt((cordx2 - cordx1) * (cordx2 - cordx1) + (cordy2 - cordy1) * (cordy2 - cordy1));
        System.out.println("Distance between locations is " + distance);

    }

    private static void nearestAirport() {
        System.out.println("Please enter Airport Code:");
        String code = input.nextLine();
        int indexFound=1; //Random number to intialize
        double [] nearestDist = new double [airportList.size()];
        for(int i =0;i<airportList.size();i++)
        {
            if(code.equalsIgnoreCase(airportList.get(i).getCode()))
            {
                indexFound = i;
            }
        }
        
        for(int i =0;i<airportList.size();i++)
        {           
         
            double cordx1, cordx2, cordy1,cordy2,distance;
            
           cordy1 = airportList.get(indexFound).getLatitude();
           cordx1 = airportList.get(indexFound).getLongitude();
           
           cordy2= airportList.get(i).getLatitude();
           cordx2= airportList.get(i).getLongitude();
           distance = Math.sqrt((cordx2 - cordx1) * (cordx2 - cordx1) + (cordy2 - cordy1) * (cordy2 - cordy1));
                      
           nearestDist[i] = distance;
            
            
        }
        
        double minVal = nearestDist[0];
        int foundIndex =0;
        for(int i =1;i<nearestDist.length;i++)
        {
            if(nearestDist[i]==0)
            {
                continue;
            }
            if(nearestDist[i] <minVal){
                minVal=nearestDist[i];
                foundIndex = i;
            }
        }
        System.out.println("Closest Airport is "+airportList.get(foundIndex).getCity()+" at a distance of "+minVal);
        
    }

    private static void addAirport() throws InvalidDataException {
        System.out.print("Enter Code:");
        String code = input.nextLine();
        System.out.print("Enter City:");
        String city = input.nextLine();

        System.out.print("Enter Latitude:");
        Double latitude = Double.parseDouble(input.nextLine());
        System.out.print("Enter Longitude:");
        Double longitude = Double.parseDouble(input.nextLine());

        Airport g = new Airport(code, city, latitude, longitude);
        airportList.add(g);
    }

}
