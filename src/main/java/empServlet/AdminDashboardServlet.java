package empServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminDashboardServlet")
public class AdminDashboardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve the action parameter from the request
        String action = request.getParameter("action");
        
        if (action == null) {
            // Default action - Show the admin dashboard
            request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
        } else {
            switch (action) {
                case "CreateAssociate":
                    // Forward to the Create  Associate page
                    request.getRequestDispatcher("CreateAssosciate.jsp").forward(request, response);
                    break;
                
                case "ViewAssociate":
                    // Forward to the View  Associate page
                    request.getRequestDispatcher("ViewAssosciate.jsp").forward(request, response);
                    break;

                case "assignProjects":
                    // Forward to the View  Associate page
                    request.getRequestDispatcher("assignProjects.jsp").forward(request, response);
                    break;
               
               
                case "ViewAsssociateCharts":
                    // Forward to the View Associate Charts page
                    request.getRequestDispatcher("ViewAssosciateCharts.jsp").forward(request, response);
                    break;
                
               
                case "Logout.jsp":
                    // Forward to the logout page
                    request.getRequestDispatcher("Logout.jsp").forward(request, response);
                    break;
                default:
                    // Handle unknown actions
                    response.sendRedirect("adminDashboard.jsp");
                    break;
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Handle POST requests if needed
        // You can add code here to process form submissions for creating, editing, or deleting employees
    }
}
