package service;

import entity.Passenger;

import java.sql.SQLException;

public interface PassengerService {
    boolean create(Passenger passenger) throws SQLException, ClassNotFoundException;

    Passenger getById(int bookingId) throws SQLException, ClassNotFoundException;
}
