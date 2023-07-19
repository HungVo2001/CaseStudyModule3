package service;

import model.Cart;
import model.CartItem;
import model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class CartService extends DbContext implements ICartService{

    private static final String SELECT_CART_INFO = "SELECT * FROM cart where id_user = ?;";
    private static final String INSERT_CART_INFO = "INSERT INTO `cart` (`create_at`, `total`, `id_user`) VALUES (?, ?, ?);";
    private static final String SAVE_CART_INFO = "SELECT LAST_INSERT_ID() as last_id;";
    private IProductService productService;
    private ICartItemService cartItemService;

    public CartService() {

        productService = new ProductServiceMysql();
        cartItemService = new CartItemService();
    }
    @Override
    public Cart getCartById(long idUser) {
        Cart cart = null;
        Connection connection = getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_INFO);

            preparedStatement.setLong(1, idUser);

            System.out.println("getCartById: " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                LocalDate date = rs.getDate("create_at").toLocalDate();
                double total = rs.getDouble("total");
                long idUserDB = rs.getLong("id_user");

                cart = new Cart(id, date, total, idUserDB);
                List<CartItem> cartItems = cartItemService.getAllCartItems(cart.getId());
                cart.setCartItems(cartItems);
            }
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }
        return cart;
    }
    @Override
    public Cart createCart(Cart cart) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_INFO);
            preparedStatement.setDate(1, Date.valueOf(cart.getCreateAt()));
            preparedStatement.setDouble(2, cart.getTotal());
            preparedStatement.setLong(3, cart.getIdUser());
            preparedStatement.executeUpdate();

            System.out.println("createCart: " + preparedStatement);
            preparedStatement = connection.prepareStatement(SAVE_CART_INFO);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long maxId = rs.getLong("last_id");
                cart.setId(maxId);
            }
            connection.close();
        } catch (SQLException sqlException) {
            printSQLException(sqlException);
        }

        return cart;
    }

    @Override
    public Cart updateCart(Cart cart) {
//        Connection connection = getConnection();
//        PreparedStatement preparedStatement = connection.prepareStatement("");
//        preparedStatement.setLong(1,cart.getId());
//        preparedStatement.setDate(2,cart.getCreateAt());
//        preparedStatement.setDouble(3,cart.getTotal());
//        preparedStatement.executeUpdate();
        return null;
    }

    @Override
    public void addToCart(int idProduct, int quantity, long idUser) {
        Product product = productService.findById(idProduct);

        Cart cart = getCartById(idUser);
        if (cart == null) {
            cart = new Cart(LocalDate.now(), 0, idUser);
            cart = createCart(cart);
        }
        CartItem cartItem = cartItemService.findCartItemById(cart.getId(), idProduct);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItemService.updateCartItem(cartItem);
        }else{
            CartItem cartItemCreate = new CartItem(idProduct, product.getPrice(), quantity);
            cartItemCreate.setIdCart(cart.getId());
            cartItemService.saveCartItem(cartItemCreate);
        }

    }

    @Override
    public Cart updateCartInfo(long idUser, long idProduct, int quantity) {
        Cart cart = getCartById(idUser);
        CartItem cartItem = cartItemService.findCartItemById(cart.getId(), idProduct);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            cartItemService.updateCartItem(cartItem);
        }
        cart = getCartById(idUser);
        return cart;
    }
}
