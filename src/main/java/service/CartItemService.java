package service;

import dao.DbContext;
import model.CartItem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartItemService extends DbContext implements ICartItemService{

    @Override
    public List<CartItem> getAllCartItems(long idCart) {
        List<CartItem> cartItems = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cart_items where id_cart = ?");

            ps.setLong(1, idCart);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                long id = rs.getLong("id");
                long idProduct = rs.getLong("id_product");
                long idCartDB = rs.getLong("id_cart");
                int quantity  = rs.getInt("quantity");
                BigDecimal price = rs.getBigDecimal("price");

                CartItem cartItem = new CartItem(id, idProduct, idCartDB, price, quantity );
                cartItems.add(cartItem);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cartItems;
    }

    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO `cart_items` (`id_product`, `id_cart`, `quantity`, `price`) VALUES (?, ?, ?, ?)");
            ps.setLong(1,cartItem.getIdCart());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public void deleteCartItem(long idCart) {

    }
}
