package EMPmodel;

public class Employee {
    private int id;
    private String userName;

    // Default constructor
    public Employee() {}

    // Parameterized constructor
    public Employee(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", userName=" + userName + "]";
    }
}
