package service.builder;

import entity.Airline;

public class AirlineBuilder {
    private int id;
    private String name;
    private String shortName;
    private boolean state;

    public AirlineBuilder withId(int id){
        this.id = id;
        return this;
    }
    public AirlineBuilder withName (String name){
        this.name = name;
        return this;
    }
    public AirlineBuilder withShortName(String shortName){
        this.shortName = shortName;
        return this;
    }
    public AirlineBuilder withState(boolean state){
        this.state = state;
        return this;
    }
    public Airline builder(){
        return new Airline(id,name,shortName,state);
    }
}
