package controller;

import dto.AirplaneChairDTO;
import dto.FlightDTO;
import entity.*;
import service.*;
import service.impl.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "FlightController", value = "/flight")
public class FlightController extends HttpServlet {
    private FlightService flightService;
    private AirplaneService airplaneService;
    private AirplaneChairService airplaneChairService;
    private CityService cityService;
    private AirlineService airlineService;

    public FlightController() {
        flightService = new FlightServiceImpl();
        airplaneService = new AirplaneServiceImpl();
        cityService = new CityServiceImpl();
        airplaneChairService = new AirplaneChairServiceImpl();
        airlineService = new AirlineServiceImpl();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aution = request.getParameter("aution");
        if (aution == null) {
            aution = "";
        }
        RequestDispatcher dispatcher = null;
        switch (aution) {
            case "create":
                try {
                    createView(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    editViewCity(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "view":
                try {
                    viewFlightDetail(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                getJoinAll(request, response);
                break;
        }
    }

    private void viewFlightDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Flight flight = null;
        flight = flightService.getById(id);
        request.setAttribute("flight", flight);
        City toCity = cityService.getById(flight.getToCity());
        City formCity = cityService.getById(flight.getToCity());
        request.setAttribute("toCity",toCity);
        request.setAttribute("formCity",formCity);
        Airplane airplane = airplaneService.getByApId(flight.getApId());
        request.setAttribute("airplane",airplane);
        Airline airline = airlineService.getById(airplane.getAlId());
        request.setAttribute("airline",airline);
        List<AirplaneChairDTO> airplaneChairDTOList = airplaneChairService.getByApIdDate(flight.getApId(),flight.getToDate());
        request.setAttribute("airplaneChairDTOList",airplaneChairDTOList);
        RequestDispatcher dispatcher1 = request.getRequestDispatcher("view/admin/viewFlight.jsp");
        dispatcher1.forward(request, response);
    }

    private void createView(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        RequestDispatcher dispatcher;
        List<Airplane> airplaneList = airplaneService.getAll();
        List<City> cityList = cityService.getAll();
        request.setAttribute("elementListAirplaneMin", airplaneList);
        request.setAttribute("elementListCityMin", cityList);
        dispatcher = request.getRequestDispatcher("view/admin/createFlight.jsp");
        dispatcher.forward(request, response);
    }

    private void editViewCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher;
        List<Airplane> airplaneList = airplaneService.getAll();
        List<City> cityList = cityService.getAll();
        request.setAttribute("elementListAirplaneMin", airplaneList);
        request.setAttribute("elementListCityMin", cityList);
        int id = Integer.parseInt(request.getParameter("id"));
        Flight flight = null;
        flight = flightService.getById(id);
        request.setAttribute("element", flight);
        dispatcher = request.getRequestDispatcher("view/admin/editFlight.jsp");
        dispatcher.forward(request, response);
    }

    private void getJoinAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FlightDTO> flightDTOList = null;
        try {
            flightDTOList = flightService.getJoinAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("elementList", flightDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/flight.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aution = request.getParameter("aution");
        if (aution == null) {
            aution = "";
        }
        switch (aution) {
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "edit":
                try {
                    edit(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "active":
                int id = Integer.parseInt(request.getParameter("id"));
                boolean state = Boolean.parseBoolean(request.getParameter("state"));
                try {
                    boolean result = flightService.active(id, state);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect("/flight");
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = flightService.delete(id);
        response.sendRedirect("/flight");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        int toCity = Integer.parseInt(request.getParameter("toCity"));
        System.out.println(request.getParameter("toDate"));
        String toDate = request.getParameter("toDate");
        int formCity = Integer.parseInt(request.getParameter("formCity"));
        String formDate = request.getParameter("formDate");
        String usedCapacity = request.getParameter("usedCapacity");
        int apId = Integer.parseInt(request.getParameter("apId"));
        boolean result = false;
        result = flightService.edit(id, toCity, toDate, formCity, formDate, usedCapacity, apId);
        request.setAttribute("success", result);
        doGet(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int toCity = Integer.parseInt(request.getParameter("toCity"));
        System.out.println(request.getParameter("toDate"));
        String toDate = request.getParameter("toDate");
        int formCity = Integer.parseInt(request.getParameter("formCity"));
        String formDate = request.getParameter("formDate");
        String usedCapacity = request.getParameter("usedCapacity");
        int apId = Integer.parseInt(request.getParameter("apId"));
        boolean result = false;
        result = flightService.create(toCity, toDate, formCity, formDate, usedCapacity, apId);
        request.setAttribute("success", result);
        doGet(request, response);
    }
}
