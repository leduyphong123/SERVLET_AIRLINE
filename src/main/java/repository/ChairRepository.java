package repository;

import entity.Chair;
import service.builder.ChairBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constant.Query.*;

public class ChairRepository {
    public List<Chair> getAll() throws SQLException, ClassNotFoundException {
        List<Chair> chairList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm  = null;
        try {
            pstm = conn.prepareStatement(R_CHAIR);
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
            pstm = conn.prepareStatement(D_CHAIR);
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
            pstm = conn.prepareStatement(U_CHAIR);
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
            pstm = conn.prepareStatement(C_CHAIR);
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
            pstm = conn.prepareStatement(U_STATE_CHAIR);
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

    public List<Chair> getPageAll(int start, int limit) throws SQLException, ClassNotFoundException {
        List<Chair> chairList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm  = null;
        try {
            pstm = conn.prepareStatement(R_LIMIT_CHAIR);
            pstm.setInt(1,start);
            pstm.setInt(2,limit);
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
}
