/* Class: CMSC203 CRN 32689
 Program: Assignment #5
 Instructor: Grigoriy Grinberg
 Summary of Description: Bonus calculator
 Due Date: 4/142024
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
 I have not copied the code from a student or any source.
Min Hein Khant
*/

package assignment_6;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	
	public static double[][] readFile(File file) throws FileNotFoundException  {
        Scanner scanner = new Scanner(file);
        ArrayList<double[]> lines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String[] values = scanner.nextLine().trim().split("\\s+");
            double[] row = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                row[i] = Double.parseDouble(values[i]);
            }
            lines.add(row);
        }
        scanner.close();

        return lines.toArray(new double[0][]);
    }

	public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] > highest) {
                highest = row[col];
            }
        }
        return highest;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length && row[col] < lowest) {
                lowest = row[col];
            }
        }
        return lowest;
    }

    public static void writeToFile(double[][] data, File file) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (double[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    pw.print(row[i] + (i < row.length - 1 ? " " : ""));
                }
                pw.println();
            }
        } catch (IOException e) {
            throw new FileNotFoundException("Unable to write to file: " + e.getMessage());
        }
    }

    public static double getAverage(double[][] data) {
        double sum = getTotal(data);
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return count > 0 ? sum / count : 0;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double value : data[row]) {
            if (value > highest) {
                highest = value;
            }
        }
        return highest;
    }

    public static int getHighestInRowIndex(double[][] data, int row) {
        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] > highest) {
                highest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double value : data[row]) {
            if (value < lowest) {
                lowest = value;
            }
        }
        return lowest;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data[row].length; i++) {
            if (data[row][i] < lowest) {
                lowest = data[row][i];
                index = i;
            }
        }
        return index;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        double highest = Double.NEGATIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > highest) {
                highest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        double lowest = Double.POSITIVE_INFINITY;
        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < lowest) {
                lowest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    public static double getHighestInArray(double[][] data) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value > highest) {
                    highest = value;
                }
            }
        }
        return highest;
    }

    public static double getLowestInArray(double[][] data) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            for (double value : row) {
                if (value < lowest) {
                    lowest = value;
                }
            }
        }
        return lowest;
    }

	public static int getLargestNumberOfColumns(double[][] data) {
        int maxColumns = 0;
        for (double[] row : data) {
            if (row.length > maxColumns) {
                maxColumns = row.length;
            }
        }
        return maxColumns;
    }



}
