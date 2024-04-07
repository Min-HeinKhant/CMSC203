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



public class SavingsAccount extends BankAccount {
    private double rate = 0.025; 
    private int savingsNumber = 0;
    private String accountNumber;

    public SavingsAccount(String name, double initialBalance) {
        super(name, initialBalance);
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }

    public void postInterest() {
        double interest = getBalance() * rate / 12;
        deposit(interest);
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    public SavingsAccount(SavingsAccount oldAccount, double amount) {
        super(oldAccount, amount);
        savingsNumber = oldAccount.savingsNumber + 1;
        this.accountNumber = super.getAccountNumber() + "-" + savingsNumber;
    }
}
