package model;


public class BillDetails {
    private int detail_id;
    private int idProduct;
    private int idBill;
    private Double price;
    private int quantity;

    public BillDetails() {
    }

    public BillDetails(int detail_id, int idProduct, int idBill, Double price, int quantity) {
        this.detail_id = detail_id;
        this.idProduct = idProduct;
        this.idBill = idBill;
        this.price = price;
        this.quantity = quantity;
    }

    public int getDetail_id() {
        return detail_id;
    }

    public void setDetail_id(int detail_id) {
        this.detail_id = detail_id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
