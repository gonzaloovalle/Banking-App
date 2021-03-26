import java.util.Scanner;

public class Account {
    //Variables
    int balance;
    int previousTransaction;
    String name;
    String ID;

    //Constructor
    Account(String cName, String cID) {
        name = cName;
        ID = cID;
    }

    //Function for Depositing money
    void deposit(int amount) {
        if(amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    //Function for Withdrawing money
    void withdraw(int amount) {
        if(amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    //Function for previous transaction
    void getPreviousTransaction() {
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if(previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    //Function calculating interest after a number of years
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is: " + (100 * interestRate) + "%");
        System.out.println("After " + years + "years, your balance will be: " + newBalance);
    }

    //Function showing menu
    void menu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + name + "!");
        System.out.println("Your ID is: " + ID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {
                //Case A allows users to check their balance
                case 'A':
                    System.out.println("=======================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("=======================");
                    System.out.println();
                    break;
                //Case B allows users to make deposits
                case 'B':
                    System.out.println("Enter a deposit amount: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
            }
        }
    }
}
