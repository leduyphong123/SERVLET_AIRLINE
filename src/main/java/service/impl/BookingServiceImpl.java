package service.impl;

import dto.AirplaneChairDTO;
import dto.SearchFlight;
import entity.Booking;
import entity.Passenger;
import repository.BookingRepository;
import service.*;
import service.builder.BookingBuilder;
import service.builder.PassemgerBuilder;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    private AirplaneChairService airplaneChairService = new AirplaneChairServiceImpl();
    private SearchService searchService = new SearchServiceImpl();

    private FlightService flightService = new FlightServiceImpl();
    private BookingRepository repository = new BookingRepository();
    private PassengerService passengerService = new PassengerServiceImpl();

    @Override
    public boolean create(int idFlight, int idApc, String firtName, String middleName, String lastName, String email, Date birthDate, String address, String idUser) throws SQLException, ClassNotFoundException {
        AirplaneChairDTO airplaneChairDTO = airplaneChairService.getJoinById(idApc);
        if ((airplaneChairDTO.getUsed() + 1) > airplaneChairDTO.getQuantity()) {
            return false;
        }
        SearchFlight searchFlight = searchService.getAllById(idFlight);
        if (searchFlight.getAirplaneCapacity() < (searchFlight.getFlightUsedCapacity() + 7)) {
            return false;
        }
        airplaneChairService.updateUsed(airplaneChairDTO.getId(), airplaneChairDTO.getUsed());
        flightService.updateUsed(idFlight, searchFlight.getFlightUsedCapacity());
        Booking booking = new BookingBuilder()
                .withBookingDate(new Timestamp(System.currentTimeMillis()))
                .withPrice(airplaneChairDTO.getPrice())
                .withFlightId(idFlight)
                .builder();
        if (idUser != "") {
            booking.setAcountId(Integer.parseInt(idUser));
        } else {
            booking.setAcountId(1);
        }
        boolean isCreateBooking = repository.create(booking);
        if (isCreateBooking) {
            Booking booking1 = repository.getOneBooking(booking);
            Passenger passenger = new PassemgerBuilder()
                    .withBookingId(booking1.getId())
                    .withFirtName(firtName)
                    .withMiddleName(middleName)
                    .withLastName(lastName)
                    .withBirthDate(birthDate)
                    .withEmail(email)
                    .withAddress(address)
                    .builder();
            return passengerService.create(passenger);
        }
        return false;
    }

    @Override
    public List<Booking> getAll() throws SQLException, ClassNotFoundException {
        return repository.getAll();
    }

    @Override
    public Booking getById(int bookingId) throws SQLException, ClassNotFoundException {
        return repository.getById(bookingId);
    }

    @Override
    public boolean updateState(int id, String state) throws SQLException, ClassNotFoundException {
        String newState = state;

        if (newState.equals("NOT CHECK IN")) {
            newState = "CHECK OUT";
        } else {
            newState = "NOT CHECK IN";
        }
        return repository.updateState(id, newState);
    }

    private int limit = 5;

    @Override
    public List<Booking> getPageAll(int page) throws SQLException, ClassNotFoundException {
        int start = (page - 1) * limit;
        return repository.getPageAll(start, limit);
    }

    @Override
    public int getIndexPage() throws SQLException, ClassNotFoundException {
        return getIndex();
    }

    private int getIndex() throws SQLException, ClassNotFoundException {
        int indexPageAll = getAll().size();
        float curent =(float) indexPageAll/limit;
        String[] temp = String.valueOf(curent).split("\\.");
        int allPage=0;
        if (Integer.parseInt(temp[1])>0){
            allPage=Integer.parseInt(temp[0])+1;
        }else {
            allPage=Integer.parseInt(temp[0]);
        }
        return allPage;
    }
}
