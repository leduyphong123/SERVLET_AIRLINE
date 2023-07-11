package service.impl;

import entity.City;
import repository.CityRepository;
import service.CityService;
import service.builder.CityBuilder;

import java.sql.SQLException;
import java.util.List;

public class CityServiceImpl implements CityService {
    private CityRepository repository = new CityRepository();
    private City city ;
    @Override
    public List<City> getAll() throws SQLException, ClassNotFoundException {
        return repository.getAll();
    }

    @Override
    public boolean create(String name, String shortName) throws SQLException, ClassNotFoundException {
        if (checkLength(name, shortName)) {return false;}
        city = new CityBuilder()
                .withName(name)
                .withShortName(shortName)
                .builder();
        return repository.create(city);
    }

    @Override
    public City getById(int id) throws SQLException, ClassNotFoundException {
        for (City element : getAll()){
            if(element.getId()==id){
                return element;
            }
        }
        return null;
    }

    @Override
    public boolean edit(int id, String name, String shortName) throws SQLException, ClassNotFoundException {
        if (checkLength(name, shortName)) {return false;}
        city = new CityBuilder()
                .withId(id)
                .withName(name)
                .withShortName(shortName)
                .builder();
        return repository.edit(city);
    }

    private static boolean checkLength(String name, String shortName) {
        if(name.length()>=50 && shortName.length()>=10 && name.length()==0 && shortName.length()==0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return  repository.delete(id);
    }
}
