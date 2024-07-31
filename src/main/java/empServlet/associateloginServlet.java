package empServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import empDAO.AssosciateLoginDAO;

@WebServlet("/associateloginServlet")
public class associateloginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AssosciateLoginDAO assosciateLoginDAO;

    public associateloginServlet() {
        super();
        assosciateLoginDAO = new AssosciateLoginDAO(); // Initialize DAO
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform validation, authentication, and role retrieval logic
        String role = assosciateLoginDAO.getUserRole(username, password);

        if ("Associate".equals(role)) {
            // Create HTTP session and store the username as employee_name
            HttpSession session = request.getSession();
            session.setAttribute("employee_name", username);

            // Redirect to associate dashboard page
            response.sendRedirect("associateDashboard.jsp");
        } else {
            // Redirect to login page with error
            response.sendRedirect("associatelogin.html?error=1");
        }
    }
}
