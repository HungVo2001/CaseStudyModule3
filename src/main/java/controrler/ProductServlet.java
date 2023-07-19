package controrler;

import appconfig.AppConfig;
import model.ESize;
import model.Pageable;
import model.Product;
import model.ProductType;
import service.IProductService;
import service.IProductTypeService;
import service.ProductServiceMysql;
import service.ProductTypeServiceMysql;
import untils.ValidatesUntils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductServiceMysql();
    private IProductTypeService productTypeService = new ProductTypeServiceMysql();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(req, resp);
                break;
            case "edit":
                showEdit(req, resp);
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            default:
                showList(req, resp);

        }

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long id = Long.parseLong(req.getParameter("id"));
        productService.remove(id);

        req.getSession().setAttribute("messageDelete", "Xóa thành công");
        resp.sendRedirect("/products");
    }

    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long idProduct = Long.parseLong(req.getParameter("id"));

        Product product = productService.findById(idProduct);
        req.setAttribute("product", product);

        List<ProductType> productTypes = productTypeService.findAll();
        req.setAttribute("productTypes", productTypes);
        req.setAttribute("sizes", ESize.values());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD + "products/edit.jsp");
        requestDispatcher.forward(req, resp);

    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pageable pageable = new Pageable();
        readPageable(req,pageable);

        productService.findProducts(pageable);

        List<Product> productList = productService.findProducts(pageable);
        req.setAttribute("products", productList);
        req.setAttribute("pageable", pageable);


        List<ProductType> productTypes = productTypeService.findAll();
        req.setAttribute("productTypes", productTypes);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD + "products/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void readPageable(HttpServletRequest req, Pageable pageable) {
        String kw = "";
        if (req.getParameter("kw") != null){
            kw = req.getParameter("kw");

        }
        pageable.setKw(kw);
        int productType = -1;
        if (req.getParameter("product-type") != null){
            productType = Integer.parseInt(req.getParameter("product-type"));

        }
        pageable.setProductType(productType);
        int page = 1;
        if (req.getParameter("page") != null){
            page = Integer.parseInt(req.getParameter("page"));

        }
        pageable.setPage(page);
        int limit = 5;
        if (req.getParameter("limit") != null){
            limit = Integer.parseInt(req.getParameter("limit"));

        }
        pageable.setLimit(limit);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ProductType> productTypes = productTypeService.findAll();

        req.setAttribute("productTypes", productTypes);
        req.setAttribute("sizes", ESize.values());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD +  "products/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                saveProduct(req, resp);
                break;
            case "edit":
                updateProduct(req, resp);
                break;
        }
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Product product = new Product();
        List<String> errors = new ArrayList<>();
        validateIdProduct(req, product, errors);
        validateName(req, product, errors);
        validateDescription(req,product, errors);
        validatePrice(req, product, errors);
        validateProductType(req, product, errors);
//        validateSizeProduct(req, product, errors);
        validateCreateAt(req, product, errors);
//        long id = Long.parseLong(req.getParameter("id"));
//        String name = req.getParameter("name");
//        String description = req.getParameter("description");
//        BigDecimal price = new BigDecimal(req.getParameter("price"));


        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate createAt = LocalDate.parse(req.getParameter("createAt"), DATEFORMATTER);
        int sizeId = Integer.parseInt(req.getParameter("size"));
        ESize eSize = ESize.findESize(sizeId);
//        String updateAtStr = req.getParameter("updateAt");
//        LocalDate date = LocalDate.parse(updateAtStr);
//        LocalDateTime dateTime = date.atStartOfDay();
//        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneOffset.UTC);
//        String updateAtStr1 = zonedDateTime.format(DateTimeFormatter.ISO_INSTANT);
//        Instant updateAt = Instant.parse(updateAtStr1);
        LocalDate now = LocalDate.now();


        product.setCreateAt(createAt);
        product.setUpdateAt(now.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC));

        product.setSize(eSize);

//        if (errors.size() == 0){
//            int idCate = Integer.parseInt(req.getParameter("product-type"));
//            ProductType pt = productTypeService.findById(idCate);
//            product.setProductType(pt);
//            productService.update(product.getId(), product);
//            req.getSession().setAttribute("messageEdit", "Sửa thành công");
//            resp.sendRedirect("/products");
//        }else {
//            req.setAttribute("errors", errors);
//            req.setAttribute("product", product);
//            List<ProductType> productTypes = productTypeService.findAll();
//            req.setAttribute("productTypes", productTypes);
//            ESize[] eSizes = ESize.values();
//            req.setAttribute("sizes",eSizes);
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/products/edit.jsp");
//            requestDispatcher.forward(req, resp);
//        }
        if(!errors.isEmpty()){
            req.setAttribute("errors", errors);
            req.setAttribute("product", product);

            List<ProductType> productTypes = productTypeService.findAll();
            req.setAttribute("productTypes", productTypes);
            ESize[] sizes = ESize.values();
            req.setAttribute("sizes", sizes);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD +  "products/edit.jsp");
            requestDispatcher.forward(req, resp);

        }
        else {
            productService.update(product.getId(), product);
//            req.setAttribute("updateAt", updateAt);
            req.getSession().setAttribute("messageEdit", "Sửa thành công");
            resp.sendRedirect("/products");            // Dùng respone để sendRedirect
        }
    }

    private void validateCreateAt(HttpServletRequest req, Product product, List<String> errors) {

    }

    private void saveProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = new Product();
        List<String> errors = new ArrayList<>();

        validateName(req, product, errors);
        validateDescription(req,product, errors);
        validatePrice(req, product, errors);
