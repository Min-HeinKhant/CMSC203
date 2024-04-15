/* Class: CMSC203 CRN 32689
 Program: Assignment #5
 Instructor: Grigoriy Grinberg
 Summary of Description: Bonus calculator
 Due Date: 4/14/2024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Min Hein Khant
*/

package assignment_6;

import static org.junit.Assert.*;
import org.junit.Test;

public class HolidayBonusTestStudent {

    // Multiple stores test
    @Test
    public void testCalculateHolidayBonusMultipleStores() {
        double[][] dataSet = {
            {351, 531},   // Store 1
            {4413, 512, 213},  // Store 2
            {2144, 121},   // Store 3
            {212}    // Store 4
        };

       
        double[] expectedBonuses = {
            2000 + 5000, 
            5000 + 2000 + 5000, 
            2000 + 1000, 
            1000 
        };

        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(dataSet);

        assertArrayEquals("The bonus calculation did not match expected output.", expectedBonuses, actualBonuses, 0.001);
    }

    @Test
    public void testCalculateTotalHolidayBonusMultipleStores() {
        double[][] dataSet = {
            {351, 531},   
            {4413, 512, 213}, 
            {2144, 121},  
            {212}    
        };


        double expectedTotalBonus = 7000 + 12000 + 3000 + 1000; // Sum of the expected bonuses

        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(dataSet);

        assertEquals("The total holiday bonus calculation did not match expected output.", expectedTotalBonus, actualTotalBonus, 0.001);
    }

    // Additional tests for edge cases could be added here
}
