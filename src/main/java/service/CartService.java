package service;

import dao.DbContext;
import model.Cart;

import java.sql.*;
import java.time.LocalDate;

public class CartService extends DbContext implements ICartService{
    @Override
    public Cart getCartById(long idUser) {
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cart where id_user = ?");

            ps.setLong(1,idUser);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                long id = rs.getLong("id");
                LocalDate date = rs.getDate("create_at").toLocalDate();
                double total = rs.getDouble("total");
                long idUserDB = rs.getLong("id_user");

                Cart cart = new Cart(id,date,total,idUserDB);
                return cart;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cart createCart(Cart cart) {

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `cart` (`create_at`, `total`, `id_user`) VALUES (?, ?, ?)");

            ps.setDate(1, Date.valueOf(cart.getCreateAt()));
            ps.setDouble(2,cart.getTotal());
            ps.setLong(3, cart.getIdUser());
            ps.executeUpdate();

            ps = connection.prepareStatement("SELECT LAST_INSERT_ID() as last_id");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                long maxId = rs.getLong("last_id");
                cart.setId(maxId);
            }
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
        return null;
    }

    @Override
    public void addToCart(int idProduct, int quantity, long idUser) {
        Cart cart = getCartById(idUser);
        if (cart==null){
            cart = new Cart(LocalDate.now(),0, idUser);
            cart = createCart(cart);

        }
    }
}
