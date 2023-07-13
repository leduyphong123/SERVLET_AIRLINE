package service.builder;

import entity.Flight;

import java.sql.Timestamp;

public class FlightBuilder {
    private int id;
    private int toCity;
    private Timestamp toDate;
    private int formCity;
    private Timestamp formDate;
    private int usedCapacity;
    private boolean state;
    private int apId;
    public FlightBuilder withId(int id){
        this.id = id;
        return this;
    }
    public FlightBuilder withToCity(int toCity){
        this.toCity = toCity;
        return this;
    }
    public FlightBuilder withToDate(Timestamp toDate){
        this.toDate = toDate;
        return this;
    }
    public FlightBuilder withFormCity(int formCity){
        this.formCity = formCity;
        return this;
    }
    public FlightBuilder withFormDate(Timestamp formDate){
        this.formDate = formDate;
        return this;
    }
    public FlightBuilder withUsedCapacity(int usedCapacity){
        this.usedCapacity = usedCapacity;
        return this;
    }
    public FlightBuilder withState(boolean state){
        this.state = state;
        return this;
    }
    public FlightBuilder withApId(int apId){
        this.apId = apId;
        return this;
    }
    public Flight builder(){
        return new Flight(id,toCity,toDate,formCity,formDate,usedCapacity,state,apId);
    }
}
