/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02peoplefromfile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 0639300
 */
public class Day02PeopleFromFile {

	static ArrayList<Person> people = new ArrayList<>();

	public static void main(String[] args) {

		// File to read
		try (Scanner fileInput = new Scanner(new File("people.txt"))) {
			while (fileInput.hasNextLine()) {
				String name = fileInput.next();
				int age = fileInput.nextInt();
				try {
					Person e = new Person(name, age);
					people.add(e);
				} catch (IllegalArgumentException ex) {
					System.out.println("Argument invalid: " + ex.getMessage());
				}
 
			}

		} catch (IOException ex) {
			System.out.println("Error reading from file: " + ex.getMessage());
		}

		System.out.println(people);

	}

}
