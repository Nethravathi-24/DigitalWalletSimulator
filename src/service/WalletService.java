package service;

import dao.WalletDAO;
import daoimpl.WalletDAOImpl;
import dto.Wallet;

/*
 * Service layer
 * Contains business logic
 */
public class WalletService {

    WalletDAO dao = new WalletDAOImpl();

    // Create wallet
    public void createWallet(String name, String phone) {
        Wallet wallet = new Wallet();
        wallet.setName(name);
        wallet.setPhone(phone);
        wallet.setBalance(0);
        dao.createWallet(wallet);
    }

    // Add money
    public void addMoney(String phone, double amount) {
        Wallet wallet = dao.getWalletByPhone(phone);

        if (wallet != null) {
            double newBalance = wallet.getBalance() + amount;
            dao.updateBalance(phone, newBalance);
            System.out.println("Money added successfully!");
            System.out.println("Current Balance: ₹" + newBalance);
        } else {
            System.out.println("Wallet not found!");
        }
    }

    // 🔥 WITHDRAW MONEY (THIS WAS MISSING)
    public void withdrawMoney(String phone, double amount) {

        Wallet wallet = dao.getWalletByPhone(phone);

        if (wallet == null) {
            System.out.println("Wallet not found!");
            return;
        }

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }

        double balance = wallet.getBalance();

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            System.out.println("Current Balance: ₹" + balance);
            return;
        }

        double newBalance = balance - amount;
        dao.updateBalance(phone, newBalance);

        System.out.println("Withdraw successful!");
        System.out.println("Remaining Balance: ₹" + newBalance);
    }

    // View balance
    public void viewBalance(String phone) {
        Wallet wallet = dao.getWalletByPhone(phone);
        if (wallet != null) {
            System.out.println("Current Balance: ₹" + wallet.getBalance());
        } else {
            System.out.println("Wallet not found!");
        }
    }
}
