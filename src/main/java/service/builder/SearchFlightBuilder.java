package service.builder;

import dto.SearchFlight;

import java.sql.Date;
import java.sql.Timestamp;

public class SearchFlightBuilder {
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

    public SearchFlightBuilder withFlightId(int flightId) {
        this.flighId = flightId;
        return this;
    }

    public SearchFlightBuilder withFlightToCity(int flightToCity) {
        this.flightToCity = flightToCity;
        return this;
    }

    public SearchFlightBuilder withFlightToDate(Timestamp flightToDate) {
        this.flightToDate = flightToDate;
        return this;
    }

    public SearchFlightBuilder withFlightFormCity(int flightFormCity) {
        this.flightFormCity = flightFormCity;
        return this;
    }

    public SearchFlightBuilder withFlightFormDate(Timestamp flightFormDate) {
        this.flightFormDate = flightFormDate;
        return this;
    }

    public SearchFlightBuilder withFlightUsedCapacity(int flightUsedCapacity) {
        this.flightUsedCapacity = flightUsedCapacity;
        return this;
    }

    public SearchFlightBuilder withAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
        return this;
    }

    public SearchFlightBuilder withAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
        return this;
    }

    public SearchFlightBuilder withAirplaneShortName(String airplaneShortName) {
        this.airplaneShortName = airplaneShortName;
        return this;
    }

    public SearchFlightBuilder withAirplaneCapacity(int airplaneCapacity) {
        this.airplaneCapacity = airplaneCapacity;
        return this;
    }

    public SearchFlightBuilder withAirlineId(int airlineId) {
        this.airlineId = airlineId;
        return this;
    }

    public SearchFlightBuilder withAirlineName(String airlineName) {
        this.airlineName = airlineName;
        return this;
    }

    public SearchFlightBuilder withAirlineShortName(String airlineShortName) {
        this.airlineShortName = airlineShortName;
        return this;
    }

    public SearchFlightBuilder withToCityName(String toCityName) {
        this.toCityName = toCityName;
        return this;
    }

    public SearchFlightBuilder withToCiTyShortName(String toCiTyShortName) {
        this.toCiTyShortName = toCiTyShortName;
        return this;
    }

    public SearchFlightBuilder withFormCityName(String formCityName) {
        this.formCityName = formCityName;
        return this;
    }

    public SearchFlightBuilder withFormCityShortName(String formCityShortName) {
        this.formCityShortName = formCityShortName;
        return this;
    }

    public SearchFlightBuilder withApChairId(int airplaneChairId) {
        this.airplaneChairId = airplaneChairId;
        return this;
    }

    public SearchFlightBuilder withApChairQuantity(int airplaneChairQuantity) {
        this.airplaneChairQuantity = airplaneChairQuantity;
        return this;
    }

    public SearchFlightBuilder withApChairPrice(long airplaneChairPrice) {
        this.airplaneChairPrice = airplaneChairPrice;
        return this;
    }

    public SearchFlightBuilder withApChairUsedQuantity(int airplaneChairUsedQuantity) {
        this.airplaneChairUsedQuantity = airplaneChairUsedQuantity;
        return this;
    }

    public SearchFlightBuilder withApChairDate(Date airplaneChairDate) {
        this.airplaneChairDate = airplaneChairDate;
        return this;
    }


    public SearchFlightBuilder withChairId(int chairId) {
        this.chairId = chairId;
        return this;
    }

    public SearchFlightBuilder withChairName(String chairName) {
        this.chairName = chairName;
        return this;
    }

    public SearchFlight builder() {
        return new SearchFlight(flighId, flightToCity, flightToDate, flightFormCity, flightFormDate, flightUsedCapacity, airplaneId, airplaneName, airplaneShortName, airplaneCapacity, airlineId, airlineName, airlineShortName, toCityName, toCiTyShortName, formCityName, formCityShortName, airplaneChairId, airplaneChairQuantity, airplaneChairPrice, airplaneChairUsedQuantity, airplaneChairDate, chairId, chairName);
    }
}
