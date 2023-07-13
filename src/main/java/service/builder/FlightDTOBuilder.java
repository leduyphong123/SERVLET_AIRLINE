package service.builder;

import dto.FlightDTO;
import entity.Flight;

import java.sql.Timestamp;

public class FlightDTOBuilder {
    private int id;
    private String toCity;
    private Timestamp toDate;
    private String formCity;
    private Timestamp formDate;
    private int usedCapacity;
    private boolean state;
    private int apId;
    private String apName;
    private String apShorName;
    private int apCapacity;
    public FlightDTOBuilder withApCapacity(int apCapacity){
        this.apCapacity = apCapacity;
        return this;
    }

    public FlightDTOBuilder withApName(String apName){
        this.apName = apName;
        return this;
    }
    public FlightDTOBuilder withApShortName(String shortName){
        this.apShorName = shortName;
        return this;
    }
    public FlightDTOBuilder withId(int id){
        this.id = id;
        return this;
    }
    public FlightDTOBuilder withToCity(String toCity){
        this.toCity = toCity;
        return this;
    }
    public FlightDTOBuilder withToDate(Timestamp toDate){
        this.toDate = toDate;
        return this;
    }
    public FlightDTOBuilder withFormCity(String formCity){
        this.formCity = formCity;
        return this;
    }
    public FlightDTOBuilder withFormDate(Timestamp formDate){
        this.formDate = formDate;
        return this;
    }
    public FlightDTOBuilder withUsedCapacity(int usedCapacity){
        this.usedCapacity = usedCapacity;
        return this;
    }
    public FlightDTOBuilder withState(boolean state){
        this.state = state;
        return this;
    }
    public FlightDTOBuilder withApId(int apId){
        this.apId = apId;
        return this;
    }
    public FlightDTO builder(){
        return new FlightDTO(id,toCity,toDate,formCity,formDate,usedCapacity,state,apId,apName,apShorName,apCapacity);
    }
}
