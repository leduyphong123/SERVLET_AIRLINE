package service.impl;

import dto.AirplaneDTO;
import entity.Airline;
import entity.Airplane;
import repository.AirplaneRepository;
import service.AirplaneService;
import service.builder.AirlineBuilder;
import service.builder.AirplaneBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {
    private AirplaneRepository repository = new AirplaneRepository();
    private Airplane airplane;
    @Override
    public Airplane getById(int id) throws SQLException, ClassNotFoundException {
        for (Airplane element : getAll()){
            if(element.getId()==id){
                return element;
            }
        }
        return null;
    }

    @Override
    public List<Airplane> getAll() throws SQLException, ClassNotFoundException {
        return repository.getAll();
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return  repository.delete(id);
    }

    @Override
    public boolean edit(int id, String name, String shortName, int capacity, int alId) throws SQLException, ClassNotFoundException {
        if (checkLength(name, shortName)) {return false;}
         airplane = new AirplaneBuilder()
                .withId(id)
                .withName(name)
                .withShortName(shortName)
                 .withCapacity(capacity)
                 .withAirlineId(alId)
                .builder();
        return repository.edit(airplane);
    }

    @Override
    public boolean create(String name, String shortName, int capacity, int alId) throws SQLException, ClassNotFoundException {
        if (checkLength(name, shortName)) {return false;}
        airplane = new AirplaneBuilder()
                .withName(name)
                .withShortName(shortName)
                .withCapacity(capacity)
                .withAirlineId(alId)
                .withState(true)
                .builder();
        return repository.create(airplane);
    }

    @Override
    public List<AirplaneDTO> getJoinAll() throws SQLException, ClassNotFoundException {
        return repository.getJoinAll();
    }

    @Override
    public boolean active(int id, boolean state) throws SQLException, ClassNotFoundException {
        return repository.active(id,state);
    }

    @Override
    public Airplane getByApId(int apId) throws SQLException, ClassNotFoundException {
        for (Airplane element : getAll()){
            if(element.getAlId()==apId){
                return element;
            }
        }
        return null;
    }
    private int limit = 5;
    @Override
    public List<AirplaneDTO> getPageAll(int page) throws SQLException, ClassNotFoundException {
        int start = (page - 1) * limit;
        return repository.getPageAll(start, limit);
    }

    @Override
    public int getIndexPage() throws SQLException, ClassNotFoundException {
        return getIndex();
    }

    @Override
    public List<Airplane> getStateAll() throws SQLException, ClassNotFoundException {
        List<Airplane> airplaneList = new ArrayList<>();
        for (Airplane element : getAll()){
            if (element.isState() == true){
                airplaneList.add(element);
            }
        }
        return airplaneList;
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

    private static boolean checkLength(String name, String shortName) {
        if(name.length()>=50 && shortName.length()>=10 && name.length()==0 && shortName.length()==0){
            return true;
        }
        return false;
    }
}
