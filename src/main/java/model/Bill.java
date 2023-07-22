package model;

import java.time.LocalDate;

public class Bill {
    private int id;
    private LocalDate createAt;
    private double total;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private long user_id;

    public Bill() {
    }

    public Bill(int id, LocalDate createAt, double total, String fullName, String address, String phone, String email, long user_id) {
        this.id = id;
        this.createAt = createAt;
        this.total = total;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.user_id = user_id;
    }

    public Bill(LocalDate createAt, double total, String fullName, String address, String phone, String email, long user_id) {
        this.createAt = createAt;
        this.total = total;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.user_id = user_id;
    }

    public Bill(int id, LocalDate createAt, double total, long user_id) {
        this.id = id;
        this.createAt = createAt;
        this.total = total;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

}
