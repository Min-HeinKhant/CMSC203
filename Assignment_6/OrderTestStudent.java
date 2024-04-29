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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTestStudent {

    private Order order;
    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Alice", 28);
        order = new Order(12, Day.MONDAY, customer);
    }

    @Test
    public void testGenerateOrderNumber() {
        int orderNumber = order.generateOrder();
        assertTrue(orderNumber >= 10000 && orderNumber <= 90000);
    }

    @Test
    public void testAddNewBeverageCoffee() {
        order.addNewBeverage("Latte", Size.MEDIUM, true, false);
        assertEquals(1, order.getTotalItems());
        assertTrue(order.getBeverage(0) instanceof Coffee);
    }

    @Test
    public void testAddNewBeverageAlcohol() {
        order.addNewBeverage("Beer", Size.SMALL);
        assertEquals(1, order.getTotalItems());
        assertTrue(order.getBeverage(0) instanceof Alcohol);
    }

    @Test
    public void testAddNewBeverageSmoothie() {
        order.addNewBeverage("Berry Blast", Size.LARGE, 3, true);
        assertEquals(1, order.getTotalItems());
        assertTrue(order.getBeverage(0) instanceof Smoothie);
    }

    @Test
    public void testGetBeverage() {
        order.addNewBeverage("Espresso", Size.SMALL, false, true);
        Beverage beverage = order.getBeverage(0);
        assertNotNull(beverage);
        assertEquals("Espresso", beverage.getBevName());
    }

    @Test
    public void testCalcOrderTotal() {
        order.addNewBeverage("Latte", Size.SMALL, false, false); 
        order.addNewBeverage("Beer", Size.MEDIUM); 
        
        order.addNewBeverage("Green Smoothie", Size.LARGE, 2, false);
        
        double expectedTotal = 2.0 + 2.5 + 4.0;
        
        double total = order.calcOrderTotal();
        assertEquals("The calculated total should match the expected total.", expectedTotal, total, 0.01);
    }

    @Test
    public void testToString() {
        order.addNewBeverage("Latte", Size.SMALL, true, true);
        String result = order.toString();
        assertNotNull(result);
        assertTrue(result.contains("Latte") && result.contains("Order Number: "));
    }

    @Test
    public void testGetCustomer() {
        Customer retrievedCustomer = order.getCustomer();
        assertNotSame(customer, retrievedCustomer); 
        assertEquals(customer.getName(), retrievedCustomer.getName());
        assertEquals(customer.getAge(), retrievedCustomer.getAge());
    }

    @Test
    public void testGetTotalItems() {
        assertEquals(0, order.getTotalItems());
        order.addNewBeverage("Latte", Size.SMALL, true, true);
        assertEquals(1, order.getTotalItems());
    }

}
