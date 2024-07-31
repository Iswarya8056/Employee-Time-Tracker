package empServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import empDAO.AdminLoginDAO;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminLoginDAO adminLoginDAO;

    public AdminLoginServlet() {
        super();
        adminLoginDAO = new AdminLoginDAO(); // Initialize DAO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handling GET requests (if any)
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform validation, authentication, and role retrieval logic
        String role = adminLoginDAO.getUserRole(username, password);

        if ("Admin".equals(role)) {
            // Redirect to admin success page
            response.sendRedirect("adminDashboard.jsp");
        } else {
            // Redirect to admin failure page
            response.sendRedirect("adminlogin.html?error=1");
        }
    }
}
