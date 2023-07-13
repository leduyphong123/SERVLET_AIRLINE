package dto;

import java.sql.Timestamp;

public class FlightDTO {
    private int id;
    private String toCity;
    private Timestamp toDate;
    private String formCity;
    private Timestamp formDate;
    private int usedCapacity;
    private boolean state;
    private int apId;
    private String apName;
    private String apShorName;
    private int apCapacity;

    public FlightDTO() {
    }

    public FlightDTO(int id, String toCity, Timestamp toDate, String formCity, Timestamp formDate, int usedCapacity, boolean state, int apId, String apName, String apShorName, int apCapacity) {
        this.id = id;
        this.toCity = toCity;
        this.toDate = toDate;
        this.formCity = formCity;
        this.formDate = formDate;
        this.usedCapacity = usedCapacity;
        this.state = state;
        this.apId = apId;
        this.apName = apName;
        this.apShorName = apShorName;
        this.apCapacity = apCapacity;
    }

    public int getApCapacity() {
        return apCapacity;
    }

    public void setApCapacity(int apCapacity) {
        this.apCapacity = apCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    public String getFormCity() {
        return formCity;
    }

    public void setFormCity(String formCity) {
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

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName;
    }

    public String getApShorName() {
        return apShorName;
    }

    public void setApShorName(String apShorName) {
        this.apShorName = apShorName;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "id=" + id +
                ", toCity='" + toCity + '\'' +
                ", toDate=" + toDate +
                ", formCity='" + formCity + '\'' +
                ", formDate=" + formDate +
                ", usedCapacity=" + usedCapacity +
                ", state=" + state +
                ", apId=" + apId +
                ", apName='" + apName + '\'' +
                ", apShorName='" + apShorName + '\'' +
                ", apCapacity=" + apCapacity +
                '}';
    }
}