//        validateSizeProduct(req, product, errors);
        validateProductType(req, product, errors);
//        String name = req.getParameter("name");
//        String description = req.getParameter("description");
//        BigDecimal price = new BigDecimal(req.getParameter("price"));
//        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate createAt = LocalDate.now();


//        long id = (long)(Math.random() * 10000);
//        Product product = new Product(id, name, description, price,createAt);

//        String updateAtStr = req.getParameter("updateAt");
//        LocalDate date = LocalDate.parse(updateAtStr);
//        LocalDateTime dateTime = date.atStartOfDay();
//        ZonedDateTime zonedDateTime = dateTime.atZone(ZoneOffset.UTC);
//        String updateAtStr1 = zonedDateTime.format(DateTimeFormatter.ISO_INSTANT);
//        Instant updateAt = Instant.parse(updateAtStr1);
        product.setCreateAt(createAt);
        product.setUpdateAt(createAt.plusDays(1).atStartOfDay().toInstant(ZoneOffset.UTC));

//            int idCate = Integer.parseInt(req.getParameter("product-type"));
//            ProductType pt = productTypeService.findById(idCate);

            int sizeId = Integer.valueOf(req.getParameter("size"));
            ESize eSize = ESize.findESize(sizeId);
            product.setSize(eSize);
//
//            product.setProductType(pt);
//            productService.save(product);

            List<ProductType> productTypes = productTypeService.findAll();
            req.setAttribute("productTypes", productTypes);
            ESize[] eSizes = ESize.values();
            req.setAttribute("sizes",eSizes);
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("product", product);
        }else{
            req.setAttribute("message", "Thêm thành công");
            productService.save(product);
        }

//            req.setAttribute("message", "Thêm thành công");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher( "/products/create.jsp");
            requestDispatcher.forward(req, resp);

    }
    private void validateIdProduct(HttpServletRequest req, Product product, List<String> errors) {
        try {
            long id = Long.parseLong(req.getParameter("id"));
            if (productService.findById(id) == null){
                errors.add("Mã sản phẩm không hợp lệ");
            }
            product.setId(id);
        }catch (NumberFormatException numberFormatException){
            errors.add("Định dạng mã sản phẩm không hợp lệ");
        }
    }
    private void validateProductType(HttpServletRequest req, Product product, List<String> errors){
        ProductType pt = null;
        try {
            // idCate có 2 trường hợp: "aaa" hoặc mã ko hợp lệ ko có trong DB 20000
            int idCate = Integer.parseInt(req.getParameter("product-type"));
            pt = productTypeService.findById(idCate);
            if(pt == null){
                errors.add("Loại sản phẩm không có trong CSDL");
            }

        }catch (NumberFormatException numberFormatException){
            errors.add("Định dạng loại sản phẩm không hợp lệ");
        }
        product.setProductType(pt);
    }
    private void validateName(HttpServletRequest req, Product product, List<String> errors){
        String name = req.getParameter("name");
        if(!ValidatesUntils.isUserNameValid(name)){
            errors.add("Tên không hợp lệ, bắt đầu bằng chữ cái và phải có từ 8-20 kí tự");
        }
        product.setName(name);
    }
    private void validateDescription(HttpServletRequest req, Product product, List<String> errors){
        String description = req.getParameter("description");
        if (!ValidatesUntils.isValidDescription(description)){
            errors.add("Mô tả không hợp lệ,bắt đầu bằng chữ cái và số phải có từ 8-49 kí tự");
        }
        product.setDescription(description);
    }
    private void validatePrice(HttpServletRequest req, Product product, List<String> errors){
        String priceParameter = req.getParameter("price");
        if (priceParameter != null && !priceParameter.isEmpty()){
            try {
                BigDecimal price = new BigDecimal(priceParameter);
                product.setPrice(price);
                if (price.compareTo(BigDecimal.ZERO) <= 0){
                    errors.add("Giá sản phẩm phải lớn hơn 0");
                }
            }catch (NumberFormatException numberFormatException){
                errors.add("Giá sản phẩm không hợp lệ");
            }
        }else {
            errors.add("Giá sản phẩm không được bỏ trống");
        }

    }
    private void validateSizeProduct(HttpServletRequest req, Product product, List<String> errors) {
        ESize eSize = null;
        try {
            // idCate có 2 trường hợp: "aaa" hoặc mã ko hợp lệ ko có trong DB 20000
            int idSize = Integer.parseInt(req.getParameter("size"));
            eSize = ESize.findESize(idSize);

            if (eSize == null) {
                errors.add("size sản phẩm không có trong csdl");
            }
        } catch (NumberFormatException numberFormatException) {
            errors.add("Định dạng của size sản phẩm không hợp lệ");
        }
        product.setSize(eSize);
    }

}
