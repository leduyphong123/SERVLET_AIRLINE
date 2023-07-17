package repository;

import entity.Acount;
import service.builder.AcountBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static constant.Query.R_ACOUNT;

public class LoginRepository {
    public Acount login(String email, String password) throws SQLException, ClassNotFoundException {
        Acount user=null;
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_ACOUNT);
            pstm.setString(1,email);
            pstm.setString(2,password);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                user = new AcountBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withName(resultSet.getString("NAME"))
                        .withEmail(resultSet.getString("EMAIL"))
                        .withPassword(resultSet.getString("PASSWORD"))
                        .withState(resultSet.getString("STATE"))
                        .builder();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return user;
    }
}
