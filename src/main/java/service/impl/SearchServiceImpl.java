package service.impl;

import dto.AirplaneChairDTO;
import dto.SearchFlight;
import entity.AirplaneChair;
import entity.Chair;
import entity.Flight;
import repository.SearchRepository;
import service.AirplaneChairService;
import service.ChairService;
import service.FlightService;
import service.SearchService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import comparator.ComparaPriceSearch;
public class SearchServiceImpl implements SearchService {
    private FlightService flightService = new FlightServiceImpl();
    private AirplaneChairService airplaneChairService = new AirplaneChairServiceImpl();
    private ChairService chairService = new ChairServiceImpl();
    private SearchRepository repository =  new SearchRepository();
    @Override
    public List<SearchFlight> getAll(int formCityId, int toCityId, int numberPeple, Date formDate, String returnDate, int chairId) throws SQLException, ClassNotFoundException {
        if (returnDate !=""){

        }
        List<SearchFlight> searchFlightList = repository.getAll(formCityId,toCityId,chairId);
        List<SearchFlight> searchFlights = new ArrayList<>();
        for (SearchFlight element : searchFlightList){
            String[] date = element.getFlightFormDate().toString().split(" ");
            Date resultDate = Date.valueOf(date[0]);
            if (formDate.equals(resultDate)){
                searchFlights.add(element);
            }
        }
        ComparaPriceSearch comparaPriceSearch = new ComparaPriceSearch();
        Collections.sort(searchFlights,comparaPriceSearch);
        return searchFlights;
    }

    @Override
    public SearchFlight getAllById(int searchFlightId) throws SQLException, ClassNotFoundException {
        return repository.getAllById(searchFlightId);
    }


}
