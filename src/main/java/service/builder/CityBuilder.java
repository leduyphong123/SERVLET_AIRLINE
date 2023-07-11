package service.builder;

import entity.City;

public class CityBuilder {
    private int id;
    private String name;
    private String shortName;

    public CityBuilder withId(int id){
        this.id = id;
        return this;
    }
    public CityBuilder withName (String name){
        this.name = name;
        return this;
    }
    public CityBuilder withShortName(String shortName){
        this.shortName = shortName;
        return this;
    }
    public City builder(){
        return new City(id,name,shortName);
    }
}
