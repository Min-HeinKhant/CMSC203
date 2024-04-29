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

import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BevShop bevShop = new BevShop();
        System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() + " alcoholic beverages.");
        System.out.println("The minimum age to order an alcohol drink is " + bevShop.getMinAgeForAlcohol());

        while (true) {
            System.out.println("#------------------------------------#");
            System.out.println("Start please a new order:");
            System.out.print("Would you please enter your name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Would you please enter your age: ");
            int age = Integer.parseInt(scanner.nextLine().trim());

            boolean canOrderAlcohol = bevShop.isValidAge(age);
            if (!canOrderAlcohol) {
                System.out.println("Your age is not appropriate for ordering alcohol.");
            } else {
                System.out.println("Your age is above 20 and you are eligible to order alcohol");
            }

            System.out.print("Would you please enter the time (hour in 24-hour format): ");
            int time = Integer.parseInt(scanner.nextLine().trim());

            if (!bevShop.isValidTime(time)) {
                System.out.println("Invalid time. Please try again.");
                continue;
            }

            System.out.print("Please enter the day (e.g., MONDAY, TUESDAY, ...): ");
            Day day;
            try {
                day = Day.valueOf(scanner.nextLine().toUpperCase().trim());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid day. Please try again.");
                continue;
            }

            bevShop.startNewOrder(time, day, name, age);

            while (true) {
                System.out.println("Add a drink type (COFFEE, SMOOTHIE, ALCOHOL) or type END to finish:");
                String type = scanner.nextLine().toUpperCase().trim();
                if (type.equals("END")) {
                    break;
                }

                if (type.equals("ALCOHOL") && !canOrderAlcohol) {
                    System.out.println("You are not eligible to order alcohol.");
                    continue;
                }

                switch (type) {
                    case "COFFEE":
                        System.out.println("Enter Coffee name and size (SMALL, MEDIUM, LARGE):");
                        String coffeeName = scanner.nextLine();
                        Size coffeeSize = Size.valueOf(scanner.nextLine().toUpperCase().trim());
                        System.out.println("Extra shot (true/false):");
                        boolean extraShot = Boolean.parseBoolean(scanner.nextLine().trim());
                        System.out.println("Extra syrup (true/false):");
                        boolean extraSyrup = Boolean.parseBoolean(scanner.nextLine().trim());
                        bevShop.processCoffeeOrder(coffeeName, coffeeSize, extraShot, extraSyrup);
                        break;
                    case "SMOOTHIE":
                        System.out.println("Enter Smoothie name and size (SMALL, MEDIUM, LARGE):");
                        String smoothieName = scanner.nextLine();
                        Size smoothieSize = Size.valueOf(scanner.nextLine().toUpperCase().trim());
                        System.out.println("Number of fruits:");
                        int fruits = Integer.parseInt(scanner.nextLine().trim());
                        System.out.println("Add protein (true/false):");
                        boolean protein = Boolean.parseBoolean(scanner.nextLine().trim());
                        bevShop.processSmoothieOrder(smoothieName, smoothieSize, fruits, protein);
                        break;
                    case "ALCOHOL":
                        System.out.println("Enter Alcohol name and size (SMALL, MEDIUM, LARGE):");
                        String alcoholName = scanner.nextLine();
                        String alcoholSize = scanner.nextLine().toUpperCase();
                        bevShop.processAlcoholOrder(alcoholName, Size.valueOf(alcoholSize));
                        break;
                    default:
                        System.out.println("Invalid drink type.");
                        continue;
                }
                System.out.println("Current order total: " + bevShop.getCurrentOrder().calcOrderTotal());
            }

            System.out.println("Final order total: " + bevShop.getCurrentOrder().calcOrderTotal());
            System.out.println("Continue with new order? (yes/no):");
            if (!scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Total monthly sales: " + bevShop.totalMonthlySale());
        scanner.close();
    }
}
