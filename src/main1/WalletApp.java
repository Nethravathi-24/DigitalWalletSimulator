package main;

import java.util.Scanner;
import service.WalletService;

/*
 * Main class
 * Menu driven application
 */
public class WalletApp {

    public static void main(String[] args) {

        WalletService service = new WalletService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== DIGITAL WALLET SIMULATOR ====");
            System.out.println("1. Create Wallet");
            System.out.println("2. Add Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Phone: ");
                    String phone = sc.next();
                    service.createWallet(name, phone);
                    break;

                case 2:
                    System.out.print("Enter Phone: ");
                    phone = sc.next();
                    System.out.print("Enter Amount: ");
                    double amt = sc.nextDouble();
                    service.addMoney(phone, amt);
                    break;

                case 3:
    System.out.print("Enter Phone: ");
    phone = sc.next();
    System.out.print("Enter Amount to Withdraw: ");
    double withdrawAmt = sc.nextDouble();
    service.withdrawMoney(phone, withdrawAmt);
    break;

case 4:
    System.out.print("Enter Phone: ");
    phone = sc.next();
    service.viewBalance(phone);
    break;

case 5:
    System.out.println("Thank you for using Digital Wallet!");
    sc.close();
    System.exit(0);


                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
