package entity;

import java.sql.Date;
import java.time.LocalDate;

public class AirplaneChair {
    private int id;
    private int quantity;
    private long price;
    private int used;
    private Date playDate;
    private boolean state;
    private int cId;
    private int apId;

    public AirplaneChair() {
    }

    public AirplaneChair(int id, int quantity, long price, int used, Date playDate, boolean state, int cId, int apId) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.used = used;
        this.playDate = playDate;
        this.state = state;
        this.cId = cId;
        this.apId = apId;
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

    @Override
    public String toString() {
        return "AirplaneChair{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", used=" + used +
                ", playDate=" + playDate +
                ", state=" + state +
                ", cId=" + cId +
                ", alId=" + apId +
                '}';
    }
}
