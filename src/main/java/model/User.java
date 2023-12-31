package model;

public class User {
    private int id;

    private String username;

    private String password;

    private String email;

    private String fullname;

    private String phone;

    private Role role;
    private String address;
    private String img;

    public User() {
    }

    public User(int id, String username, String password, String email, String fullname, String phone, Role role, String address, String img) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.role = role;
        this.address = address;
        this.img = img;
    }

    public User(int id, String username, String password, String email, String fullname, String phone, String address, String img) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.img = img;
    }

    public User(int idDB, String usernameDB, String passwordDB, String email, String fullname, String phone, String address) {
        this.id = idDB;
        this.username = usernameDB;
        this.password = passwordDB;
        this.email = email;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
