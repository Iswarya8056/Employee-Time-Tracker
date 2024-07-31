package EMPmodel;



public class User {
   
    private int id;
    private String userName;
    private String username;
    private String password;
    private String role;
    private String email;
    private String mobileNo;
    private String dateOfBirth;
    private String address;

    // Default constructor
    public User() {}

    // Parameterized constructor
    public User(int id, String userName, String username, String password, String role, String email, String mobileNo, String dateOfBirth, String address) {
        this.id = id;
        this.userName = userName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.mobileNo = mobileNo;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", username=" + username + ", password=" + password +
               ", role=" + role + ", email=" + email + ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth +
               ", address=" + address + "]";
    }
}

