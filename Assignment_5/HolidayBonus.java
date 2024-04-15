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

public class HolidayBonus {

	//Constants for the bonuses
    public static final double HIGH_BONUS = 5000.0;
    public static final double LOW_BONUS = 1000.0;
    public static final double OTHER_BONUS = 2000.0;

    //Calculates bonus, row for store, column for sales
    
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        for (int col = 0; col < TwoDimRaggedArrayUtility.getLargestNumberOfColumns(data); col++) {
            int highestIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col);
            int lowestIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col);
            double highestSale = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
            double lowestSale = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

            for (int row = 0; row < data.length; row++) {
                if (data[row].length > col) { // If the current row has sales in this category
                    if (data[row][col] > 0) {
                        if (row == highestIndex && highestSale != 0) {
                            bonuses[row] += HIGH_BONUS;
                        } else if (row == lowestIndex && highestSale != lowestSale) {
                            bonuses[row] += LOW_BONUS;
                        } else {
                            bonuses[row] += OTHER_BONUS;
                        }
                    }
                }
            }
        }
        return bonuses;
    }

    //calculates total for all stores
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonuses = 0;
        double[] bonuses = calculateHolidayBonus(data);
        for (double bonus : bonuses) {
            totalBonuses += bonus;
        }
        return totalBonuses;
    }

   
  
}
