/*
 * Class: CMSC203-32689
 * Instructor: Professor Grigoriy Grinberg
 * Description: A Bank Account Lab for Inheritance
 * Due: 04/7/2024
 * Platform/compiler:Java Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Min Hein Khant
*/



public class CheckingAccount extends BankAccount {
    private static final double FEE = 0.15; 

    public CheckingAccount(String name, double initialAmount) {
        super(name, initialAmount);
        setAccountNumber(getAccountNumber() + "-10");
    }

    @Override
    public boolean withdraw(double amount) {
        return super.withdraw(amount + FEE);
    }
}
