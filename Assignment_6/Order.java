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

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNumber;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderNumber = generateOrder();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(cust);
        this.beverages = new ArrayList<>();
    }

    public int generateOrder() {
        return (int) (Math.random() * (90000 - 10000) + 10000);
    }

    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    public double calcOrderTotal() {
        return beverages.stream().mapToDouble(Beverage::calcPrice).sum();
    }

    public int findNumOfBeveType(Type type) {
        return (int) beverages.stream().filter(b -> b.getType() == type).count();
    }

    public int compareTo(Order anotherOrder) {
        return Integer.compare(this.orderNumber, anotherOrder.orderNumber);
    }

    public int getOrderNo() {
        return orderNumber;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(this.customer);
    }

    public Day getDay() {
        return getOrderDay();
    }

    public int getTotalItems() {
        return beverages.size();
    }

    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber)
          .append(", Time: ").append(orderTime)
          .append(", Day: ").append(orderDay)
          .append(", Customer: ").append(customer.getName())
          .append(", Age: ").append(customer.getAge())
          .append(", Beverages: ");
        beverages.forEach(b -> sb.append(b.toString()).append(", "));
        return sb.toString().trim();
    }


    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }
}
