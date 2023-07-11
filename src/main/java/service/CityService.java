package service;

import entity.City;

import java.sql.SQLException;
import java.util.List;

public interface CityService {

    List<City> getAll() throws SQLException, ClassNotFoundException;

    boolean create(String name, String shortName) throws SQLException, ClassNotFoundException;

    City getById(int id) throws SQLException, ClassNotFoundException;

    boolean edit(int id, String name, String shortName) throws SQLException, ClassNotFoundException;

    boolean delete(int id) throws SQLException, ClassNotFoundException;
}
