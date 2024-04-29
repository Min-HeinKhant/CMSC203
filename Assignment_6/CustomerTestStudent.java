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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CustomerTestStudent {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("John Doe", 30);
    }

    @Test
    public void testConstructor() {
        assertEquals("John Doe", customer.getName());
        assertEquals(30, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        Customer copy = new Customer(customer);
        assertEquals(customer.getName(), copy.getName());
        assertEquals(customer.getAge(), copy.getAge());
    }

    @Test
    public void testSetAge() {
        customer.setAge(35);
        assertEquals(35, customer.getAge());
    }

    @Test
    public void testSetName() {
        customer.setName("Jane Doe");
        assertEquals("Jane Doe", customer.getName());
    }

    @Test
    public void testToString() {
        String expected = "Name: John Doe, Age: 30";
        assertEquals(expected, customer.toString());
    }
}
