/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02peoplefromfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 0639300
 */
public class Day02PeopleFromFile {

   static ArrayList<Person> people = new ArrayList<>();
   
   
    public static void main(String[] args) {
         
        //File to read
        File nameAge = new File("C:\\Users\\0639300\\OneDrive - John Abbott College\\Java 3\\IPD15-2018-Java\\Day02PeopleFromFile");
        try{
        Scanner inputFile = new Scanner(nameAge);
        }catch (FileNotFoundException ex){
            System.out.println("Argument invalid " + ex.getMessage());
        }
        
        while (inputFile.hasNext())
        {
        
        
        
        
        
        try {
            Person p = new Person("", 0);
            p.setAge(-1);
        } catch (IllegalArgumentException ex) {
            System.out.println("Argument invalid: " + ex.getMessage());
        }
        
    }
    
}
