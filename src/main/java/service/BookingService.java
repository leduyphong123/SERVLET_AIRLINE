package service;

import entity.Booking;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public interface BookingService {

    boolean create(int idFlight, int idApc, String firtName, String middleName, String lastName, String email, Date birthDate, String address, String idUser) throws SQLException, ClassNotFoundException;

    List<Booking> getAll() throws SQLException, ClassNotFoundException;

    Booking getById(int bookingId) throws SQLException, ClassNotFoundException;

    boolean updateState(int id, String state) throws SQLException, ClassNotFoundException;

    List<Booking> getPageAll(int page) throws SQLException, ClassNotFoundException;

    int getIndexPage() throws SQLException, ClassNotFoundException;
}
