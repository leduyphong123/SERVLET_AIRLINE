package service;

import dto.FlightDTO;
import entity.Flight;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface FlightService {
    List<FlightDTO> getJoinAll() throws SQLException, ClassNotFoundException;

    Flight getById(int id) throws SQLException, ClassNotFoundException;

    boolean active(int id, boolean state) throws SQLException, ClassNotFoundException;

    boolean delete(int id);

    List<Flight> getAll() throws SQLException, ClassNotFoundException;

    boolean create(int toCity, String toDate, int formCity, String formDate, String usedCapacity, int apId) throws SQLException, ClassNotFoundException;

    boolean edit(int id,int toCity, String toDate, int formCity, String formDate, String usedCapacity, int apId) throws SQLException, ClassNotFoundException;

    Flight getJoinById(int id) throws SQLException, ClassNotFoundException;


    void updateUsed(int idFlight, int flightUsedCapacity) throws SQLException, ClassNotFoundException;

    List<FlightDTO> getPageAll(int page) throws SQLException, ClassNotFoundException;

    int getIndexPage() throws SQLException, ClassNotFoundException;
}
