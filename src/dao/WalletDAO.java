package dao;

import dto.Wallet;

/*
 * DAO Interface
 * Defines database operations
 */
public interface WalletDAO {

    void createWallet(Wallet wallet);

    Wallet getWalletByPhone(String phone);

    void updateBalance(String phone, double newBalance);
}
