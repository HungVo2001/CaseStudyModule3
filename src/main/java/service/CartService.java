package service;

import dao.DbContext;
import model.Cart;
import model.CartItem;
import model.Product;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class CartService extends DbContext implements ICartService{
    private IProductService productService;
    private ICartItemService cartItemService;
    private ICartService cartService;
    public CartService(){
        productService = new ProductServiceMysql();
        cartItemService = new CartItemService();
    }
    @Override
    public Cart getCartById(long idUser) {
        Cart cart = null;
        Connection connection = getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cart where id_user = ?");

            ps.setLong(1,idUser);
            System.out.println("getCartById" + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                long id = rs.getLong("id");
                LocalDate date = rs.getDate("create_at").toLocalDate();
                double total = rs.getDouble("total");
                long idUserDB = rs.getLong("id_user");

                cart = new Cart(id,date,total,idUserDB);
                List<CartItem> cartItems = cartItemService.getAllCartItems(cart.getId());
                cart.setCartItems(cartItems);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cart;
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

            System.out.println("createCart" + ps);
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
        Product product = productService.findById(idProduct);
        Cart cart = getCartById(idUser);
        double total = product.getPrice().doubleValue() * quantity;
        if (cart == null){
            cart = new Cart(LocalDate.now(),total, idUser);
            cart = createCart(cart);
        }
        CartItem cartItem = cartItemService.findCartItemById(cart.getId(), idProduct);
        if (cartItem != null){
            cartItem.setQuantity(quantity);
            cartItemService.updateCartItem(cartItem);
        }else {
            CartItem cartItemCreate = new CartItem(idProduct, product.getPrice(),quantity);
            cartItemService.saveCartItem(cartItemCreate);
        }
       cart.setTotal(total);
        updateCart(cart);
    }
}
