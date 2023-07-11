package repository;

import entity.Chair;
import service.builder.ChairBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChairRepository {
    public List<Chair> getAll() throws SQLException, ClassNotFoundException {
        List<Chair> chairList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm  = null;
        try {
            String query = "SELECT * FROM CHAIR";
            pstm = conn.prepareStatement(query);
            ResultSet resultSet =  pstm.executeQuery();
            while (resultSet.next()){
                Chair chair = new ChairBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withState(resultSet.getBoolean("STATE"))
                        .builder();
                chairList.add(chair);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return chairList;
    }

    public boolean delete(int id) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "DELETE FROM CHAIR WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setInt(1,id);
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

    public boolean edit(Chair chair) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            String query = "UPDATE  CHAIR SET NAME = ? WHERE ID = ?";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,chair.getName());
            pstm.setInt(2,chair.getId());
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

    public boolean create(Chair chair) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String query = "INSERT INTO CHAIR (NAME,STATE) VALUES (?,?)";
            pstm = conn.prepareStatement(query);
            pstm.setString(1,chair.getName());
            pstm.setBoolean(2,true);
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

    public boolean active(int id,boolean state) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            String query = "UPDATE  CHAIR SET STATE = ? WHERE ID = ?";
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
