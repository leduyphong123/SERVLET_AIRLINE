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

public class CityRepository {
    public List<City> getAll() throws SQLException, ClassNotFoundException {
        List<City> cityList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM CITY";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                City city = new CityBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withShortName(resultSet.getString("SHORT_NAME"))
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
            String query = "INSERT INTO CITY (NAME,SHORT_NAME) VALUES (?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, city.getName());
            pstm.setString(2, city.getShortName());
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
            String query = "UPDATE  CITY SET NAME = ?,SHORT_NAME = ? WHERE ID = ?";
            pstm = conn.prepareStatement(query);
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
            String query = "DELETE FROM CITY WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,id);
            pstm.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
