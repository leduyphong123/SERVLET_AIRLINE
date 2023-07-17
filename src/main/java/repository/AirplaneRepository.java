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

import static constant.Query.*;

public class AirplaneRepository {
    public List<AirplaneDTO> getJoinAll() throws SQLException, ClassNotFoundException {
        List<AirplaneDTO> airplaneDTOList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_VIEW_AIRPLANE);
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
            pstm = conn.prepareStatement(C_AIRPLANE);
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
            pstm = conn.prepareStatement(U_AIRPLANE);
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
            pstm = conn.prepareStatement(D_AIRPLANE);
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
            pstm = conn.prepareStatement(R_AIRPLANE);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Airplane airplane = new AirplaneBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withShortName(resultSet.getString("SHORT_NAME"))
                        .withCapacity(resultSet.getInt("CAPACITY"))
                        .withAirlineId(resultSet.getInt("AL_ID"))
                        .withState(resultSet.getBoolean("STATE"))
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
            pstm = conn.prepareStatement(U_STATE_AIRPLANE);
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

    public List<AirplaneDTO> getPageAll(int start, int limit) throws SQLException, ClassNotFoundException {
        List<AirplaneDTO> airplaneDTOList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_LIMIT_AIRPLANE);
            pstm.setInt(1,start);
            pstm.setInt(2,limit);
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
}
