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

public class BeverageTestStudent {

    private Beverage beverageSmall;
    private Beverage beverageMedium;
    private Beverage beverageLarge;

  
    private class TestBeverage extends Beverage {
        public TestBeverage(String name, Type type, Size size) {
            super(name, type, size);
        }

        
        public double calcPrice() {
            return addSizePrice();  
        }
    }

    @Before
    public void setUp() {
        beverageSmall = new TestBeverage("Test Beverage", Type.COFFEE, Size.SMALL);
        beverageMedium = new TestBeverage("Test Beverage", Type.COFFEE, Size.MEDIUM);
        beverageLarge = new TestBeverage("Test Beverage", Type.COFFEE, Size.LARGE);
    }

    @Test
    public void testAddSizePrice() {
        assertEquals(2.0, beverageSmall.calcPrice(), 0.0);
        assertEquals(2.5, beverageMedium.calcPrice(), 0.0);
        assertEquals(3.0, beverageLarge.calcPrice(), 0.0);
    }

    @Test
    public void testEquals() {
        Beverage anotherBeverage = new TestBeverage("Test Beverage", Type.COFFEE, Size.SMALL);
        assertTrue(beverageSmall.equals(anotherBeverage));

        anotherBeverage = new TestBeverage("Different Beverage", Type.COFFEE, Size.SMALL);
        assertFalse(beverageSmall.equals(anotherBeverage));

        anotherBeverage = new TestBeverage("Test Beverage", Type.SMOOTHIE, Size.SMALL);
        assertFalse(beverageSmall.equals(anotherBeverage));

        anotherBeverage = new TestBeverage("Test Beverage", Type.COFFEE, Size.LARGE);
        assertFalse(beverageSmall.equals(anotherBeverage));
    }

    @Test
    public void testToString() {
        assertEquals("Test Beverage, SMALL", beverageSmall.toString());
        assertEquals("Test Beverage, MEDIUM", beverageMedium.toString());
        assertEquals("Test Beverage, LARGE", beverageLarge.toString());
    }
}
