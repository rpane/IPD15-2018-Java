/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day02peoplefromfile;



/**
 *
 * @author 0639300
 */
public class Person {
    
    private String name;
    private int age;

    public Person(String name, int age) {
        if (name.length() < 2)
        {
            throw new IllegalArgumentException("Name must have a length greater than 2");
        }
        this.name = name;
        if( age <0 || age > 150)
        {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
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
        if (name.length() < 2)
        {
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
        if( age <0 || age > 150)
        {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
    }

    
    
   
    
}
