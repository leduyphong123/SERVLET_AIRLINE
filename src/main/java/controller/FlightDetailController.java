package controller;
import dto.AirplaneChairDTO;
import dto.SearchFlight;
import service.AirplaneChairService;
import service.BookingService;
import service.SearchService;
import service.impl.AirplaneChairServiceImpl;
import service.impl.BookingServiceImpl;
import service.impl.SearchServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
@WebServlet(name = "FlightDetailController",value = "/flightDetail")
public class FlightDetailController extends HttpServlet{
    private BookingService bookingService;
    private SearchService searchService;
    private AirplaneChairService airplaneChairService;
    public FlightDetailController (){
        bookingService = new BookingServiceImpl();
        searchService = new SearchServiceImpl();
        airplaneChairService = new AirplaneChairServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "view":
                break;
            default:
                int searchFlightId = Integer.parseInt(request.getParameter("id"));
                try {
                    SearchFlight searchFlight = searchService.getAllById(searchFlightId);
                    List<AirplaneChairDTO> airplaneChairDTOList = airplaneChairService.getByIdAirplaneDate(searchFlight.getAirplaneId(),searchFlight.getAirplaneChairDate());
                    request.setAttribute("element",searchFlight);
                    request.setAttribute("airplaneChairDTOList",airplaneChairDTOList);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/flightDetail.jsp");
                dispatcher.forward(request,response);
        }
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
