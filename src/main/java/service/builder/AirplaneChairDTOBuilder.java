package service.builder;

import dto.AirplaneChairDTO;

import java.time.LocalDate;
import java.sql.Date;

public class AirplaneChairDTOBuilder {
    private int id;
    private int quantity;
    private long price;
    private int used;
    private Date playDate;
    private boolean state;
    private int cId;
    private int apId;
    private String cName;
    private String apName;
    private String apShortName;
    private int apCapacity;

    public AirplaneChairDTOBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public AirplaneChairDTOBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public AirplaneChairDTOBuilder withPrice(long price) {
        this.price = price;
        return this;
    }

    public AirplaneChairDTOBuilder withUsed(int used) {
        this.used = used;
        return this;
    }

    public AirplaneChairDTOBuilder withPlayDate(Date playDate) {
        this.playDate = playDate;
        return this;
    }

    public AirplaneChairDTOBuilder withState(boolean state) {
        this.state = state;
        return this;
    }

    public AirplaneChairDTOBuilder withCId(int cId) {
        this.cId = cId;
        return this;
    }

    public AirplaneChairDTOBuilder withAId(int apId) {
        this.apId = apId;
        return this;
    }
    public AirplaneChairDTOBuilder withCName (String cName){
        this.cName = cName;
        return this;
    }
    public AirplaneChairDTOBuilder withApName (String apName){
        this.apName = apName;
        return this;
    }
    public AirplaneChairDTOBuilder withApShortName (String apShortName){
        this.apShortName = apShortName;
        return this;
    }
    public AirplaneChairDTOBuilder withApCapacity (int apCapacity){
        this.apCapacity = apCapacity;
        return this;
    }
    public AirplaneChairDTO builder (){
        return new AirplaneChairDTO(id,quantity,price,used,playDate,state,cId, apId,cName, apName, apShortName,apCapacity);
    }
}
