package service;

import entity.Airline;

import java.sql.SQLException;
import java.util.List;

public interface AirlineService {
    Airline getById(int id) throws SQLException, ClassNotFoundException;

    List<Airline> getAll() throws SQLException, ClassNotFoundException;

    boolean delete(int id) throws SQLException, ClassNotFoundException;

    boolean edit(int id, String name, String shortName) throws SQLException, ClassNotFoundException;

    boolean create(String name, String shortName) throws SQLException, ClassNotFoundException;
}
