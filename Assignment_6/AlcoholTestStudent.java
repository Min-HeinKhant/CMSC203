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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AlcoholTestStudent {

    private Alcohol alcoholWeekdaySmall;
    private Alcohol alcoholWeekendMedium;
    private Alcohol alcoholWeekdayLarge;
    
    
    private static final double BASE_PRICE = 2.0;
    private static final double SIZE_PRICE = 0.5;
    private static final double WEEKEND_PRICE = 0.6;
    
    @Before
    public void setUp() throws Exception {
        alcoholWeekdaySmall = new Alcohol("Small Alcohol", Size.SMALL, false);
        alcoholWeekendMedium = new Alcohol("Medium Alcohol", Size.MEDIUM, true);
        alcoholWeekdayLarge = new Alcohol("Large Alcohol", Size.LARGE, false);
    }

    @Test
    public void testCalcPrice() {
  
        assertEquals(BASE_PRICE, alcoholWeekdaySmall.calcPrice(), 0.0);
        assertEquals(BASE_PRICE + SIZE_PRICE + WEEKEND_PRICE, alcoholWeekendMedium.calcPrice(), 0.0);
        assertEquals(BASE_PRICE + (2 * SIZE_PRICE), alcoholWeekdayLarge.calcPrice(), 0.0);
    }

    @Test
    public void testIsWeekend() {
       
        assertFalse(alcoholWeekdaySmall.isWeekend());
        assertTrue(alcoholWeekendMedium.isWeekend());
        assertFalse(alcoholWeekdayLarge.isWeekend());
    }

    @Test
    public void testToString() {
       
        String expectedSmall = "Small Alcohol, SMALL, Not Weekend, Price: 2.0";
        String expectedMedium = "Medium Alcohol, MEDIUM, Weekend, Price: 3.1";
        String expectedLarge = "Large Alcohol, LARGE, Not Weekend, Price: 3.0";

        assertEquals(expectedSmall, alcoholWeekdaySmall.toString());
        assertEquals(expectedMedium, alcoholWeekendMedium.toString());
        assertEquals(expectedLarge, alcoholWeekdayLarge.toString());
    }

    @Test
    public void testEquals() {
       
        Alcohol anotherAlcohol = new Alcohol("Small Alcohol", Size.SMALL, false);
        assertTrue(alcoholWeekdaySmall.equals(anotherAlcohol));
        
        anotherAlcohol = new Alcohol("Medium Alcohol", Size.MEDIUM, false);
        assertFalse(alcoholWeekendMedium.equals(anotherAlcohol));
        
        anotherAlcohol = new Alcohol("Large Alcohol", Size.LARGE, true);
        assertFalse(alcoholWeekdayLarge.equals(anotherAlcohol));
    }

 
}
