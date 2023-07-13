package service.builder;

import entity.AirplaneChair;


import java.sql.Date;

public class AirplaneChairBuilder {
    private int id;
    private int quantity;
    private long price;
    private int used;
    private Date playDate;
    private boolean state;
    private int cId;
    private int apId;

    public AirplaneChairBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AirplaneChairBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public AirplaneChairBuilder withPrice(long price) {
        this.price = price;
        return this;
    }

    public AirplaneChairBuilder withUsed(int used) {
        this.used = used;
        return this;
    }

    public AirplaneChairBuilder withPlayDate(Date playDate) {
        this.playDate = playDate;
        return this;
    }

    public AirplaneChairBuilder withState(boolean state) {
        this.state = state;
        return this;
    }

    public AirplaneChairBuilder withCId(int cId) {
        this.cId = cId;
        return this;
    }

    public AirplaneChairBuilder withApId(int apId) {
        this.apId = apId;
        return this;
    }
    public AirplaneChair builder(){
        return new AirplaneChair(id,quantity,price,used,playDate,state,cId, apId);
    }
}
