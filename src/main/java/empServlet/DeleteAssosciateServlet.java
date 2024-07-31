package empServlet;

import empDAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteAssosciateServlet")
public class DeleteAssosciateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        UserDAO userDAO = new UserDAO();

        boolean deleted = userDAO.deleteUser(id);

        if (deleted) {
            response.sendRedirect("ViewAssosciate.jsp");
        } else {
            response.sendRedirect("DeleteAssosciateFailure.jsp");
        }
    }
}
