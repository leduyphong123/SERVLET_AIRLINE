package repository;

import entity.Airline;
import entity.City;
import service.builder.AirlineBuilder;
import service.builder.CityBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirlineRepository {
    public List<Airline> getAll() throws SQLException, ClassNotFoundException {
        List<Airline> airlineList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM AIRLINE";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Airline airline = new AirlineBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withShortName(resultSet.getString("SHORT_NAME"))
                        .withState(resultSet.getBoolean("STATE"))
                        .builder();
                airlineList.add(airline);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return airlineList;
    }

    public boolean create(Airline airline) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "INSERT INTO AIRLINE (NAME,SHORT_NAME,STATE) VALUES (?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, airline.getName());
            pstm.setString(2, airline.getShortName());
            pstm.setBoolean(3,airline.isState());
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

    public boolean edit(Airline airline) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "UPDATE  AIRLINE SET NAME = ?,SHORT_NAME = ? WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, airline.getName());
            pstm.setString(2, airline.getShortName());
            pstm.setInt(3, airline.getId());
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
            String query = "DELETE FROM AIRLINE WHERE ID = ?";
            pstm = conn.prepareStatement(query);
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
            String query = "UPDATE  AIRLINE SET STATE = ? WHERE ID = ?";
            pstm = conn.prepareStatement(query);
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
}
