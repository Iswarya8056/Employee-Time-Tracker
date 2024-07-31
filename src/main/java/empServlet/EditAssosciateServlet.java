package empServlet;

import empDAO.UserDAO;
import EMPmodel.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditAssosciateServlet")
public class EditAssosciateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(id);

        if (user != null) {
            request.setAttribute("user", user);
            request.getRequestDispatcher("EditAssosciate.jsp").forward(request, response);
        } else {
            response.sendRedirect("ViewAssosciate.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String username = request.getParameter("username");
        String password = request.getParameter("password"); // Ensure this field is present in the form
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String mobileNo = request.getParameter("mobileNo");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");

        User user = new User(id, userName, username, password, role, email, mobileNo, dateOfBirth, address);
        UserDAO userDAO = new UserDAO();
        boolean updated = userDAO.updateUser(user);

        if (updated) {
            response.sendRedirect("ViewAssosciate.jsp");
        } else {
            response.sendRedirect("EditAssosciateFailure.jsp");
        }
    }
}
