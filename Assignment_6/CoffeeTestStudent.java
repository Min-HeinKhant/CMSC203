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

public class CoffeeTestStudent {

    private Coffee coffeeNoExtras;
    private Coffee coffeeWithShot;
    private Coffee coffeeWithSyrup;
    private Coffee coffeeWithBoth;

    @Before
    public void setUp() {
        coffeeNoExtras = new Coffee("Coffee", Size.SMALL, false, false);
        coffeeWithShot = new Coffee("Coffee", Size.MEDIUM, true, false);
        coffeeWithSyrup = new Coffee("Coffee", Size.MEDIUM, false, true);
        coffeeWithBoth = new Coffee("Coffee", Size.LARGE, true, true);
    }

    @Test
    public void testCalcPrice() {
        assertEquals(2.0, coffeeNoExtras.calcPrice(), 0);
        assertEquals(3.0, coffeeWithShot.calcPrice(), 0);
        assertEquals(3.0, coffeeWithSyrup.calcPrice(), 0);
        assertEquals(4.0, coffeeWithBoth.calcPrice(), 0);
    }

    @Test
    public void testIsExtraShot() {
        assertFalse(coffeeNoExtras.isExtraShot());
        assertTrue(coffeeWithShot.isExtraShot());
    }

    @Test
    public void testIsExtraSyrup() {
        assertFalse(coffeeNoExtras.isExtraSyrup());
        assertTrue(coffeeWithSyrup.isExtraSyrup());
    }

    @Test
    public void testToString() {
        assertEquals("Coffee, SMALL, Price: 2.0", coffeeNoExtras.toString());
        assertEquals("Coffee, MEDIUM, Extra Shot, Price: 3.0", coffeeWithShot.toString());
    }

    @Test
    public void testEquals() {
        Coffee anotherCoffee = new Coffee("Coffee", Size.SMALL, false, false);
        assertEquals(coffeeNoExtras, anotherCoffee);

        anotherCoffee = new Coffee("Coffee", Size.MEDIUM, true, false);
        assertNotEquals(coffeeNoExtras, anotherCoffee);
    }
}
