package model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

public class Product {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDate createAt;

    private  int idProductType;
     private ProductType productType;

     private Instant updateAt;
    private ESize size;


    public Product(long id, String name, String description, BigDecimal price, LocalDate createAt, int idProductType, ProductType productType, Instant updateAt, ESize size) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
        this.idProductType = idProductType;
        this.productType = productType;
        this.updateAt = updateAt;
        this.size = size;
    }

    public Product() {
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public ESize getSize() {
        return size;
    }

    public void setSize(ESize size) {
        this.size = size;
    }

    public int getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(int idProductType) {
        this.idProductType = idProductType;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Product(long id, String name, String description, BigDecimal price, LocalDate createAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDate createAt) {
        this.createAt = createAt;
    }
}
