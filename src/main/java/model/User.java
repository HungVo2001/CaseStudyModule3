package model;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private String fullname;
    private String phone;
    private String address;
    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(long id, String name, String password, String email, String fullname, String phone, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
