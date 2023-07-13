package repository;

import dto.AirplaneDTO;
import entity.Airline;
import entity.Airplane;
import service.builder.AirlineBuilder;
import service.builder.AirplaneBuilder;
import service.builder.AirplaneDTOBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneRepository {
    public List<AirplaneDTO> getJoinAll() throws SQLException, ClassNotFoundException {
        List<AirplaneDTO> airplaneDTOList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM VIEW_AIRPLANE";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                AirplaneDTO airplaneDTO = new AirplaneDTOBuilder()
                        .withId(resultSet.getInt("AP_ID"))
                        .withName(resultSet.getString("AP_NAME"))
                        .withShortName(resultSet.getString("AP_SHORT_NAME"))
                        .withCapacity(resultSet.getInt("AP_CAPACITY"))
                        .withState(resultSet.getBoolean("AP_STATE"))
                        .withAirlineId(resultSet.getInt("AL_ID"))
                        .withAirlineName(resultSet.getString("AL_NAME"))
                        .builder();
                airplaneDTOList.add(airplaneDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return airplaneDTOList;
    }

    public boolean create(Airplane airplane) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "INSERT INTO AIRPLANE (NAME,SHORT_NAME,CAPACITY,STATE,AL_ID) VALUES (?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, airplane.getName());
            pstm.setString(2, airplane.getShortName());
            pstm.setInt(3,airplane.getCapacity());
            pstm.setBoolean(4,airplane.isState());
            pstm.setInt(5,airplane.getAlId());
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

    public boolean edit(Airplane airplane) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "UPDATE  AIRPLANE SET NAME = ?,SHORT_NAME = ?,CAPACITY = ?, AL_ID = ? WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1, airplane.getName());
            pstm.setString(2, airplane.getShortName());
            pstm.setInt(3, airplane.getCapacity());
            pstm.setInt(4, airplane.getAlId());
            pstm.setInt(5, airplane.getId());
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
            String query = "DELETE FROM AIRPLANE WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,id);
            pstm.execute();
            return true;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public List<Airplane> getAll() throws SQLException, ClassNotFoundException {
        List<Airplane> airplaneList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM AIRPLANE";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Airplane airplane = new AirplaneBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withShortName(resultSet.getString("SHORT_NAME"))
                        .withCapacity(resultSet.getInt("CAPACITY"))
                        .withAirlineId(resultSet.getInt("AL_ID"))
                        .builder();
                airplaneList.add(airplane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return airplaneList;
    }

    public boolean active(int id, boolean state) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            String query = "UPDATE  AIRPLANE SET STATE = ? WHERE ID = ?";
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
