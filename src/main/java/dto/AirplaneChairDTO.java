package dto;

import java.time.LocalDate;
import java.sql.Date;

public class AirplaneChairDTO {
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

    public AirplaneChairDTO() {
    }

    public AirplaneChairDTO(int id, int quantity, long price, int used, Date playDate, boolean state, int cId, int apId, String cName, String apName, String apShortName, int apCapacity) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.used = used;
        this.playDate = playDate;
        this.state = state;
        this.cId = cId;
        this.apId = apId;
        this.cName = cName;
        this.apName = apName;
        this.apShortName = apShortName;
        this.apCapacity = apCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getUsed() {
        return used;
    }

    public void setUsed(int used) {
        this.used = used;
    }

    public Date getPlayDate() {
        return playDate;
    }

    public void setPlayDate(Date playDate) {
        this.playDate = playDate;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getApId() {
        return apId;
    }

    public void setApId(int apId) {
        this.apId = apId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }



    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName;
    }

    public String getApShortName() {
        return apShortName;
    }

    public void setApShortName(String apShortName) {
        this.apShortName = apShortName;
    }

    public int getApCapacity() {
        return apCapacity;
    }

    public void setApCapacity(int apCapacity) {
        this.apCapacity = apCapacity;
    }

    @Override
    public String toString() {
        return "AirplaneChairDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", used=" + used +
                ", playDate=" + playDate +
                ", state=" + state +
                ", cId=" + cId +
                ", alId=" + apId +
                ", cName='" + cName + '\'' +
                ", alName='" + apName + '\'' +
                ", alShortName='" + apShortName + '\'' +
                ", alCapacity=" + apCapacity +
                '}';
    }
}
