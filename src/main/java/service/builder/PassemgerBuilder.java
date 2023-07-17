package service.builder;

import entity.Passenger;

import java.sql.Date;

public class PassemgerBuilder {
    private int bookingId;
    private String firtName;
    private String middleName;
    private String lastName;
    private Date birth;
    private String email;
    private String address;
    public PassemgerBuilder withBookingId(int bookingId) {
        this.bookingId =bookingId;
        return this;
    }

    public PassemgerBuilder withFirtName(String firtName) {
        this.firtName =firtName;
        return this;
    }

    public PassemgerBuilder withMiddleName(String middleName) {
        this.middleName =middleName;
        return this;
    }

    public PassemgerBuilder withLastName(String lastName) {
        this.lastName =lastName;
        return this;
    }

    public PassemgerBuilder withBirthDate(Date birth) {
        this.birth =birth;
        return this;
    }

    public PassemgerBuilder withEmail(String email) {
        this.email =email;
        return this;
    }

    public PassemgerBuilder withAddress(String address) {
        this.address =address;
        return this;
    }

    public Passenger builder() {
        return new Passenger(bookingId,firtName,middleName,lastName,birth,email,address);
    }
}
