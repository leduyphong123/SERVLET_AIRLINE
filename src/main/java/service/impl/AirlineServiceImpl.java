package service.impl;

import entity.Airline;
import repository.AirlineRepository;
import service.AirlineService;
import service.builder.AirlineBuilder;
import service.builder.CityBuilder;


import java.sql.SQLException;
import java.util.List;

public class AirlineServiceImpl implements AirlineService {
    private AirlineRepository repository = new AirlineRepository();
    private Airline airline;
    @Override
    public Airline getById(int id) throws SQLException, ClassNotFoundException {
        for (Airline element : getAll()){
            if(element.getId()==id){
                return element;
            }
        }
        return null;
    }

    @Override
    public List<Airline> getAll() throws SQLException, ClassNotFoundException {
        return repository.getAll();
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return  repository.delete(id);
    }

    @Override
    public boolean edit(int id, String name, String shortName) throws SQLException, ClassNotFoundException {
        if (checkLength(name, shortName)) {return false;}
        airline= new AirlineBuilder()
                .withId(id)
                .withName(name)
                .withShortName(shortName)
                .builder();
        return repository.edit(airline);
    }

    @Override
    public boolean create(String name, String shortName) throws SQLException, ClassNotFoundException {
        if (checkLength(name, shortName)) {return false;}
        airline = new AirlineBuilder()
                .withName(name)
                .withShortName(shortName)
                .withState(true)
                .builder();
        return repository.create(airline);
    }

    @Override
    public boolean active(int id, boolean state) throws SQLException, ClassNotFoundException {
        return repository.active(id,state);
    }

    private static boolean checkLength(String name, String shortName) {
        if(name.length()>=50 && shortName.length()>=10 && name.length()==0 && shortName.length()==0){
            return true;
        }
        return false;
    }
}
