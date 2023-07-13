package repository;

import dto.FlightDTO;
import entity.Flight;
import service.builder.FlightBuilder;
import service.builder.FlightDTOBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    public List<FlightDTO> getJoinAll() throws SQLException, ClassNotFoundException {
        List<FlightDTO> flightDTOList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM VIEW_FLIGHT";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                FlightDTO flightDTO = new FlightDTOBuilder()
                        .withId(resultSet.getInt("F_ID"))
                        .withToCity(resultSet.getString("F_TO_CITY"))
                        .withToDate(resultSet.getTimestamp("F_TO_DATE"))
                        .withFormCity(resultSet.getString("F_FORM_CITY"))
                        .withFormDate(resultSet.getTimestamp("F_FORM_DATE"))
                        .withUsedCapacity(resultSet.getInt("F_USED_CAPACITY"))
                        .withState(resultSet.getBoolean("F_STATE"))
                        .withApId(resultSet.getInt("AP_ID"))
                        .withApName(resultSet.getString("AP_NAME"))
                        .withApShortName(resultSet.getString("AP_SHORT_NAME"))
                        .withApCapacity(resultSet.getInt("AP_CAPACITY"))
                        .builder();
                flightDTOList.add(flightDTO);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pstm.close();
            conn.close();
        }
        return flightDTOList;
    }

    public boolean create(Flight flight) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "INSERT INTO FLIGHT (TO_CITY,TO_DATE_TIME,FORM_CITY,FORM_DATE_TIME,USED_CAPACITY,STATE,AP_ID) VALUES (?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,flight.getToCity());
            pstm.setTimestamp(2,flight.getToDate());
            pstm.setInt(3,flight.getFormCity());
            pstm.setTimestamp(4,flight.getFormDate());
            pstm.setInt(5,flight.getUsedCapacity());
            pstm.setBoolean(6,flight.isState());
            pstm.setInt(7,flight.getApId());
            pstm.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            pstm.close();
            conn.close();
        }
    }

    public boolean edit(Flight flight) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "UPDATE FLIGHT SET TO_CITY = ?,TO_DATE_TIME = ? ,FORM_CITY =? ,FORM_DATE_TIME = ?,USED_CAPACITY =?,AP_ID = ? WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,flight.getToCity());
            pstm.setObject(2,flight.getToDate());
            pstm.setInt(3,flight.getFormCity());
            pstm.setObject(4,flight.getFormDate());
            pstm.setInt(5,flight.getUsedCapacity());
            pstm.setInt(6,flight.getApId());
            pstm.setInt(7,flight.getId());
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            pstm.close();
            conn.close();
        }
    }

    public boolean active(int id, boolean state) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "UPDATE FLIGHT SET STATE = ? WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setBoolean(1,!state);
            pstm.setInt(2,id);
            pstm.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            pstm.close();
            conn.close();
        }
    }

    public List<Flight> getAll() throws SQLException, ClassNotFoundException {
        List<Flight> flightList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM FLIGHT";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                Flight flight = new FlightBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withToCity(resultSet.getInt("TO_CITY"))
                        .withToDate(resultSet.getTimestamp("TO_DATE_TIME"))
                        .withFormCity(resultSet.getInt("FORM_CITY"))
                        .withFormDate(resultSet.getTimestamp("FORM_DATE_TIME"))
                        .withUsedCapacity(resultSet.getInt("USED_CAPACITY"))
                        .withState(resultSet.getBoolean("STATE"))
                        .withApId(resultSet.getInt("AP_ID"))
                        .builder();
                flightList.add(flight);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pstm.close();
            conn.close();
        }
        return flightList;
    }

    //        Connection conn = ConectionConfig.getConection();
//        PreparedStatement pstm = null;
//        try{
//
//        }catch (SQLException e){
//            e.printStackTrace();
//            return false;
//        }finally {
//            pstm.close();
//            conn.close();
//        }
}
