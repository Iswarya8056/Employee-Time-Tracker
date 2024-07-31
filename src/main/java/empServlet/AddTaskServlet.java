package empServlet;

import empDAO.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projectName = request.getParameter("project_name");
        String employeeName = request.getParameter("employee_name");
        int projectId = Integer.parseInt(request.getParameter("project_id"));
        String taskCategory = request.getParameter("task_category");
        String taskDate = request.getParameter("task_date");
        String startTime = request.getParameter("start_time");
        String endTime = request.getParameter("end_time");
        double duration = Double.parseDouble(request.getParameter("duration"));
        String description = request.getParameter("description");

        TaskDAO taskDAO = new TaskDAO();
        boolean isAdded = taskDAO.addTask(projectName, employeeName, projectId, taskCategory, taskDate, startTime, endTime, duration, description);

        if (isAdded) {
            response.sendRedirect("tasksuccess.jsp"); // Redirect to a success page
        } else {
            response.sendRedirect("taskfailure.jsp"); // Redirect to an error page
        }
    }
}
