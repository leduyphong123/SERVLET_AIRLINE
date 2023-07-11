package service.builder;

import entity.Airline;
import entity.Airplane;

public class AirplaneBuilder {
    private int id;
    private String name;
    private String shortName;
    private int capacity;
    private int alId;
    public AirplaneBuilder withId(int id){
        this.id = id;
        return this;
    }
    public AirplaneBuilder withName (String name){
        this.name = name;
        return this;
    }
    public AirplaneBuilder withShortName(String shortName){
        this.shortName = shortName;
        return this;
    }
    public AirplaneBuilder withCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }
    public AirplaneBuilder withAirlineId(int alId){
        this.alId = alId;
        return this;
    }
    public Airplane builder(){
        return new Airplane(id,name,shortName,capacity,alId);
    }
}
