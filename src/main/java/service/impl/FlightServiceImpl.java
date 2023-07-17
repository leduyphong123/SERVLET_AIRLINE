package service.impl;

import dto.FlightDTO;
import entity.Flight;
import repository.FlightRepository;
import service.FlightService;
import service.builder.FlightBuilder;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class FlightServiceImpl implements FlightService {
    private FlightRepository repository = new FlightRepository();
    private Flight flight;
    @Override
    public List<FlightDTO> getJoinAll() throws SQLException, ClassNotFoundException {
        return repository.getJoinAll();
    }

    @Override
    public Flight getById(int id) throws SQLException, ClassNotFoundException {
        for (Flight element : getAll()){
            if (element.getId()==id){
                return element;
            }
        }
        return null;
    }

    @Override
    public boolean active(int id, boolean state) throws SQLException, ClassNotFoundException {
        return repository.active(id,state);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<Flight> getAll() throws SQLException, ClassNotFoundException {
        return repository.getAll();
    }


    @Override
    public boolean create(int toCity, String toDate, int formCity, String formDate, String usedCapacity, int apId) throws SQLException, ClassNotFoundException {
        Timestamp parseToDate = parseDate(toDate);
        Timestamp parseFormDate = parseDate(formDate);
        flight = new FlightBuilder()
                 .withToCity(toCity)
                 .withToDate(parseToDate)
                 .withFormCity(formCity)
                 .withFormDate(parseFormDate)
                 .withApId(apId)
                 .withState(true)
                 .builder();
         if (usedCapacity == ""){
             flight.setUsedCapacity(0);
         }else {
             flight.setUsedCapacity(Integer.parseInt(usedCapacity));
         }
         return repository.create(flight);

    }

    @Override
    public boolean edit(int id,int toCity, String toDate, int formCity, String formDate, String usedCapacity, int apId) throws SQLException, ClassNotFoundException {
        Timestamp parseToDate = parseDate(toDate);
        Timestamp parseFormDate = parseDate(formDate);
        flight = new FlightBuilder()
                .withId(id)
                .withToCity(toCity)
                .withToDate(parseToDate)
                .withFormCity(formCity)
                .withFormDate(parseFormDate)
                .withApId(apId)
                .builder();
        if (usedCapacity == ""){
            flight.setUsedCapacity(0);
        }else {
            flight.setUsedCapacity(Integer.parseInt(usedCapacity));
        }
        return repository.edit(flight);
    }

    @Override
    public Flight getJoinById(int id) throws SQLException, ClassNotFoundException {
        for(Flight element : getAll()){
            if (element.getId() == id){
                return element;
            }
        }
        return null;
    }

    @Override
    public void updateUsed(int idFlight, int flightUsedCapacity) throws SQLException, ClassNotFoundException {
        repository.updateUsed(idFlight,flightUsedCapacity);
    }
    private int limit = 5;
    @Override
    public List<FlightDTO> getPageAll(int page) throws SQLException, ClassNotFoundException {
        int start = (page - 1) * limit;
        return repository.getPageAll(start, limit);
    }

    @Override
    public int getIndexPage() throws SQLException, ClassNotFoundException {
        return getIndex();
    }
    private int getIndex() throws SQLException, ClassNotFoundException {
        int indexPageAll = getJoinAll().size();
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
    public Timestamp parseDate(String date){
        char[] chairTo = date.toCharArray();
        for (int i = 0; i< chairTo.length;i++){
            if (Character.toString(chairTo[i]).equals("T")){
                chairTo[i] = ' ';
                break;
            }
        }
        String resultTo = String.valueOf(chairTo)+":00";
        return Timestamp.valueOf(resultTo);
    }
}
