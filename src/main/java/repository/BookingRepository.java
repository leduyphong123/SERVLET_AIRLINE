package repository;

import entity.Booking;
import service.builder.BookingBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static constant.Query.*;

public class BookingRepository {
    public boolean create(Booking booking) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(C_BOOKING);
            pstm.setTimestamp(1, booking.getBookingDate());
            pstm.setLong(2, booking.getPrice());
            pstm.setInt(3,booking.getAcountId());
            pstm.setInt(4,booking.getFlightId());
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

    public Booking getOneBooking(Booking booking) throws SQLException, ClassNotFoundException {
        Booking resultBooking = null;
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            String timeRound =booking.getBookingDate().toString().substring(18,21);
            String miuter = String.valueOf(Math.round( Float.parseFloat(timeRound)));
            String parseDate = booking.getBookingDate().toString().substring(0,18);
            Timestamp paserDate = Timestamp.valueOf(parseDate+miuter.substring(0,1));
            pstm = conn.prepareStatement(R_ONE_BOOKING);
            pstm.setTimestamp(1, paserDate);
            pstm.setLong(2, booking.getPrice());
            pstm.setInt(3,booking.getAcountId());
            pstm.setInt(4,booking.getFlightId());
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                resultBooking = new BookingBuilder()
                         .withId(resultSet.getInt("ID"))
                        .withBookingDate(resultSet.getTimestamp("BOOKING_DATE_TIME"))
                         .withluggage(resultSet.getInt("LUGGAGE"))
                        .withPrice(resultSet.getLong("PRICE"))
                         .withState(resultSet.getString("STATE"))
                         .withAcountId(resultSet.getInt("AC_ID"))
                        .withFlightId(resultSet.getInt("F_ID"))
                        .builder();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return resultBooking;
    }

    public List<Booking> getAll() throws SQLException, ClassNotFoundException {
        List<Booking> resultBookingList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_BOOKING);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                 Booking booking = new BookingBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withBookingDate(resultSet.getTimestamp("BOOKING_DATE_TIME"))
                        .withluggage(resultSet.getInt("LUGGAGE"))
                        .withPrice(resultSet.getLong("PRICE"))
                        .withState(resultSet.getString("STATE"))
                        .withAcountId(resultSet.getInt("AC_ID"))
                        .withFlightId(resultSet.getInt("F_ID"))
                        .builder();
                 resultBookingList.add(booking);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return resultBookingList;
    }

    public Booking getById(int bookingId) throws SQLException, ClassNotFoundException {
        Booking resultBooking = null;
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_ID_BOOKING);
            pstm.setInt(1,bookingId);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                resultBooking = new BookingBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withBookingDate(resultSet.getTimestamp("BOOKING_DATE_TIME"))
                        .withluggage(resultSet.getInt("LUGGAGE"))
                        .withPrice(resultSet.getLong("PRICE"))
                        .withState(resultSet.getString("STATE"))
                        .withAcountId(resultSet.getInt("AC_ID"))
                        .withFlightId(resultSet.getInt("F_ID"))
                        .builder();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return resultBooking;
    }

    public boolean updateState(int id, String newState) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(U_STATE_BOOKING);
            pstm.setString(1,newState);
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

    public List<Booking> getPageAll(int start,int limit) throws SQLException, ClassNotFoundException {
        List<Booking> resultBookingList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(R_LIMIT_BOOKING);
            pstm.setInt(1,start);
            pstm.setInt(2,limit);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()){
                Booking booking = new BookingBuilder()
                        .withId(resultSet.getInt("ID"))
                        .withBookingDate(resultSet.getTimestamp("BOOKING_DATE_TIME"))
                        .withluggage(resultSet.getInt("LUGGAGE"))
                        .withPrice(resultSet.getLong("PRICE"))
                        .withState(resultSet.getString("STATE"))
                        .withAcountId(resultSet.getInt("AC_ID"))
                        .withFlightId(resultSet.getInt("F_ID"))
                        .builder();
                resultBookingList.add(booking);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return resultBookingList;

    }
}
