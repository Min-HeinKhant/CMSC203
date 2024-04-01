package assignment_4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagementCompanyTestStudent {
    private ManagementCompany catCafeCompany;
    private final double DELTA = 0.01; 

    @BeforeEach
    void setUp() {

    	catCafeCompany = new ManagementCompany("Cat Haven Estates", "CAT123", 15.0, 
                0, 0, ManagementCompany.MGMT_WIDTH, ManagementCompany.MGMT_DEPTH);

    }

    @Test
    void testAddCatCafeWithDefaultPlot() {
      
        assertEquals(0, catCafeCompany.addProperty("Whiskers Retreat", "Meowville", 8000, "Alice Whiskers"));
    }

    @Test
    void testAddCatCafeWithCustomPlot() {
      
        assertEquals(0, catCafeCompany.addProperty("Paws and Relax", "Purrington", 12000, "Bob Tails", 2, 3, 2, 2));
    }

    @Test
    void testAddCatCafeObject() {
        Property catCafe = new Property("Furry Friends Café", "Tabby Town", 10000, "Cathy Clawford");
        assertEquals(0, catCafeCompany.addProperty(catCafe));
    }

    @Test
    void testCatCafeArrayFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            catCafeCompany.addProperty(new Property("Cafe " + i, "Cat City", 5000 * (i + 1), "Owner " + i));
        }
        
        assertEquals(-1, catCafeCompany.addProperty(new Property("The Scratching Post", "Kittenburg", 7000, "Diane Scratcher")));
    }

    @Test
    void testGetTotalCatCafeRent() {
        catCafeCompany.addProperty("Whiskers Retreat", "Meowville", 8000, "Alice Whiskers");
        catCafeCompany.addProperty("Paws and Relax", "Purrington", 12000, "Bob Tails");
        assertEquals(20000, catCafeCompany.getTotalRent(), DELTA);
    }

    @Test
    void testGetCatCafeWithHighestRent() {
        catCafeCompany.addProperty("Whiskers Retreat", "Meowville", 8000, "Alice Whiskers");
        catCafeCompany.addProperty("Paws and Relax", "Purrington", 12000, "Bob Tails");
        Property highestRentCatCafe = catCafeCompany.getHighestRentProperty();
        assertNotNull(highestRentCatCafe);
        assertEquals(12000, highestRentCatCafe.getRentAmount(), DELTA);
    }

    @Test
    void testRemoveLastCatCafe() {
        catCafeCompany.addProperty("Whiskers Retreat", "Meowville", 8000, "Alice Whiskers");
        catCafeCompany.removeLastProperty();
        assertEquals(0, catCafeCompany.getPropertiesCount());
    }

    @Test
    void testIsCatCafeArrayFullFalse() {
        assertFalse(catCafeCompany.isPropertiesFull());
    }

    @Test
    void testIsCatCafeArrayFullTrue() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            catCafeCompany.addProperty(new Property("Cafe " + i, "Cat City", 5000 * (i + 1), "Owner " + i));
        }
        assertTrue(catCafeCompany.isPropertiesFull());
    }

    @Test
    void testCatCafeCount() {
        catCafeCompany.addProperty("Whiskers Retreat", "Meowville", 8000, "Alice Whiskers");
        assertEquals(1, catCafeCompany.getPropertiesCount());
    }

    @Test
    void testManagementFeeValid() {
        assertTrue(catCafeCompany.isManagementFeeValid());
    }

    @Test
    void testToStringCatCafes() {
        catCafeCompany.addProperty("Whiskers Retreat", "Meowville", 8000, "Alice Whiskers");
        String result = catCafeCompany.toString();
        assertTrue(result.contains("Cat Haven Estates") && result.contains("8000"));
    }

    @Test
    void testAddPropertyWithInvalidManagementFee() {
        ManagementCompany companyWithInvalidFee = new ManagementCompany("InvalidFeeCo", "CAT987", 150.0, 0, 0, ManagementCompany.MGMT_WIDTH, ManagementCompany.MGMT_DEPTH);
        assertFalse(companyWithInvalidFee.isManagementFeeValid());
    }

    @Test
    void testAddPropertyFailsWithNegativeRent() {
        assertEquals(-2, catCafeCompany.addProperty("Negative Rent Cafe", "Meowville", -100, "Alice Whiskers"));
    }

    @Test
    void testGetHighestRentPropertyWhenNoPropertiesAdded() {
        assertNull(catCafeCompany.getHighestRentProperty());
    }

    @Test
    void testToStringContainsCorrectNumberOfCatCafes() {
        catCafeCompany.addProperty("Whiskers Retreat", "Meowville", 8000, "Alice Whiskers");
        catCafeCompany.addProperty("Paws and Relax", "Purrington", 12000, "Bob Tails");
        String result = catCafeCompany.toString();
      
        long count = result.lines().filter(line -> line.contains(",")).count();
        assertEquals(2, count);
    }

    
}
