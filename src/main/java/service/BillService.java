package service;

import model.Bill;
import model.Cart;
import model.CartItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static dao.DbContext.getConnection;

public class BillService implements IBillService{

    private IProductService productService;
    private ICartItemService cartItemService;
    private ICartService cartService;
    @Override
    public Bill findPayment(long id) {
        return null;
    }

    @Override
    public Bill createBill(long idUser) {
        return null;
    }

    @Override
    public Bill getBillById(long idUser) {
        Bill bill = null;
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM bill where user_id = ?");

            ps.setLong(1,idUser);
            System.out.println("getBillById" + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){//int id, LocalDate createAt, double total, String fullName, String address, String phone, String email, long user_id
                int id = rs.getInt("id");
                LocalDate createAt = rs.getDate("create_at").toLocalDate();
                double total = rs.getDouble("total");
                long userId = rs.getLong("user_id");

                bill = new Bill(id,createAt,total,userId);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return bill;
    }
}
