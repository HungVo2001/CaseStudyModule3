//package service;
//
//import model.BillDetails;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
//public class BillDetailDAO extends DbContext{
//    private static final String INSERT_BILL_DETAIL = "INSERT INTO bill_detail (bill_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
//
//    public void saveBillDetails(List<BillDetails> billDetailHomes) {
//        try {
//            Connection connection = getConnection();
//
//            PreparedStatement preparedStatement;
//            for (BillDetails billDetail : billDetailHomes) {
//                preparedStatement = connection.prepareStatement(INSERT_BILL_DETAIL);
//                preparedStatement.setInt(1, billDetail.getIdBill());
//                preparedStatement.setInt(2, billDetail.getIdProduct());
//                preparedStatement.setInt(3, billDetail.getQuantity());
//                preparedStatement.setDouble(4, billDetail.getPrice());
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
