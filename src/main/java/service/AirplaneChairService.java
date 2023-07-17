package service;

import dto.AirplaneChairDTO;
import entity.AirplaneChair;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface AirplaneChairService {
    AirplaneChair getById(int id) throws SQLException, ClassNotFoundException;

    List<AirplaneChair> getAll() throws SQLException, ClassNotFoundException;

    boolean active(int id, boolean state) throws SQLException, ClassNotFoundException;

    boolean delete(int id);


    List<AirplaneChairDTO> getJoinAll() throws SQLException, ClassNotFoundException;

    boolean create(int quantity, long price, String used, Date date, int apId, int cId) throws SQLException, ClassNotFoundException;

    boolean edit(int id, int quantity, long price, String used, Date date, int apId, int cId) throws SQLException, ClassNotFoundException;

    AirplaneChairDTO getJoinById(int id) throws SQLException, ClassNotFoundException;

    List<AirplaneChairDTO> getByApIdDate(int apId, Timestamp formDate) throws SQLException, ClassNotFoundException;


    List<AirplaneChairDTO> getByIdAirplaneDate(int airplaneId, Date airplaneChairDate) throws SQLException, ClassNotFoundException;


    void updateUsed(int id, int used) throws SQLException, ClassNotFoundException;

    List<AirplaneChairDTO> getPageAll(int page) throws SQLException, ClassNotFoundException;

    int getIndexPage() throws SQLException, ClassNotFoundException;
}
