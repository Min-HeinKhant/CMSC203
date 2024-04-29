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

public class SmoothieTestStudent {

    private Smoothie smoothieNoProtein;
    private Smoothie smoothieWithProtein;

    @Before
    public void setUp() {
        smoothieNoProtein = new Smoothie("Berry Banana", Size.MEDIUM, 3, false);
        smoothieWithProtein = new Smoothie("Tropical", Size.LARGE, 2, true);
    }

    @Test
    public void testCalcPrice() {
        double priceNoProtein = 2.5 + 3 * 0.5; 
        double priceWithProtein = 3.0 + 2 * 0.5 + 1.5; 

        assertEquals(priceNoProtein, smoothieNoProtein.calcPrice(), 0.01);
        assertEquals(priceWithProtein, smoothieWithProtein.calcPrice(), 0.01);
    }

    @Test
    public void testToString() {
        String expectedNoProtein = "Berry Banana, MEDIUM, Fruits: 3, Price: 4.0";
        String expectedWithProtein = "Tropical, LARGE, Fruits: 2, Protein, Price: 5.5";

        assertEquals(expectedNoProtein, smoothieNoProtein.toString());
        assertEquals(expectedWithProtein, smoothieWithProtein.toString());
    }

    @Test
    public void testEquals() {
        Smoothie anotherSmoothie = new Smoothie("Berry Banana", Size.MEDIUM, 3, false);
        assertTrue(smoothieNoProtein.equals(anotherSmoothie));

        anotherSmoothie = new Smoothie("Berry Banana", Size.MEDIUM, 2, false);
        assertFalse(smoothieNoProtein.equals(anotherSmoothie));

        anotherSmoothie = new Smoothie("Tropical", Size.LARGE, 2, true);
        assertTrue(smoothieWithProtein.equals(anotherSmoothie));
    }
}
