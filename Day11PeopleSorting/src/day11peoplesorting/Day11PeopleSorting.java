/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day11peoplesorting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author 0639300
 */
class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("Name must have a length greater than 2");
        }
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
    }

    public String toString() {
        String result = " " + getName() + " " + getAge();
        return result;
    }

    @Override
    public int compareTo(Person o) {

        return this.name.compareTo(o.getName());

    }
}

class CompareByPersonByAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int personAge1 = o1.getAge();
        int personAge2 = o2.getAge();

        return personAge1 - personAge2;
    }

}
/*
class ComparePersonByHeigh implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        // floating point values comparison must be done this way
        if (o1.heighMeters > o2.heighMeters) {
            return 1;
        }
        if (o1.heighMeters < o2.heighMeters) {
            return -1;
        }
        return 0;
    }

}*/
class CompareByPersonByNameAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int result = o1.getName().compareTo(o2.getName());
        if(result != 0)
        {
            return result;
        }
        else{
            return o1.getAge() - o2.getAge();
        }
    }

}

public class Day11PeopleSorting {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Person> people = new ArrayList<>();

    @SuppressWarnings("finally")
    public static void main(String[] args) {

        // File to read
        try (Scanner fileInput = new Scanner(new File("people.txt"))) {
            while (fileInput.hasNextLine()) {

                try {
                    String name = fileInput.next();
                    int age = fileInput.nextInt();
                    Person e = new Person(name, age);
                    people.add(e);
                } catch (IllegalArgumentException | InputMismatchException ex) {
                    System.out.println("Argument invalid: " + ex.getMessage());

                }

            }

        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }

        //System.out.println(people);
        System.out.println("===============UNSORTED===============");
        for (Person P : people) {
            System.out.println(P);
        }
        
        Collections.sort(people);
        System.out.println("===============SORTED BY NAME=========");
        for (Person P : people) {
            System.out.println(P);
        }
        Collections.sort(people, new CompareByPersonByNameAge());
        System.out.println("===============SORTED BY NAME AGE=========");
        for (Person P : people) {
            System.out.println(P);
        }
        Collections.sort(people, new CompareByPersonByAge());
        System.out.println("===============SORTED BY AGE=========");
        for (Person P : people) {
            System.out.println(P);
        }
        

    }

}
