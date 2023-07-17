package repository;

import entity.Booking;
import entity.Passenger;
import service.builder.BookingBuilder;
import service.builder.PassemgerBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static constant.Query.C_PASSENGER;
import static constant.Query.R_PASSENGER;

public class PassengerRepository {
    public boolean create(Passenger passenger) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(C_PASSENGER);
            pstm.setInt(1, passenger.getBookingId());
            pstm.setString(2, passenger.getFirtName());
            pstm.setString(3,passenger.getMiddleName());
            pstm.setString(4,passenger.getLastName());
            pstm.setDate(5,passenger.getBirth());
            pstm.setString(6,passenger.getEmail());
            pstm.setString(7,passenger.getAddress());
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

    public Passenger getById(int bookingId) throws SQLException, ClassNotFoundException {
        Passenger passenger = null;
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_PASSENGER);
            pstm.setInt(1,bookingId);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                passenger = new PassemgerBuilder()
                        .withBookingId(resultSet.getInt("B_ID"))
                        .withFirtName(resultSet.getString("F_NAME"))
                        .withMiddleName(resultSet.getString("M_NAME"))
                        .withLastName(resultSet.getString("L_NAME"))
                        .withBirthDate(resultSet.getDate("BIRTH"))
                        .withEmail(resultSet.getString("EMAIL"))
                        .withAddress(resultSet.getString("ADDRESS"))
                        .builder();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return passenger;
    }
}
