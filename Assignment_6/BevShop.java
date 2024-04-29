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

import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;

    public BevShop() {
        this.orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public boolean isEligibleForMore() {
        return getCurrentOrder() != null && getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        int alcoholCount = 0;
        Order current = getCurrentOrder();
        if (current != null) {
            for (int i = 0; i < current.getTotalItems(); i++) {
                if (current.getBeverage(i) instanceof Alcohol) {
                    alcoholCount++;
                }
            }
        }
        return alcoholCount;
    }



    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        Order newOrder = new Order(time, day, customer);
        orders.add(newOrder);
    }


    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        if (isEligibleForMore()) {
            Order order = getCurrentOrder();
            if (order != null) {
                order.addNewBeverage(bevName, size, extraShot, extraSyrup);
            }
        }
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        Order order = getCurrentOrder();
        if (order != null) {
            Customer customer = order.getCustomer();
            if (customer.getAge() >= MIN_AGE_FOR_ALCOHOL) {
                order.addNewBeverage(bevName, size);
            } else {
                System.out.println("Sorry, you are not eligible to order alcoholic beverages.");
            }
        }
    }


    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Order order = getCurrentOrder();
        if (order == null) {
            System.out.println("Error: No current order available to add a smoothie.");
            return; 
        }

        if (isMaxFruit(numOfFruits)) {
            System.out.println("Error: The number of fruits (" + numOfFruits + ") exceeds the maximum limit allowed (" + getMaxNumOfFruits() + ").");
            return; 
        }

        order.addNewBeverage(bevName, size, numOfFruits, addProtein);
        System.out.println("Smoothie added successfully. Current order total: $" + order.calcOrderTotal());
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        Order order = getOrderAtIndex(findOrder(orderNo));
        return order != null ? order.calcOrderTotal() : 0;
    }

    @Override
    public double totalMonthlySale() {
        return orders.stream().mapToDouble(Order::calcOrderTotal).sum();
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        if (!orders.isEmpty()) {
            return orders.get(orders.size() - 1);
        }
        return null;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public void sortOrders() {
        Collections.sort(orders, (o1, o2) -> Integer.compare(o1.getOrderNo(), o2.getOrderNo()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Monthly Sales Report:\n");
        for (Order o : orders) {
            sb.append(o.toString()).append("\n");
        }
        sb.append("Total Monthly Sale: ").append(totalMonthlySale());
        return sb.toString();
    }
}
