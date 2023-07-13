package repository;

import dto.AirplaneChairDTO;
import entity.AirplaneChair;
import service.builder.AirplaneChairBuilder;
import service.builder.AirplaneChairDTOBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AirplaneChairRepository {
    public List<AirplaneChairDTO> getJoinAll() throws SQLException, ClassNotFoundException {
        List<AirplaneChairDTO> airplaneChairDTOList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM VIEW_AIRPLANE_CHAIR";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                AirplaneChairDTO airplaneChairDTO = new AirplaneChairDTOBuilder()
                        .withId(resultSet.getInt("APC_ID"))
                        .withQuantity(resultSet.getInt("APC_QUANTITY"))
                        .withPrice(resultSet.getLong("APC_PRICE"))
                        .withState(resultSet.getBoolean("APC_STATE"))
                        .withCId(resultSet.getInt("C_ID"))
                        .withAId(resultSet.getInt("AP_ID"))
                        .withCName(resultSet.getString("C_NAME"))
                        .withApName(resultSet.getString("AP_NAME"))
                        .withApShortName(resultSet.getString("AP_SHORT_NAME"))
                        .withApCapacity(resultSet.getInt("AP_CAPACITY"))
                        .withPlayDate(resultSet.getDate("APC_DATE"))
                        .withUsed(resultSet.getInt("APC_USED"))
                        .builder();
                airplaneChairDTOList.add(airplaneChairDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pstm.close();
            conn.close();
        }
        return airplaneChairDTOList;
    }

    public boolean create(AirplaneChair airplaneChair) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "INSERT INTO AIRPLANE_CHAIR (QUANTITY,PRICE,USED,PLAY_DATE,STATE,C_ID,AP_ID) VALUES (?,?,?,?,?,?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, airplaneChair.getQuantity());
            pstm.setLong(2, airplaneChair.getPrice());
            pstm.setInt(3, airplaneChair.getUsed());
            pstm.setDate(4, airplaneChair.getPlayDate());
            pstm.setBoolean(5, true);
            pstm.setInt(6, airplaneChair.getcId());
            pstm.setInt(7, airplaneChair.getApId());
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

    public List<AirplaneChair> getAll() throws SQLException, ClassNotFoundException {
        List<AirplaneChair> airplaneChairList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "SELECT * FROM AIRPLANE_CHAIR";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                AirplaneChair airplaneChair = new AirplaneChairBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withQuantity(resultSet.getInt("QUANTITY"))
                        .withPrice(resultSet.getLong("PRICE"))
                        .withUsed(resultSet.getInt("USED"))
                        .withPlayDate(resultSet.getDate("PLAY_DATE"))
                        .withState(resultSet.getBoolean("STATE"))
                        .withCId(resultSet.getInt("C_ID"))
                        .withApId(resultSet.getInt("AP_ID"))
                        .builder();
                airplaneChairList.add(airplaneChair);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            pstm.close();
            conn.close();
        }
        return airplaneChairList;
    }

    public boolean edit(AirplaneChair airplaneChair) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "UPDATE AIRPLANE_CHAIR SET QUANTITY = ?,PRICE = ?,USED = ?,PLAY_DATE = ?,C_ID= ?,AP_ID = ? WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1, airplaneChair.getQuantity());
            pstm.setLong(2, airplaneChair.getPrice());
            pstm.setInt(3, airplaneChair.getUsed());
            pstm.setDate(4, airplaneChair.getPlayDate());
            pstm.setInt(5, airplaneChair.getcId());
            pstm.setInt(6, airplaneChair.getApId());
            pstm.setInt(7, airplaneChair.getId());
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
            String query = "UPDATE AIRPLANE_CHAIR SET STATE = ? WHERE ID = ?";
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



}
