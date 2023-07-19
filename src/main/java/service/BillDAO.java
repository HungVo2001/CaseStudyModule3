package service;

import model.Bill;

import java.sql.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class BillDAO extends DbContext{
    private static final String INSERT_BILL = "INSERT INTO `bill` (`user_id`, `date`, `total`, `is_cart`) VALUES (?, ?, ?, ?);";

    private static final String SAVE_BILL_INFO= "INSERT INTO `bill` (`user_id`, `date`, `total`, `is_bill`) VALUES (?, ?, ?, ?)";

    private static final String SELECT_BILL_JUST_CREATE = "SELECT id FROM bill ORDER BY id desc";

    private final String UPDATE_CART_STATUS = "UPDATE `bill` SET `is_cart` = ? WHERE (`id` = ?)";

    public void saveBillToDb(int idUser, List<Bill> bills) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL);
            preparedStatement.setInt(1, idUser);
            preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
            preparedStatement.setDouble(3, calculate(bills));
            preparedStatement.setBoolean(4, false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateCartStatus(int idUser) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_STATUS);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setInt(2, idUser);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public double calculate(List<Bill> bills) {
        double total = 0.0;
        for (Bill item : bills) {
            total += item.getTotal();
        }
        return total;
    }

    public int save(Bill bill) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_BILL_INFO);
            preparedStatement.setInt(1, bill.getUser_id());
            Timestamp now = new Timestamp(System.currentTimeMillis());
            preparedStatement.setTimestamp(2, now);
            NumberFormat formatter = new DecimalFormat("#0");
            String formattedNumber = formatter.format(bill.getTotal());
            preparedStatement.setString(3, formattedNumber);
            preparedStatement.setInt(4, 1);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatementSelect = connection.prepareStatement(SELECT_BILL_JUST_CREATE);
            ResultSet rs = preparedStatementSelect.executeQuery();
            while (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
