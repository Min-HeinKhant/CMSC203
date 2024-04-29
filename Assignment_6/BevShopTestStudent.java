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

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BevShopTestStudent {

    private BevShop bevShop;

    @Before
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testStartNewOrder() {
        bevShop.startNewOrder(9, Day.MONDAY, "Alice", 25);
        assertNotNull(bevShop.getCurrentOrder());
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void testProcessCoffeeOrder() {
        bevShop.startNewOrder(9, Day.MONDAY, "Bob", 20);
        bevShop.processCoffeeOrder("Espresso", Size.MEDIUM, true, true);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testProcessAlcoholOrder() {
        bevShop.startNewOrder(15, Day.FRIDAY, "Charlie", 23);
        bevShop.processAlcoholOrder("Beer", Size.LARGE);
        assertEquals(1, bevShop.getNumOfAlcoholDrink());
        assertTrue(bevShop.isEligibleForMore());
        
    }

    @Test
    public void testProcessSmoothieOrder() {
        bevShop.startNewOrder(10, Day.TUESDAY, "Dani", 30);
        bevShop.processSmoothieOrder("Green Mix", Size.SMALL, 2, false);
        assertEquals(1, bevShop.getCurrentOrder().getTotalItems());
    }

    @Test
    public void testIsValidTime() {
        assertTrue(bevShop.isValidTime(10));
        assertFalse(bevShop.isValidTime(7)); 
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void testIsEligibleForMore() {
        bevShop.startNewOrder(12, Day.SATURDAY, "Eve", 35);
        for (int i = 0; i < bevShop.getMaxOrderForAlcohol(); i++) {
            bevShop.processAlcoholOrder("Wine", Size.MEDIUM);
        }
        assertFalse(bevShop.isEligibleForMore());
    }

    @Test
    public void testTotalOrderPrice() {
        bevShop.startNewOrder(11, Day.WEDNESDAY, "Frank", 40);
        bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, true);
        bevShop.processSmoothieOrder("Berry Blast", Size.MEDIUM, 3, true);
        int orderNumber = bevShop.getCurrentOrder().getOrderNo();
        assertTrue(bevShop.totalOrderPrice(orderNumber) > 0);
    }

    @Test
    public void testTotalMonthlySale() {
        bevShop.startNewOrder(14, Day.MONDAY, "Grace", 22);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        assertTrue(bevShop.totalMonthlySale() > 0);
    }

    @Test
    public void testSortOrders() {
        bevShop.startNewOrder(16, Day.THURSDAY, "Henry", 29);
        bevShop.startNewOrder(17, Day.THURSDAY, "Isla", 31);
        
        bevShop.sortOrders();
        Order firstOrder = bevShop.getOrderAtIndex(0);
        for (int i = 1; i < bevShop.totalNumOfMonthlyOrders(); i++) {
            Order nextOrder = bevShop.getOrderAtIndex(i);
            assertTrue(firstOrder.getOrderNo() <= nextOrder.getOrderNo());
        }
    }

    
}
