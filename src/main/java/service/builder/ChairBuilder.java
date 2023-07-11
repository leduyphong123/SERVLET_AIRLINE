package service.builder;

import entity.Chair;
import entity.City;

public class ChairBuilder {
    private int id;
    private String name;
    private boolean state;

    public ChairBuilder withId(int id){
        this.id = id;
        return this;
    }
    public ChairBuilder withName (String name){
        this.name = name;
        return this;
    }
    public ChairBuilder withState(boolean state){
        this.state = state;
        return this;
    }
    public Chair builder(){
        return new Chair(id,name,state);
    }
}
