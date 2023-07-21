package controrler;

import appconfig.AppConfig;
import model.Cart;
import model.Product;
import model.User;
import service.CartService;
import service.ICartService;
import service.IProductService;
import service.ProductServiceMysql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private IProductService productService;

    private ICartService iCartService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        iCartService = new CartService();
    }

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceMysql();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                addToCartView(req,resp);
            break;
            case "update":
                break;
        }
         req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "cart.jsp").forward(req,resp);


    }

    private void addToCartView(HttpServletRequest req, HttpServletResponse resp) {
        int idProduct = Integer.parseInt(req.getParameter("id"));
        int quantity = 1;

        User user = (User) req.getSession().getAttribute("user");
        iCartService.addToCart(idProduct, quantity, user.getId());

        Cart cart = iCartService.getCartById(user.getId());
        req.setAttribute("cart", cart);
    }
}
