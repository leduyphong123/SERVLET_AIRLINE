package service.impl;

import entity.Passenger;
import repository.PassengerRepository;
import service.PassengerService;

import java.sql.SQLException;

public class PassengerServiceImpl implements PassengerService {
    private PassengerRepository repository = new PassengerRepository();
    @Override
    public boolean create(Passenger passenger) throws SQLException, ClassNotFoundException {
        return repository.create(passenger);
    }

    @Override
    public Passenger getById(int bookingId) throws SQLException, ClassNotFoundException {
        return repository.getById(bookingId);
    }
}
