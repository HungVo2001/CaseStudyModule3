package controrler;

import appconfig.AppConfig;
import model.Bill;
import model.Cart;
import model.Product;
import model.User;
import service.BillService;
import service.IBillService;
import service.IProductService;
import service.ProductServiceMysql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PaymentServlet", urlPatterns = "/payment")
public class PaymentServlet extends HttpServlet {
    IBillService billService;
    @Override
    public void init() throws ServletException {
        billService = new BillService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            resp.sendRedirect("/login");
            return;
        }

        Bill payment = billService.findPayment(user.getId());
        req.setAttribute("payments", payment);
        req.getRequestDispatcher("payment.jsp").forward(req,resp);
    }

}
