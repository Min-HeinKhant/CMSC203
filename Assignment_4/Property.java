package assignment_4;

/**
 * Represents a property with its details such as name, city, rent amount, and owner.
 */

public class Property {
    private String name;
    private String city;
    private double rentalAmount;
    private String owner;
    private Plot plot;

    /**
     * Default constructor, initializes a property with default values.
     */

    
    public Property() {

        this.plot = new Plot();
    }

    /**
     * Constructor with basic property details, assigns a default plot.
     */

    
    public Property(String name, String city, double rentalAmount, String owner) {
        this.name = name;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    /**
     * Constructor with property details and specific plot dimensions.
     */

    
    public Property(String name, String city, double rentalAmount, String owner, int x, int y, int width, int depth) {
        this.name = name;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }
    
    public Property(Property otherProperty) {
        this(otherProperty.name, otherProperty.city, otherProperty.rentalAmount, otherProperty.owner, otherProperty.plot);
    }
    
    public Property(String name, String city, double rentalAmount, String owner, Plot plot) {
        this.name = name;
        this.city = city;
        this.rentalAmount = rentalAmount;
        this.owner = owner;
        this.plot = plot;
    }
    
    public void setPropertyName(String name) {
        this.name = name;
    }

    public String getPropertyName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getRentAmount() {
        return rentalAmount;
    }

    public void setRentalAmount(double rentalAmount) {
        this.rentalAmount = rentalAmount;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    
    
    @Override
    public String toString() {
        return name + "," + city + "," + owner + "," + String.format("%.2f", rentalAmount);
    }

}
