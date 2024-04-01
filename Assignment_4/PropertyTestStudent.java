package assignment_4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent {
    Property property;
    Plot plot;

    @BeforeEach
    void setUp() {
        plot = new Plot(1, 2, 5, 5);
        property = new Property("Blue House", "Oceanview", 5000, "Greg Fisher", plot);
    }

    @Test
    void testCopyConstructor() {
        Property copy = new Property(property);
        assertEquals(property.toString(), copy.toString());
    }

    @Test
    void testSetPropertyName() {
        property.setPropertyName("Red House");
        assertEquals("Red House", property.getPropertyName());
    }

    @Test
    void testSetCity() {
        property.setCity("Mountainview");
        assertEquals("Mountainview", property.getCity());
    }

    @Test
    void testSetOwner() {
        property.setOwner("Sally Smith");
        assertEquals("Sally Smith", property.getOwner());
    }

    @Test
    void testSetRentAmount() {
        property.setRentalAmount(6000);
        assertEquals(6000, property.getRentAmount());
    }

    @Test
    void testToString() {
        String expected = "Blue House,Oceanview,Greg Fisher,5000.00";
        assertEquals(expected, property.toString());
    }

}
