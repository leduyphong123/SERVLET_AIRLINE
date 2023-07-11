package service.builder;

import dto.AirplaneDTO;
import entity.Airplane;

public class AirplaneDTOBuilder {
    private int id;
    private String name;
    private String shortName;
    private int capacity;
    private int alId;
    private String alName;
    private String alShortName;
    public AirplaneDTOBuilder withId(int id){
        this.id = id;
        return this;
    }
    public AirplaneDTOBuilder withName (String name){
        this.name = name;
        return this;
    }
    public AirplaneDTOBuilder withShortName(String shortName){
        this.shortName = shortName;
        return this;
    }
    public AirplaneDTOBuilder withCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }
    public AirplaneDTOBuilder withAirlineId(int alId){
        this.alId = alId;
        return this;
    }
    public AirplaneDTOBuilder withAirlineName(String alName){
        this.alName = alName;
        return this;
    }
    public AirplaneDTOBuilder withAirlineShortName(String alShortName){
        this.alShortName = alShortName;
        return this;
    }
    public AirplaneDTO builder(){
        return new AirplaneDTO(id,name,shortName,capacity,alId,alName,alShortName);
    }
}
