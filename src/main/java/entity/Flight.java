package entity;

import java.sql.Timestamp;

public class Flight {
    private int id;
    private int toCity;
    private Timestamp  toDate;
    private int formCity;
    private Timestamp formDate;
    private int usedCapacity;
    private boolean state;
    private int apId;

    public Flight() {
    }

    public Flight(int id, int toCity, Timestamp toDate, int formCity, Timestamp formDate, int usedCapacity, boolean state, int apId) {
        this.id = id;
        this.toCity = toCity;
        this.toDate = toDate;
        this.formCity = formCity;
        this.formDate = formDate;
        this.usedCapacity = usedCapacity;
        this.state = state;
        this.apId = apId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToCity() {
        return toCity;
    }

    public void setToCity(int toCity) {
        this.toCity = toCity;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public int getFormCity() {
        return formCity;
    }

    public void setFormCity(int formCity) {
        this.formCity = formCity;
    }

    public Timestamp getFormDate() {
        return formDate;
    }

    public void setFormDate(Timestamp formDate) {
        this.formDate = formDate;
    }

    public int getUsedCapacity() {
        return usedCapacity;
    }

    public void setUsedCapacity(int usedCapacity) {
        this.usedCapacity = usedCapacity;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getApId() {
        return apId;
    }

    public void setApId(int apId) {
        this.apId = apId;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", toCity=" + toCity +
                ", toDate=" + toDate +
                ", formCity=" + formCity +
                ", formDate=" + formDate +
                ", usedCapacity=" + usedCapacity +
                ", state=" + state +
                ", apId=" + apId +
                '}';
    }
}
