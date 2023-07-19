package service;

import com.mysql.cj.xdevapi.PreparableStatement;
import model.ESize;
import model.Pageable;
import model.Product;
import model.ProductType;

import java.math.BigDecimal;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceMysql extends DbContext implements IProductService{
    private static final String FIND_ALL_PRODUCTS = "SELECT p.*, pt.id as id_cate, pt.name as name_cate " +
            "FROM products p join product_type pt on p.id_product_type = pt.id";
    private static final String FIND_BY_ID = "SELECT p.*, pt.id as id_cate, pt.name as name_cate FROM products p join product_type pt on p.id_product_type = pt.id where p.id = ?";
    private static final String SQL_FILTER_PRODUCTS = "SELECT p.*, pt.id as id_cate, pt.name as name_cate \n" +
            "FROM products p join product_type pt on p.id_product_type = pt.id \n" +
            "where (p.name like ? or p.price like ? or p.size like ?) %s \n" +
            "limit ?,?";
    private static final String SQL_FILTER_PRODUCTS_COUNT = "SELECT count(*) as total \n" +
            "FROM products p join product_type pt on p.id_product_type = pt.id \n" +
            "where (p.name like ? or p.price like ? or p.size like ?) %s \n";

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement  = connection.prepareStatement(FIND_ALL_PRODUCTS); //Trả về 1 tập các câu lệnh nen dùng executeQuery()

            System.out.println("findAll: " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery(); // Khi trả về 1 hoặc nhiều dòng

            //rs.next() kiểm tra xem có dòng tiếp theo không
            while (rs.next()){

                Product product = getProductFromResulSet(rs);


//                java.sql.Date updateAt = rs.getDate("update_at");
//                LocalDate localDate = updateAt.toLocalDate();
//                LocalDateTime localDateTime = localDate.atStartOfDay();
//                Instant updateAt = localDateTime.atZone(ZoneId.systemDefault()).toInstant();

                products.add(product);
            }
            connection.close();
        }catch (SQLException exception){
            printSQLException(exception);
        }

        return products;
    }

    private Product getProductFromResulSet(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        BigDecimal price = rs.getBigDecimal("price");
        LocalDate createAt = rs.getDate("create_at").toLocalDate();
        Product product = new Product(id, name, description, price, createAt);

        int idCate = rs.getInt("id_cate");
        String nameCate = rs.getString("name_cate");
        ProductType productType = new ProductType(idCate, nameCate);
        String sizeName = rs.getString("size");
        ESize eSize = ESize.findESize(sizeName);

        Date update   = rs.getDate("update_at");
        java.util.Date utilDate = new java.util.Date(update.getTime());
        Instant updateAt = utilDate.toInstant();
        product.setUpdateAt(updateAt);
        product.setProductType(productType);
        product.setSize(eSize);
        return product;
    }



    @Override
    public void save(Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `products` (`name`, `description`, `price`, `create_at`,`id_product_type`,`size`,`update_at`) VALUES (?, ?, ?, ?, ?,?, ?)");

            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setBigDecimal(3,product.getPrice());
            LocalDate createAt = product.getCreateAt();
            java.sql.Date sqlDate = java.sql.Date.valueOf(createAt);
            preparedStatement.setDate(4,sqlDate);
            preparedStatement.setInt(5, product.getProductType().getId());
            preparedStatement.setString(6, product.getSize().getName());
            Instant instant = product.getUpdateAt();
            java.sql.Date updateAt = new java.sql.Date(instant.toEpochMilli());
            preparedStatement.setDate(7, updateAt);
            System.out.println("save: " + preparedStatement);
            preparedStatement.executeUpdate(); // chỉ trả ra số dòng thực hiện thành công
            connection.close();
        }catch (SQLException exception){
            printSQLException(exception);
        }

    }

    @Override
    public Product findById(long id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);

            preparedStatement.setLong(1,id);

            System.out.println("findById : " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                long idProduct = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                LocalDate createAt = rs.getDate("create_at").toLocalDate();

                Product product = new Product(idProduct, name, description, price, createAt);

                int idCate = rs.getInt("id_cate");
                String nameCate = rs.getString("name_cate");
                ProductType pt = new ProductType(idCate, nameCate);

                String sizeName = rs.getString("size");
                ESize eSize = ESize.findESize(sizeName);
                Date update   = rs.getDate("update_at");
                java.util.Date utilDate = new java.util.Date(update.getTime());
                Instant updateAt = utilDate.toInstant();
                product.setUpdateAt(updateAt);
                product.setSize(eSize);
                product.setProductType(pt);
//                product.setProductType(new ProductType(idCate, nameCate));

                return product;
            }

        }catch (SQLException exception){
            printSQLException(exception);
        }
        return null;
    }

    @Override
    public void update(long id, Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `products` SET `name` = ?, `description` = ?, `price` = ?, `create_at` = ?,`id_product_type` = ?,`size` = ?, `update_at` = ? WHERE (`id` = ?)");

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setBigDecimal(3, product.getPrice());
            LocalDate createAt = product.getCreateAt();
            java.sql.Date sqlDate = java.sql.Date.valueOf(createAt);
            preparedStatement.setDate(4,sqlDate);
            preparedStatement.setInt(5, product.getProductType().getId());
            preparedStatement.setString(6, String.valueOf(ESize.findESize(product.getSize().getName())));
            Instant instant = product.getUpdateAt();
            java.sql.Date updateAt = new java.sql.Date(instant.toEpochMilli());
            preparedStatement.setDate(7, updateAt);
            preparedStatement.setLong(8, id);


            System.out.println("update: " + preparedStatement);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (SQLException exception){
            printSQLException(exception);
        }

    }

    @Override
    public void remove(long id) {

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `products` WHERE (`id` = ?)");

            preparedStatement.setLong(1,id);
            System.out.println("remove: " + preparedStatement);
            preparedStatement.executeUpdate();
            connection.close();
        }catch (SQLException exception){
            printSQLException(exception);
        }
    }

    @Override
    public List<Product> findProducts(Pageable pageable) {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = getConnection();

            //Lấy danh sách dữ liệu:
            String strProductType = "";
            if (pageable.getProductType() != -1) {
                strProductType = "and p.id_product_type = " + pageable.getProductType();
            }
            String fmSQL_FILTER = String.format(SQL_FILTER_PRODUCTS, strProductType);
            PreparedStatement pt = connection.prepareStatement(fmSQL_FILTER);
            pt.setString(1,"%" + pageable.getKw() + "%");
            pt.setString(2,"%" + pageable.getKw() + "%");
            pt.setString(3,"%" + pageable.getKw() + "%");
            pt.setInt(4,(pageable.getPage() - 1) * pageable.getLimit());
            pt.setInt(5, pageable.getLimit());

            System.out.println("findProducts" + pt);
            ResultSet rs = pt.executeQuery();
            while (rs.next()){
                Product product = getProductFromResulSet(rs);
                products.add(product);
            }


            // thực hiện đoạn này để tính total số dòng
            fmSQL_FILTER = String.format(SQL_FILTER_PRODUCTS_COUNT, strProductType);
            pt = connection.prepareStatement(fmSQL_FILTER);
            pt.setString(1,"%" + pageable.getKw() + "%");
            pt.setString(2,"%" + pageable.getKw() + "%");
            pt.setString(3,"%" + pageable.getKw() + "%");
            System.out.println("findProducts count row" + pt);
            rs = pt.executeQuery();
            while (rs.next()){
                int total = rs.getInt("total");
                //  tổng số dòng:8 dòng /3 = 2.7 => 3
                pageable.setTotal((int) Math.ceil((total * 1.0)/ pageable.getLimit()));

            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return products;
    }


}
