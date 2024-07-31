package empServlet;



import empDAO.CreateAssosciateDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateAssosciateServlet")
public class CreateAssosciateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Handles GET requests
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the JSP page to display the form
        request.getRequestDispatcher("CreateAssosciate.jsp").forward(request, response);
    }

    // Handles POST requests
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String userName = request.getParameter("user_name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role"); // Should default to "Associate"
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        String dob = request.getParameter("dob");
        String address = request.getParameter("address");

        // Create DAO instance
        CreateAssosciateDAO dao = new CreateAssosciateDAO();
        boolean isSuccess = dao.createAssociate(userName, username, password, role, email, mobile, dob, address);

        // Redirect or forward to a result page
        if (isSuccess) {
            response.sendRedirect("success.jsp"); // Assume you have a success.jsp page
        } else {
            response.sendRedirect("failure.jsp"); // Assume you have a failure.jsp page
        }
    }
}
