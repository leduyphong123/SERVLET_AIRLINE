package entity;

import java.sql.Date;

public class Passenger {
    private int bookingId;
    private String firtName;
    private String middleName;
    private String lastName;
    private Date birth;
    private String email;
    private String address;

    public Passenger() {
    }

    public Passenger(int bookingId, String firtName, String middleName, String lastName, Date birth, String email, String address) {
        this.bookingId = bookingId;
        this.firtName = firtName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birth = birth;
        this.email = email;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "bookingId=" + bookingId +
                ", firtName='" + firtName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
