package EMPmodel;

public class Project {

    private int id;
    private String projectName;
    private String employeeName; // Changed from employeeId to employeeName
    private String deadline;
    private String description;

    // Default constructor
    public Project() {}

    // Parameterized constructor
    public Project(int id, String projectName, String employeeName, String deadline, String description) {
        this.id = id;
        this.projectName = projectName;
        this.employeeName = employeeName;
        this.deadline = deadline;
        this.description = description;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", projectName=" + projectName + ", employeeName=" + employeeName + ", deadline="
                + deadline + ", description=" + description + "]";
    }
}
