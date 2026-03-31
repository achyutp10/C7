package learninglog.user.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import learninglog.user.model.User;
import learninglog.user.model.dao.UserDAO;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;

@WebServlet("/user-auth")
public class UserController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        String action = request.getParameter("action");

        if (action.equals("register")) {

            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            if (password.length() < 8) {
                request.setAttribute("error", "Password must be greater than 8 characters");
                request.getRequestDispatcher("views/register.jsp").forward(request,response);
                return;
            }

            String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

            User user = new User(name,email,hashedPassword,role);

            userDAO.registerUser(user);
            response.sendRedirect("/views/login.jsp");
        } else if (action.equals("login")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = userDAO.loginUser(email,password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                if (user.getRole().equals("ADMIN")) {
                    response.sendRedirect("views/admin.jsp");
                } else {
                    response.sendRedirect("views/dashboard.jsp");
                }
            }
        } else if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("views/login.jsp");

        }
    }
}
