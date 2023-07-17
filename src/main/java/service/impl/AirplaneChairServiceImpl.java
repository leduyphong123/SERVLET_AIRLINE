package service.impl;

import dto.AirplaneChairDTO;
import entity.AirplaneChair;
import repository.AirplaneChairRepository;
import service.AirplaneChairService;
import service.builder.AirplaneChairBuilder;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AirplaneChairServiceImpl implements AirplaneChairService {
    private AirplaneChairRepository repository = new AirplaneChairRepository();
    private AirplaneChair airplaneChair;

    @Override
    public AirplaneChair getById(int id) throws SQLException, ClassNotFoundException {
        List<AirplaneChair> airplaneChairList = getAll();
        for(AirplaneChair element : airplaneChairList){
            if (element.getId() == id){
                return element;
            }
        }
        return null;
    }

    @Override
    public List<AirplaneChair> getAll() throws SQLException, ClassNotFoundException {

        return repository.getAll();
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
    public List<AirplaneChairDTO> getJoinAll() throws SQLException, ClassNotFoundException {
        return repository.getJoinAll();
    }

    @Override
    public boolean create(int quantity, long price, String used, Date date, int apId, int cId) throws SQLException, ClassNotFoundException {
        airplaneChair = new AirplaneChairBuilder()
                .withQuantity(quantity)
                .withPrice(price)
                .withPlayDate(date)
                .withCId(cId)
                .withApId(apId)
                .builder();
        if (used != "") {
            airplaneChair.setUsed(Integer.parseInt(used));
        }else {
            airplaneChair.setUsed(0);

        }
        return repository.create(airplaneChair);
    }

    @Override
    public boolean edit(int id, int quantity, long price, String used, Date date, int apId, int cId) throws SQLException, ClassNotFoundException {
        airplaneChair = new AirplaneChairBuilder()
                .withId(id)
                .withQuantity(quantity)
                .withPrice(price)
                .withPlayDate(date)
                .withCId(cId)
                .withApId(apId)
                .builder();
        if (used != "") {
            airplaneChair.setUsed(Integer.parseInt(used));
        }else {
            airplaneChair.setUsed(0);

        }
        return repository.edit(airplaneChair);
    }

    @Override
    public AirplaneChairDTO getJoinById(int id) throws SQLException, ClassNotFoundException {
        for (AirplaneChairDTO element : getJoinAll()){
            if (element.getId() == id){
                return element;
            }
        }
        return null;
    }

    @Override
    public List<AirplaneChairDTO> getByApIdDate(int apId, Timestamp formDate) throws SQLException, ClassNotFoundException {
        String[] resultIn = formDate.toString().split(" ");
        List<AirplaneChairDTO> airplaneChairDTOList = new ArrayList<>();
        for (AirplaneChairDTO element : getJoinAll()){
            String[] resultOut = element.getPlayDate().toString().split(" ");
            if (element.getApId() == apId && resultIn[0].equals(resultOut[0])){
                airplaneChairDTOList.add(element);
            }
        }
        return airplaneChairDTOList;
    }

    @Override
    public List<AirplaneChairDTO> getByIdAirplaneDate(int airplaneId, Date airplaneChairDate) throws SQLException, ClassNotFoundException {
        List<AirplaneChairDTO> airplaneChairDTOList = new ArrayList<>();
        for (AirplaneChairDTO element : getJoinAll()){
            if (element.getApId() == airplaneId && airplaneChairDate.equals(element.getPlayDate())){
                airplaneChairDTOList.add(element);
            }
        }
        return airplaneChairDTOList;
    }

    @Override
    public void updateUsed(int id,int used) throws SQLException, ClassNotFoundException {
        repository.updateUsed(id,used);
    }
    private int limit=5;
    @Override
    public List<AirplaneChairDTO> getPageAll(int page) throws SQLException, ClassNotFoundException {
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
