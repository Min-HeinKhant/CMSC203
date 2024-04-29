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

public abstract class Beverage {
    private String bevName;
    private Type type;
    private Size size;
    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 0.5;

    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }

    public Type getType() {
        return type;
    }

    public String getBevName() {
        return bevName;
    }

    public Size getSize() {
        return size;
    }

    public double addSizePrice() {
        switch (size) {
            case SMALL:
                return BASE_PRICE;
            case MEDIUM:
                return BASE_PRICE + SIZE_PRICE;
            case LARGE:
                return BASE_PRICE + 2 * SIZE_PRICE;
            default:
                return BASE_PRICE;
        }
    }

    @Override
    public String toString() {
        return bevName + ", " + size;
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Beverage) {
            Beverage other = (Beverage) anotherBev;
            return this.bevName.equals(other.bevName) && this.type == other.type && this.size == other.size;
        }
        return false;
    }

    public abstract double calcPrice();
}
