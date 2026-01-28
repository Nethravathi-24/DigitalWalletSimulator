package daoimpl;

import dao.WalletDAO;
import dto.Wallet;
import java.sql.*;
import util.DBConnection;

/*
 * DAO Implementation
 * Contains actual JDBC code
 */
public class WalletDAOImpl implements WalletDAO {

    @Override
    public void createWallet(Wallet wallet) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO wallet(name, phone, balance) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, wallet.getName());
            ps.setString(2, wallet.getPhone());
            ps.setDouble(3, wallet.getBalance());

            ps.executeUpdate();
            System.out.println("Wallet created successfully!");

        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }

    @Override
    public Wallet getWalletByPhone(String phone) {
        Wallet wallet = null;
        try {
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM wallet WHERE phone=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                wallet = new Wallet();
                wallet.setId(rs.getInt("id"));
                wallet.setName(rs.getString("name"));
                wallet.setPhone(rs.getString("phone"));
                wallet.setBalance(rs.getDouble("balance"));
            }

        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }
        return wallet;
    }

    @Override
    public void updateBalance(String phone, double newBalance) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE wallet SET balance=? WHERE phone=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, newBalance);
            ps.setString(2, phone);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("DB Error: " + e.getMessage());
        }
    }
}
