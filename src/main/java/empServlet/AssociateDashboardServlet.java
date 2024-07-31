package empServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssociateDashboardServlet")
public class AssociateDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            request.getRequestDispatcher("associateDashboard.jsp").forward(request, response);
        } else {
            switch (action) {
                case "addtasks":
                    request.getRequestDispatcher("AddTasks.jsp").forward(request, response);
                    break;
                
                    
                
                case "logout":
                    request.getRequestDispatcher("associateLogout.jsp").forward(request, response);
                    break;
                default:
                    response.sendRedirect("associateDashboard.jsp");
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests if needed
    }
}
