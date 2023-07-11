package service.impl;

import entity.Chair;
import entity.City;
import repository.ChairRepository;
import service.ChairService;
import service.builder.ChairBuilder;
import service.builder.CityBuilder;

import java.sql.SQLException;
import java.util.List;

public class ChairServiceImpl implements ChairService {
    private ChairRepository repository = new ChairRepository();
    private Chair chair;
    @Override
    public Chair getById(int id) throws SQLException, ClassNotFoundException {
        for (Chair element : getAll()){
            if(element.getId()==id){
                return element;
            }
        }
        return null;
    }

    @Override
    public List<Chair> getAll() throws SQLException, ClassNotFoundException {
        return repository.getAll();
    }

    @Override
    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        return  repository.delete(id);
    }

    @Override
    public boolean edit(int id, String name) throws SQLException, ClassNotFoundException {
        if (checkLength(name)) {return false;}
        chair= new ChairBuilder()
                .withId(id)
                .withName(name)
                .builder();
        return repository.edit(chair);
    }

    @Override
    public boolean create(String name) throws SQLException, ClassNotFoundException {
        if (checkLength(name)) {return false;}
        chair = new ChairBuilder()
                .withName(name)
                .builder();
        return repository.create(chair);
    }

    @Override
    public boolean active(int id,boolean state) throws SQLException, ClassNotFoundException {
        return repository.active(id,state);
    }

    private static boolean checkLength(String name) {
        if(name.length()>=50 &&  name.length()==0){
            return true;
        }
        return false;
    }
}
