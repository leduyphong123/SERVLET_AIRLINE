package service;

import dto.SearchFlight;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface SearchService {
    List<SearchFlight> getAll(int formCityId, int toCityId, int numberPeple, Date formDate, String returnDate, int chairId) throws SQLException, ClassNotFoundException;


    SearchFlight getAllById(int searchFlightId) throws SQLException, ClassNotFoundException;
}
