package service;

import model.CartItem;
import model.Product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartItemService extends DbContext implements ICartItemService{
    private static final String INSERT_CART_ITEM = "INSERT INTO `cart_items` (`id_product`, `id_cart`, `quantity`, `price`) VALUES (?, ?, ?, ?);";
    private static final String SELECT_CART_ITEM_INFO = "SELECT * FROM cart_items where id_cart = ?;";
    private static final String SAVE_CART_ITEM_INFO = "SELECT LAST_INSERT_ID() as last_id;";
    private static final String UPDATE_CART_ITEM_INFO = "UPDATE `cart_items` SET `quantity` = ? WHERE (`id` = ?);";
    private static final String DELETE_CART_ITEM_INFO = "DELETE FROM `cart_items` WHERE (`id` = ?);";
    private static final String FIND_CART_ITEM_INFO = "SELECT * FROM `cart_items` where id_cart = ? and id_product = ?";
    private IProductService productService;

    public CartItemService() {
        productService = new ProductServiceMysql();
    }
    @Override
    public List<CartItem> getAllCartItems(long idCart) {
        List<CartItem> cartItems = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_ITEM_INFO);
            preparedStatement.setLong(1, idCart);
            System.out.println("getAllCartItems: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long idProduct = resultSet.getLong("id_product");
                long idCartDB = resultSet.getLong("id_cart");
                int quantity = resultSet.getInt("quantity");
                BigDecimal price = resultSet.getBigDecimal("price");

                Product product = productService.findById(idProduct);

                CartItem cartItem = new CartItem(id, idProduct, idCartDB, price, quantity);
                cartItem.setProduct(product);
                cartItems.add(cartItem);

            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return cartItems;
    }

    // Tạo mới: saveCartItem
    @Override
    public CartItem saveCartItem(CartItem cartItem) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_ITEM);
            preparedStatement.setLong(1, cartItem.getIdProduct());
            preparedStatement.setLong(2, cartItem.getIdCart());
            preparedStatement.setInt(3, cartItem.getQuantity());
            preparedStatement.setBigDecimal(4, cartItem.getPrice());

            System.out.println("saveCartItem" + preparedStatement);
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(SAVE_CART_ITEM_INFO);
            System.out.println("saveCartItem: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long lastId = resultSet.getLong("last_id");
                cartItem.setId(lastId);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return cartItem;
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CART_ITEM_INFO);
            preparedStatement.setInt(1, cartItem.getQuantity());
            preparedStatement.setLong(2, cartItem.getId());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(SELECT_CART_ITEM_INFO);
            preparedStatement.setLong(1, cartItem.getId());

            System.out.println("updateCartItem: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long idProduct = resultSet.getLong("id_product");
                long idCartDB = resultSet.getLong("id_cart");
                int quantity = resultSet.getInt("quantity");
                BigDecimal price = resultSet.getBigDecimal("price");

                CartItem cartItemUpdate = new CartItem(id, idProduct, idCartDB, price, quantity);
                return cartItemUpdate;
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return null;
    }

    @Override
    public void deleteCartItem(long idCartItem) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CART_ITEM_INFO);
            preparedStatement.setLong(1, idCartItem);

            System.out.println("deleteCartItem: " + preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
    }

    @Override
    public CartItem findCartItemById(long cartId, long idProduct){
        CartItem cartItem = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CART_ITEM_INFO);
            preparedStatement.setLong(1, cartId);
            preparedStatement.setLong(2, idProduct);
            System.out.println("findCartItemById: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                long idProductDB = resultSet.getLong("id_product");
                long idCartDB = resultSet.getLong("id_cart");
                int quantity = resultSet.getInt("quantity");
                BigDecimal price = resultSet.getBigDecimal("price");

                cartItem = new CartItem(id, idProductDB, idCartDB, price, quantity);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return cartItem;
    }
}
