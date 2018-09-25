/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day03tempworkers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
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
				Worker e = new Worker(name, startDate, endDate);
				personel.add(e);
			}
		} catch (IOException ex) {
			System.out.println("Error reading from file: " + ex.getMessage());
		}

	}

	public static void saveData() {
		try (PrintWriter outputFile = new PrintWriter("data2.txt")) {
			for (int i = 0; i < personel.size(); i++) {
				outputFile.println(personel.get(i).getName() + ";" + personel.get(i).getStartDate() + ";"
						+ personel.get(i).getEndDate());
			}
			outputFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		System.out.println("1. List all personel\n" + "2. Find out who works on a specific date\n"
				+ "3. Ask for a year number and print out all dates\n"
				+ "in that year that nobody is scheduled to work on\n" + "4. Add worker\n"
				+ "5. Delete worker by name\n" + "0. Exit");
	}

	private static int getMenuChoice() {
		while (true) {
			// what if user enters non-number?
			// what if number is not within range 0-5 ? - try again
			try {
				int choice = input.nextInt();
				input.nextLine();
				if (choice < 0 | choice > 5) {
					System.out.println("Choice is out of range. Try again");
					choice = input.nextInt();
					input.nextLine();
				}
				return choice;
			} catch (InputMismatchException e) {
				System.out.println("Error. Non-number recognized");

			}

			// if (choice is not 0-5) then ask user for input again
			// if it is valid => then return choice
		}
	}

	private static void listAllPersonel() {

		for (Worker p : personel)
			System.out.println(p);

	}

	private static void whoWorksOnDate() {
		System.out.print("Enter Date:");
		Date check = new Date();
		try {
			check = dateFormat.parse(input.next());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < personel.size(); i++) {
			if (check.after(personel.get(i).getStartDate()) && check.before(personel.get(i).getEndDate())) {
				System.out.println(personel.get(i).getName() + " works");
			}
		}
	}

	private static void unmannedDaysInYear() {
		System.out.print("Enter year:");
		int year = input.nextInt();
		Calendar cal = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		for (int i = 0; i < personel.size(); i++) {
			cal.setTime(personel.get(i).getStartDate());
			int yearStart = cal.get(Calendar.YEAR);
			cal2.setTime(personel.get(i).getEndDate());
			int yearEnd = cal2.get(Calendar.YEAR);
			if (yearStart != year && yearEnd != year) {
				System.out.println("No one is scheduled to work yet in " + year);
				break;
			} else {
				System.out.println(personel.get(i).getName() + " works");
			}
		}
	}

	private static void addWorker() {
		System.out.print("Enter name:");
		String name = input.nextLine();
		System.out.print("Enter Start Date:");
		Date startDate = new Date();
		Date endDate = new Date();
		try {
			startDate = dateFormat.parse(input.nextLine());
			System.out.print("Enter End Date:");
			endDate = dateFormat.parse(input.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Worker g = new Worker(name, startDate, endDate);
		personel.add(g);
	}

	private static void deleteWorker() {
		System.out.print("Enter name:");
		String delName = input.nextLine();
		for (int i = 0; i < personel.size(); i++) {
			if (personel.get(i).getName().equals(delName)) {
				personel.remove(i);
			}
		}
	}

}
