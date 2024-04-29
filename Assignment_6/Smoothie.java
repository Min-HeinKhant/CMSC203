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

public class Smoothie extends Beverage {
    private int numFruits;
    private boolean addProtein;
    private final double PROTEIN_PRICE = 1.5;
    private final double EXTRA_FRUIT_PRICE = 0.5;

    public Smoothie(String bevName, Size size, int numFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numFruits = numFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice() + numFruits * EXTRA_FRUIT_PRICE;
        if (addProtein) {
            price += PROTEIN_PRICE;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fruits: " + numFruits + (addProtein ? ", Protein" : "") + ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Smoothie) {
            Smoothie other = (Smoothie) anotherBev;
            return super.equals(other) && this.numFruits == other.numFruits && this.addProtein == other.addProtein;
        }
        return false;
    }

    
}
