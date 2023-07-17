package dto;

import java.sql.Date;
import java.sql.Timestamp;

public class SearchFlight {
    private int flighId;
    private int flightToCity;
    private Timestamp flightToDate;
    private int flightFormCity;
    private Timestamp flightFormDate;
    private int flightUsedCapacity;
    private int airplaneId;
    private String airplaneName;
    private String airplaneShortName;
    private int airplaneCapacity;
    private int airlineId;
    private String airlineName;
    private String airlineShortName;
    private String toCityName;
    private String toCiTyShortName;
    private String formCityName;
    private String formCityShortName;
    private int airplaneChairId;
    private int airplaneChairQuantity;
    private long airplaneChairPrice;
    private int airplaneChairUsedQuantity;
    private Date airplaneChairDate;
    private int chairId;
    private String chairName;

    public SearchFlight() {
    }

    public SearchFlight(int flighId, int flightToCity, Timestamp flightToDate, int flightFormCity, Timestamp flightFormDate, int flightUsedCapacity, int airplaneId, String airplaneName, String airplaneShortName, int airplaneCapacity, int airlineId, String airlineName, String airlineShortName, String toCityName, String toCiTyShortName, String formCityName, String formCityShortName, int airplaneChairId, int airplaneChairQuantity, long airplaneChairPrice, int airplaneChairUsedQuantity, Date airplaneChairDate, int chairId, String chairName) {
        this.flighId = flighId;
        this.flightToCity = flightToCity;
        this.flightToDate = flightToDate;
        this.flightFormCity = flightFormCity;
        this.flightFormDate = flightFormDate;
        this.flightUsedCapacity = flightUsedCapacity;
        this.airplaneId = airplaneId;
        this.airplaneName = airplaneName;
        this.airplaneShortName = airplaneShortName;
        this.airplaneCapacity = airplaneCapacity;
        this.airlineId = airlineId;
        this.airlineName = airlineName;
        this.airlineShortName = airlineShortName;
        this.toCityName = toCityName;
        this.toCiTyShortName = toCiTyShortName;
        this.formCityName = formCityName;
        this.formCityShortName = formCityShortName;
        this.airplaneChairId = airplaneChairId;
        this.airplaneChairQuantity = airplaneChairQuantity;
        this.airplaneChairPrice = airplaneChairPrice;
        this.airplaneChairUsedQuantity = airplaneChairUsedQuantity;
        this.airplaneChairDate = airplaneChairDate;
        this.chairId = chairId;
        this.chairName = chairName;
    }

    @Override
    public String toString() {
        return "SearchFlight{" +
                "flighId=" + flighId +
                ", flightToCity=" + flightToCity +
                ", flightToDate=" + flightToDate +
                ", flightFormCity=" + flightFormCity +
                ", flightFormDate=" + flightFormDate +
                ", flightUsedCapacity=" + flightUsedCapacity +
                ", airplaneId=" + airplaneId +
                ", airplaneName='" + airplaneName + '\'' +
                ", airplaneShortName='" + airplaneShortName + '\'' +
                ", airplaneCapacity=" + airplaneCapacity +
                ", airlineId=" + airlineId +
                ", airlineName='" + airlineName + '\'' +
                ", airlineShortName='" + airlineShortName + '\'' +
                ", toCityName='" + toCityName + '\'' +
                ", toCiTyShortName='" + toCiTyShortName + '\'' +
                ", formCityName='" + formCityName + '\'' +
                ", formCityShortName='" + formCityShortName + '\'' +
                ", airplaneChairId=" + airplaneChairId +
                ", airplaneChairQuantity=" + airplaneChairQuantity +
                ", airplaneChairPrice=" + airplaneChairPrice +
                ", airplaneChairUsedQuantity=" + airplaneChairUsedQuantity +
                ", airplaneChairDate=" + airplaneChairDate +
                ", chairId=" + chairId +
                ", chairName='" + chairName + '\'' +
                '}';
    }

    public int getFlighId() {
        return flighId;
    }

    public void setFlighId(int flighId) {
        this.flighId = flighId;
    }

    public int getFlightToCity() {
        return flightToCity;
    }

    public void setFlightToCity(int flightToCity) {
        this.flightToCity = flightToCity;
    }

    public Timestamp getFlightToDate() {
        return flightToDate;
    }

    public void setFlightToDate(Timestamp flightToDate) {
        this.flightToDate = flightToDate;
    }

    public int getFlightFormCity() {
        return flightFormCity;
    }

    public void setFlightFormCity(int flightFormCity) {
        this.flightFormCity = flightFormCity;
    }

    public Timestamp getFlightFormDate() {
        return flightFormDate;
    }

    public void setFlightFormDate(Timestamp flightFormDate) {
        this.flightFormDate = flightFormDate;
    }

    public int getFlightUsedCapacity() {
        return flightUsedCapacity;
    }

    public void setFlightUsedCapacity(int flightUsedCapacity) {
        this.flightUsedCapacity = flightUsedCapacity;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }

    public String getAirplaneShortName() {
        return airplaneShortName;
    }

    public void setAirplaneShortName(String airplaneShortName) {
        this.airplaneShortName = airplaneShortName;
    }

    public int getAirplaneCapacity() {
        return airplaneCapacity;
    }

    public void setAirplaneCapacity(int airplaneCapacity) {
        this.airplaneCapacity = airplaneCapacity;
    }

    public int getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(int airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getAirlineShortName() {
        return airlineShortName;
    }

    public void setAirlineShortName(String airlineShortName) {
        this.airlineShortName = airlineShortName;
    }

    public String getToCityName() {
        return toCityName;
    }

    public void setToCityName(String toCityName) {
        this.toCityName = toCityName;
    }

    public String getToCiTyShortName() {
        return toCiTyShortName;
    }

    public void setToCiTyShortName(String toCiTyShortName) {
        this.toCiTyShortName = toCiTyShortName;
    }

    public String getFormCityName() {
        return formCityName;
    }

    public void setFormCityName(String formCityName) {
        this.formCityName = formCityName;
    }

    public String getFormCityShortName() {
        return formCityShortName;
    }

    public void setFormCityShortName(String formCityShortName) {
        this.formCityShortName = formCityShortName;
    }

    public int getAirplaneChairId() {
        return airplaneChairId;
    }

    public void setAirplaneChairId(int airplaneChairId) {
        this.airplaneChairId = airplaneChairId;
    }

    public int getAirplaneChairQuantity() {
        return airplaneChairQuantity;
    }

    public void setAirplaneChairQuantity(int airplaneChairQuantity) {
        this.airplaneChairQuantity = airplaneChairQuantity;
    }

    public long getAirplaneChairPrice() {
        return airplaneChairPrice;
    }

    public void setAirplaneChairPrice(long airplaneChairPrice) {
        this.airplaneChairPrice = airplaneChairPrice;
    }

    public int getAirplaneChairUsedQuantity() {
        return airplaneChairUsedQuantity;
    }

    public void setAirplaneChairUsedQuantity(int airplaneChairUsedQuantity) {
        this.airplaneChairUsedQuantity = airplaneChairUsedQuantity;
    }

    public Date getAirplaneChairDate() {
        return airplaneChairDate;
    }

    public void setAirplaneChairDate(Date airplaneChairDate) {
        this.airplaneChairDate = airplaneChairDate;
    }

    public int getChairId() {
        return chairId;
    }

    public void setChairId(int chairId) {
        this.chairId = chairId;
    }

    public String getChairName() {
        return chairName;
    }

    public void setChairName(String chairName) {
        this.chairName = chairName;
    }
}
