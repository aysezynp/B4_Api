package apiPOJOTemplates;

public class PetStoreUser {
    /**
        "id": 9223372036854776000,
            "username": "Miky",
            "firstName": "mike",
            "lastName": "masters",
            "email": "mike@gmail.com",
            "password": "Test1234",
            "phone": "55512345",
            "userStatus": 0
     */
    private double Id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
    private double userStatus;

    public PetStoreUser() {

    }

    public PetStoreUser(double id, String username, String firstname,
                        String lastname, String email, String password, String phone, double userStatus) {
        Id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
    }

    public void setId(double id) {
        Id = id;
    }

    public double getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(double userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "PetStoreUser{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}

