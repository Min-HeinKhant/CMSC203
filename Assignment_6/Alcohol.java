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

public class Alcohol extends Beverage {
    private boolean isWeekend;
    private final double WEEKEND_PRICE = 0.6;

    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (isWeekend) {
            price += WEEKEND_PRICE;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + (isWeekend ? "Weekend" : "Not Weekend") + ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Alcohol) {
            Alcohol other = (Alcohol) anotherBev;
            return super.equals(other) && this.isWeekend == other.isWeekend;
        }
        return false;
    }

    public boolean isWeekend() {
        return isWeekend;
    }
}
