/* Class: CMSC203 CRN 32689
 Program: Assignment #6
 Instructor: Grigoriy Grinberg
 Summary of Description: Beverage maanger
 Due Date: 4/28/2024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Min Hein Khant
*/




package beverage;

public class Customer {
    private String name;
    private int age;


    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Customer(Customer c) {
        this.name = c.name;
        this.age = c.age;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }

    
    public String getName() {
        return name;
    }

   
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}
