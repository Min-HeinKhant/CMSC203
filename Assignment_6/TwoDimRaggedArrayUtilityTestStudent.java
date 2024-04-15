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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtilityTestStudent {

    @Test
    public void testReadFile() throws FileNotFoundException {
        File tempFile = new File("tempTestFile.txt");
        try (PrintWriter out = new PrintWriter(tempFile)) {
            out.println("1.5 2.5 3.5");
            out.println("4.5 5.5");
            out.println("6.5 7.5 8.5 9.5");
        }
        double[][] expected = {
            {1.5, 2.5, 3.5},
            {4.5, 5.5},
            {6.5, 7.5, 8.5, 9.5}
        };
        double[][] actual = TwoDimRaggedArrayUtility.readFile(tempFile);
        assertArrayEquals(expected[0], actual[0], 0.001);
        assertArrayEquals(expected[1], actual[1], 0.001);
        assertArrayEquals(expected[2], actual[2], 0.001);
        tempFile.delete();
    }

    @Test
    public void testGetRowTotal() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        assertEquals(6, TwoDimRaggedArrayUtility.getRowTotal(data, 0), 0.001);
    }

    @Test
    public void testGetColumnTotal() {
        double[][] data = {{1, 2, 3}, {4, 5, 6}};
        assertEquals(5, TwoDimRaggedArrayUtility.getColumnTotal(data, 0), 0.001);
    }

    @Test
    public void testGetTotal() {
        double[][] data = {{1, 2}, {3, 4}, {5, 6}};
        assertEquals(21, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
    }

    @Test
    public void testGetHighestInColumn() {
        double[][] data = {{1, 4}, {2, 5}, {3, 6}};
        assertEquals(6, TwoDimRaggedArrayUtility.getHighestInColumn(data, 1), 0.001);
    }

    @Test
    public void testGetLowestInColumn() {
        double[][] data = {{1, 4}, {2, 5}, {3, 6}};
        assertEquals(4, TwoDimRaggedArrayUtility.getLowestInColumn(data, 1), 0.001);
    }

    @Test
    public void testWriteToFile() throws IOException {
        double[][] data = {{1, 2}, {3, 4}};
        File file = new File("outputTestFile.txt");
        TwoDimRaggedArrayUtility.writeToFile(data, file);
        assertTrue(file.exists());
        file.delete();
    }

    @Test
    public void testGetAverage() {
        double[][] data = {{1, 2}, {3, 4}, {5, 6}};
        assertEquals(3.5, TwoDimRaggedArrayUtility.getAverage(data), 0.001);
    }

    @Test
    public void testGetHighestInRow() {
        double[][] data = {{1, 2}, {3, 4}, {5, 6}};
        assertEquals(6, TwoDimRaggedArrayUtility.getHighestInRow(data, 2), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() {
        double[][] data = {{1, 2}, {3, 4}, {6, 5}};
        assertEquals(0, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 2));
    }

    @Test
    public void testGetLowestInRow() {
        double[][] data = {{1, 2}, {3, 4}, {5, 6}};
        assertEquals(5, TwoDimRaggedArrayUtility.getLowestInRow(data, 2), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() {
        double[][] data = {{1, 2}, {3, 4}, {6, 5}};
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 2));
    }

    @Test
    public void testGetHighestInColumnIndex() {
        double[][] data = {{1, 2}, {3, 4}, {5, 6}};
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1));
    }

    @Test
    public void testGetLowestInColumnIndex() {
        double[][] data = {{1, 2}, {3, 4}, {5, 6}};
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1));
    }

    @Test
    public void testGetHighestInArray() {
        double[][] data = {{1, 2}, {3, 4}, {5, 6}};
        assertEquals(6, TwoDimRaggedArrayUtility.getHighestInArray(data), 0.001);
    }

    @Test
    public void testGetLowestInArray() {
        double[][] data = {{1, 2}, {3, 4}, {5, 6}};
        assertEquals(1, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
    }

    @Test
    public void testGetLargestNumberOfColumns() {
        double[][] data = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        assertEquals(4, TwoDimRaggedArrayUtility.getLargestNumberOfColumns(data));
    }
}
