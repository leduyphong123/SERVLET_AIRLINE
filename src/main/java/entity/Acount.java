package entity;

public class Acount {
    private int id;
    private String name;
    private String email;
    private String password;
    private String state;

    public Acount() {
    }

    public Acount(int id, String name, String email, String password, String state) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Acount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
