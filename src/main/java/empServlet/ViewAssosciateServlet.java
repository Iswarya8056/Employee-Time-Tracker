package empServlet;

import empDAO.UserDAO;
import EMPmodel.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ViewAssosciateServlet")
public class ViewAssosciateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDAO userDAO = new UserDAO();
        List<User> associates = userDAO.getAllUsers();

        request.setAttribute("associates", associates);
        request.getRequestDispatcher("ViewAssosciate.jsp").forward(request, response);
    }
}
