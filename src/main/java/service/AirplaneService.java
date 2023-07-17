package service;

import dto.AirplaneDTO;
import entity.Airplane;

import java.sql.SQLException;
import java.util.List;

public interface AirplaneService {
    Airplane getById(int id) throws SQLException, ClassNotFoundException;

    List<Airplane> getAll() throws SQLException, ClassNotFoundException;

    boolean delete(int id) throws SQLException, ClassNotFoundException;

    boolean edit(int id, String name, String shortName,int capacity,int alId) throws SQLException, ClassNotFoundException;

    boolean create(String name, String shortName,int capacity, int alId) throws SQLException, ClassNotFoundException;

    List<AirplaneDTO> getJoinAll() throws SQLException, ClassNotFoundException;

    boolean active(int id, boolean state) throws SQLException, ClassNotFoundException;

    Airplane getByApId(int apId) throws SQLException, ClassNotFoundException;

    List<AirplaneDTO> getPageAll(int page) throws SQLException, ClassNotFoundException;

    int getIndexPage() throws SQLException, ClassNotFoundException;

    List<Airplane> getStateAll() throws SQLException, ClassNotFoundException;
}
