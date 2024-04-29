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

public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_SHOT_PRICE = 0.5;
    private final double EXTRA_SYRUP_PRICE = 0.5;

    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }

    
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) {
            price += EXTRA_SHOT_PRICE;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_PRICE;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + (extraShot ? ", Extra Shot" : "") + (extraSyrup ? ", Extra Syrup" : "") + ", Price: " + calcPrice();
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (anotherBev instanceof Coffee) {
            Coffee other = (Coffee) anotherBev;
            return super.equals(other) && this.extraShot == other.extraShot && this.extraSyrup == other.extraSyrup;
        }
        return false;
    }

   
}
