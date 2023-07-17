package entity;

import java.sql.Timestamp;

public class Booking {
    private int id;
    private Timestamp bookingDate;
    private int luggage;
    private long price;
    private String state;
    private int acountId;
    private int flightId;

    public Booking(int id, Timestamp bookingDate, int luggage, long price, String state, int acountId, int flightId) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.luggage = luggage;
        this.price = price;
        this.state = state;
        this.acountId = acountId;
        this.flightId = flightId;
    }

    public Booking() {
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", luggage=" + luggage +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", acountId=" + acountId +
                ", flightId=" + flightId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getLuggage() {
        return luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage = luggage;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAcountId() {
        return acountId;
    }

    public void setAcountId(int acountId) {
        this.acountId = acountId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}
