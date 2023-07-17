package controller;

import dto.AirplaneChairDTO;
import dto.SearchFlight;
import entity.*;
import service.*;
import service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "BookingController",value = "/booking")
public class BookingController extends HttpServlet{
    private BookingService bookingService;
    private SearchService searchService;
    private CityService cityService;
    private ChairService chairService;
    private PassengerService passengerService;
    public BookingController (){
        bookingService = new BookingServiceImpl();
        searchService = new SearchServiceImpl();
        cityService = new CityServiceImpl();
        chairService = new ChairServiceImpl();
        passengerService = new PassengerServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "adminViewDetails":
                adminViewDetails(request, response);
                break;
            case "adminView":
                try {
                    adminView(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "adminEdit":
                try {
                    adminView(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "active":
                adminCheckIn(request, response);

                break;
            case "create":
            default:
                viewUserCreate(request, response);
        }
    }

    private void adminCheckIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            String state = request.getParameter("state");
            try {
                boolean isResult = bookingService.updateState(id,state);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            try {
                adminView(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            response.sendRedirect("/login");
        }
    }

    private void adminViewDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            int bookingId = Integer.parseInt(request.getParameter("id"));
            try {
                Booking booking = bookingService.getById(bookingId);
                Passenger passenger = passengerService.getById(bookingId);
                SearchFlight searchFlight = searchService.getAllById(booking.getFlightId());
                request.setAttribute("booking",booking);
                request.setAttribute("passenger",passenger);
                request.setAttribute("searchFlight",searchFlight);
                RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/viewBooking.jsp");
                dispatcher.forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }else {
            response.sendRedirect("/login");
        }

    }

    private void adminView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){
            List<Booking> bookingList = null;
            int page = Integer.parseInt(request.getParameter("page"));
            try {
                bookingList = bookingService.getPageAll(page);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            int indexPage = bookingService.getIndexPage();
            request.setAttribute("indexPage",indexPage);
            request.setAttribute("bookingList",bookingList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/booking.jsp");
            dispatcher.forward(request, response);
        }else {
            response.sendRedirect("/login");
        }

    }

    private void viewUserCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int searchFlightId = Integer.parseInt(request.getParameter("idFlight"));
        int airplanChairId = Integer.parseInt(request.getParameter("flexRadioDefault"));

        SearchFlight searchFlight = null;
        try {
            searchFlight = searchService.getAllById(searchFlightId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("element",searchFlight);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/booking.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action) {
            case "view":
                view(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "active":
                int id = Integer.parseInt(request.getParameter("id"));
                String state = request.getParameter("state");
                try {
                    boolean isResult = bookingService.updateState(id,state);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try {
                    adminView(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idFlight = Integer.parseInt(request.getParameter("idFlight"));
        int idApc = Integer.parseInt(request.getParameter("idApc"));
        String firtName = request.getParameter("firtName");
        String middleName = request.getParameter("middleName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        Date birthDate = Date.valueOf(request.getParameter("birthDate"));
        String address = request.getParameter("address");
        String idUser = request.getParameter("idUser");
        try {
            boolean result = bookingService.create(idFlight,idApc,firtName,middleName,lastName,email,birthDate,address,idUser);
            if (result){
                rederectHome(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void rederectHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> cityList = null;
        try {
            cityList = cityService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("cityList",cityList);
        List<Chair> chairList = null;
        try {
            chairList = chairService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("chairList",chairList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/home.jsp");
        dispatcher.forward(request, response);
    }

    private void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int searchFlightId = Integer.parseInt(request.getParameter("idFlight"));
        int airplanChairId = Integer.parseInt(request.getParameter("flexRadioDefault"));
        String idUser = request.getParameter("idUser");
        try {
            SearchFlight searchFlight = searchService.getAllById(searchFlightId);
            request.setAttribute("element",searchFlight);
            request.setAttribute("airplanChairId",airplanChairId);
            request.setAttribute("idUser",idUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/booking.jsp");
        dispatcher.forward(request, response);
    }
}
