package repository;

import entity.City;
import service.builder.CityBuilder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constant.Query.*;

public class CityRepository {
    public List<City> getAll() throws SQLException, ClassNotFoundException {
        List<City> cityList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_CITY);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                City city = new CityBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withShortName(resultSet.getString("SHORT_NAME"))
                        .withState(resultSet.getBoolean("STATE"))
                        .builder();
                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return cityList;
    }

    public boolean create(City city) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(C_CITY);
            pstm.setString(1, city.getName());
            pstm.setString(2, city.getShortName());
            pstm.setBoolean(3,city.isState());
            pstm.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            pstm.close();
            conn.close();
        }
    }

    public boolean edit(City city) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(U_CITY);
            pstm.setString(1, city.getName());
            pstm.setString(2, city.getShortName());
            pstm.setInt(3, city.getId());
            pstm.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            pstm.close();
            conn.close();
        }
    }

    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(D_CITY);
            pstm.setInt(1,id);
            pstm.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean active(int id, boolean state) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            pstm = conn.prepareStatement(U_STATE_CITY);
            pstm.setBoolean(1,!state);
            pstm.setInt(2,id);
            pstm.executeUpdate();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            pstm.close();
            conn.close();
        }
    }

    public List<City> getPageAll(int start, int limit) throws SQLException, ClassNotFoundException {
        List<City> cityList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_LIMIT_CITY);
            pstm.setInt(1,start);
            pstm.setInt(2,limit);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                City city = new CityBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withShortName(resultSet.getString("SHORT_NAME"))
                        .withState(resultSet.getBoolean("STATE"))
                        .builder();
                cityList.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return cityList;
    }
}
