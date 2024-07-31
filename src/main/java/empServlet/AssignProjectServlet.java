package empServlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import EMPmodel.Project;
import empDAO.ProjectDAO;

@WebServlet("/AssignProjectServlet")
public class AssignProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;

    @Override
    public void init() throws ServletException {
        projectDAO = new ProjectDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeName = request.getParameter("employee_name");
        String projectName = request.getParameter("project_name");
        String deadline = request.getParameter("deadline");
        String description = request.getParameter("description");

        // Debugging statements
        System.out.println("Received parameters:");
        System.out.println("Employee Name: " + employeeName);
        System.out.println("Project Name: " + projectName);
        System.out.println("Deadline: " + deadline);
        System.out.println("Description: " + description);

        Project project = new Project();
        project.setProjectName(projectName);
        project.setEmployeeName(employeeName);
        project.setDeadline(deadline);
        project.setDescription(description);

        try {
            projectDAO.assignProject(project);
            response.sendRedirect("Assingsuccess.jsp"); // Redirect to a success page
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQLException: " + e.getMessage()); // Print SQL exception details
            response.sendRedirect("Assignerror.jsp"); // Redirect to an error page
        }
    }
}
