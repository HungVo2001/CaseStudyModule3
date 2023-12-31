package controrler;

import appconfig.AppConfig;
import model.User;
import service.IUserService;
import service.UserService;
import untils.PasswordUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        String password = req.getParameter("password");
        User user = userService.findUserByUserName(username);
        if (user != null && PasswordUtils.isValidPassword(password, user.getPassword())) {
            req.getSession().setAttribute("user", user);
            req.getSession().setAttribute("nane", user.getUsername());
            resp.sendRedirect("/homes");
        }else {
            req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "login.jsp").forward(req, resp);
        }

    }
}
