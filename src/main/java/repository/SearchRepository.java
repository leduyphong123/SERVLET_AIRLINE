package repository;

import dto.SearchFlight;
import service.builder.SearchFlightBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static constant.Query.R_VIEW_FLIGHT_DATE_CHAIR;
import static constant.Query.R_VIEW_FLIGHT_DATE_CHAIR_BY_ID;

public class SearchRepository {
    public List<SearchFlight> getAll(int formCityId, int toCityId, int chairId) throws SQLException, ClassNotFoundException {
        List<SearchFlight> searchFlightList = new ArrayList<>();
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            pstm = conn.prepareStatement(R_VIEW_FLIGHT_DATE_CHAIR);
            pstm.setInt(1,formCityId);
            pstm.setInt(2,toCityId);
            pstm.setInt(3,chairId);
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()){
                SearchFlight searchFlight = new SearchFlightBuilder()
                        .withFlightId(resultSet.getInt("F_ID"))
                        .withFlightToCity(resultSet.getInt("F_TO_CITY"))
                        .withFlightToDate(resultSet.getTimestamp("F_TO_DATE"))
                        .withFlightFormCity(resultSet.getInt("F_FORM_CITY"))
                        .withFlightFormDate(resultSet.getTimestamp("F_FORM_DATE"))
                        .withFlightUsedCapacity(resultSet.getInt("F_USED_CAPACITY"))
                        .withAirplaneId(resultSet.getInt("AP_ID"))
                        .withAirplaneName(resultSet.getString("AP_NAME"))
                        .withAirplaneShortName(resultSet.getString("AP_SHORT_NAME"))
                        .withAirplaneCapacity(resultSet.getInt("AP_CAPACITY"))
                        .withAirlineId(resultSet.getInt("AL_ID"))
                        .withAirlineName(resultSet.getString("AL_NAME"))
                        .withAirlineShortName(resultSet.getString("AL_SHORT_NAME"))
                        .withToCityName(resultSet.getString("CT_NAME"))
                        .withToCiTyShortName(resultSet.getString("CT_SHORT_NAME"))
                        .withFormCityName(resultSet.getString("CTY_NAME"))
                        .withFormCityShortName(resultSet.getString("CTY_SHORT_NAME"))
                        .withApChairId(resultSet.getInt("APC_ID"))
                        .withApChairQuantity(resultSet.getInt("APC_QUANTITY"))
                        .withApChairPrice(resultSet.getLong("APC_PRICE"))
                        .withApChairUsedQuantity(resultSet.getInt("APC_USED"))
                        .withApChairDate(resultSet.getDate("APC_DATE"))
                        .withChairId(resultSet.getInt("C_ID"))
                        .withChairName(resultSet.getString("C_NAME"))
                        .builder();
                searchFlightList.add(searchFlight);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return searchFlightList;
    }

    public SearchFlight getAllById(int searchFlightId) throws SQLException, ClassNotFoundException {
        Connection conn = ConectionConfig.getConection();
        PreparedStatement pstm = null;
        try{
            pstm = conn.prepareStatement(R_VIEW_FLIGHT_DATE_CHAIR_BY_ID);
            pstm.setInt(1,searchFlightId);
            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()){
                SearchFlight searchFlight = new SearchFlightBuilder()
                        .withFlightId(resultSet.getInt("F_ID"))
                        .withFlightToCity(resultSet.getInt("F_TO_CITY"))
                        .withFlightToDate(resultSet.getTimestamp("F_TO_DATE"))
                        .withFlightFormCity(resultSet.getInt("F_FORM_CITY"))
                        .withFlightFormDate(resultSet.getTimestamp("F_FORM_DATE"))
                        .withFlightUsedCapacity(resultSet.getInt("F_USED_CAPACITY"))
                        .withAirplaneId(resultSet.getInt("AP_ID"))
                        .withAirplaneName(resultSet.getString("AP_NAME"))
                        .withAirplaneShortName(resultSet.getString("AP_SHORT_NAME"))
                        .withAirplaneCapacity(resultSet.getInt("AP_CAPACITY"))
                        .withAirlineId(resultSet.getInt("AL_ID"))
                        .withAirlineName(resultSet.getString("AL_NAME"))
                        .withAirlineShortName(resultSet.getString("AL_SHORT_NAME"))
                        .withToCityName(resultSet.getString("CT_NAME"))
                        .withToCiTyShortName(resultSet.getString("CT_SHORT_NAME"))
                        .withFormCityName(resultSet.getString("CTY_NAME"))
                        .withFormCityShortName(resultSet.getString("CTY_SHORT_NAME"))
                        .withApChairId(resultSet.getInt("APC_ID"))
                        .withApChairQuantity(resultSet.getInt("APC_QUANTITY"))
                        .withApChairPrice(resultSet.getLong("APC_PRICE"))
                        .withApChairUsedQuantity(resultSet.getInt("APC_USED"))
                        .withApChairDate(resultSet.getDate("APC_DATE"))
                        .withChairId(resultSet.getInt("C_ID"))
                        .withChairName(resultSet.getString("C_NAME"))
                        .builder();
                return searchFlight;

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            pstm.close();
            conn.close();
        }
        return null;
    }
}
