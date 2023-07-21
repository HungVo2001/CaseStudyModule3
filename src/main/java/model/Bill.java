package model;

import java.time.LocalDate;
import java.util.List;

public class Bill {
    private long id;
    private User user_id;
    private LocalDate createAt;
    List<CartItem> cartItems;

    private double total;
    private String fullName;
    private String phone;

    public Bill() {
    }

    public Bill(long id, User user_id, LocalDate createAt, List<CartItem> cartItems, double total, String fullName, String phone) {
        this.id = id;
        this.user_id = user_id;
        this.createAt = createAt;
        this.cartItems = cartItems;
        this.total = total;
        this.fullName = fullName;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
