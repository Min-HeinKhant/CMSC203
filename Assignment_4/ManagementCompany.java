package assignment_4;

import java.util.Arrays;

public class ManagementCompany {
    private String name;
    private String taxID;
    private double mgmtFee;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;
    
    
    /**
     * Constructor to create a ManagementCompany object with a custom plot.
     */
    
    public ManagementCompany(String name, String taxID, double mgmtFee, int x, int y, int width, int depth) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFee = mgmtFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }


    public ManagementCompany(String name, String taxID, double mgmtFee, Plot plot) {
        this.name = name;
        this.taxID = taxID;
        this.mgmtFee = mgmtFee;
        this.plot = plot;
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }
    
    public ManagementCompany() {
        this("", "", 0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }


    public String getName() {
        return name;
    }

    public Plot getPlot() {
        return plot;
    }

    
    public int addProperty(Property property) {
        // Error handling and adding the property to the array
        if (property == null) {
            return -2; // Property is null
        }

        if (!plot.encompasses(property.getPlot())) {
            return -3; // Plot is not encompassed
        }

        if (numberOfProperties >= MAX_PROPERTY) {
            return -1; // Array is full
        }

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4; // Plot overlaps with an existing property
            }
        }

        properties[numberOfProperties] = property;
        numberOfProperties++;
        return numberOfProperties - 1; // Successfully added, return index
    }

    public ManagementCompany(String name, String taxID, double mgmtFee) {
        this(name, taxID, mgmtFee, new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH));
    }

    
    public double getTotalRent() {
        double totalRent = 0;
        for (Property prop : properties) {
            if (prop != null) {
                totalRent += prop.getRentAmount();
            }
        }
        return totalRent;
    }

    public Property getHighestRentProperty() {
        Property highestRentProperty = null;
        for (Property prop : properties) {
            if (prop != null && (highestRentProperty == null || prop.getRentAmount() > highestRentProperty.getRentAmount())) {
                highestRentProperty = prop;
            }
        }
        return highestRentProperty;
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public boolean isManagementFeeValid() {
        return mgmtFee >= 0 && mgmtFee <= 100;
    }
    
    private double calculateTotalMgmtFee() {
        double totalFee = 0.0;
        for (Property prop : properties) {
            if (prop != null) {
                totalFee += prop.getRentAmount() * mgmtFee / 100;
            }
        }
        return totalFee;
    }
    
    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmtFee, otherCompany.plot.getX(), 
            otherCompany.plot.getY(), otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
        
        this.properties = Arrays.copyOf(otherCompany.properties, otherCompany.properties.length);
        this.numberOfProperties = otherCompany.numberOfProperties;
    }

    // Adds a new property to the company's list using just the basic info.
    // It makes a new property and then adds it.
    public int addProperty(String name, String city, double rent, String owner) {
    	// Here we're reusing another method we wrote to do the actual adding.
    	return addProperty(new Property(name, city, rent, owner));
    }

    // Adds a new property with all its details, including the size and location of its plot.
    // Just like the simpler addProperty, this one makes a new property too.
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
    	// Again, we're calling the same addProperty method to avoid writing the same code twice.
    	return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // This is a 'getter' method – it just gives back the tax ID of the company.
    public String getTaxID() {
    	return taxID;
    }

    // This 'getter' gives back the percentage of the rent that the company keeps as its fee.
    public double getMgmFeePer() {
    	return mgmtFee;
    }

    // Another 'getter' method that gives you the list of all the properties the company is managing.
    public Property[] getProperties() {
    	return properties;
    }

    

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        double totalManagementFee = calculateTotalMgmtFee(); // Assumes this method calculates the total fee correctly

        info.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        info.append("______________________________________________________\n");
        for (Property prop : properties) {
            if (prop != null) {
                info.append(prop.toString()).append("\n");
            }
        }
        info.append("______________________________________________________\n\n")
            .append(" total management Fee: ").append(String.format("%.2f", totalManagementFee));

        return info.toString();
    }
}
