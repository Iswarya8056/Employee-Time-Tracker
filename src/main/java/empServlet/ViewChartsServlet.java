package empServlet;

import empDAO.TaskDAO1;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/ViewChartsServlet")
public class ViewChartsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String timePeriod = request.getParameter("timePeriod");
        TaskDAO1 taskDAO = new TaskDAO1();

        if ("daily".equalsIgnoreCase(timePeriod)) {
            Map<String, Double> data = taskDAO.getDailyData();
            JFreeChart pieChart = createPieChart(data, "Daily Task Distribution");
            response.setContentType("image/png");
            ChartUtils.writeChartAsPNG(response.getOutputStream(), pieChart, 800, 600);
        } else if ("weekly".equalsIgnoreCase(timePeriod)) {
            Map<String, Double> data = taskDAO.getWeeklyData();
            JFreeChart barChart = createBarChart(data, "Weekly Task Distribution");
            response.setContentType("image/png");
            ChartUtils.writeChartAsPNG(response.getOutputStream(), barChart, 800, 600);
        } else if ("monthly".equalsIgnoreCase(timePeriod)) {
            Map<String, Double> data = taskDAO.getMonthlyData();
            JFreeChart barChart = createBarChart(data, "Monthly Task Distribution");
            response.setContentType("image/png");
            ChartUtils.writeChartAsPNG(response.getOutputStream(), barChart, 800, 600);
        }
    }

    private JFreeChart createPieChart(Map<String, Double> data, String title) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        return ChartFactory.createPieChart(title, dataset, true, true, false);
    }

    private JFreeChart createBarChart(Map<String, Double> data, String title) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Double> entry : data.entrySet()) {
            dataset.addValue(entry.getValue(), entry.getKey(), entry.getKey());
        }
        return ChartFactory.createBarChart(title, "Category", "Duration", dataset, PlotOrientation.VERTICAL, true, true, false);
    }
}
