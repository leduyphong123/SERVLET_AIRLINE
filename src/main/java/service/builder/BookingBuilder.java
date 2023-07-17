package service.builder;

import entity.Booking;

import java.sql.Timestamp;

public class BookingBuilder {
    private int id;
    private Timestamp bookingDate;
    private int luggage;
    private long price;
    private String state;
    private int acountId;
    private int flightId;
    public BookingBuilder withId(int id){
        this.id=id;
        return this;
    }
    public BookingBuilder withBookingDate(Timestamp bookingDate){
        this.bookingDate=bookingDate;
        return this;
    }
    public BookingBuilder withluggage(int luggage){
        this.luggage=luggage;
        return this;
    }
    public BookingBuilder withState(String state){
        this.state=state;
        return this;
    }
    public BookingBuilder withAcountId(int acountId){
        this.acountId=acountId;
        return this;
    }
    public BookingBuilder withFlightId(int flightId){
        this.flightId=flightId;
        return this;
    }
    public BookingBuilder withPrice(long price){
        this.price=price;
        return this;
    }
    public Booking builder(){
        return new Booking(id,bookingDate,luggage,price,state,acountId,flightId);
    }
}
