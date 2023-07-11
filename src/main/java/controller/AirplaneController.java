package controller;

import dto.AirplaneDTO;
import entity.Airline;
import entity.Airplane;
import service.AirlineService;
import service.AirplaneService;
import service.impl.AirlineServiceImpl;
import service.impl.AirplaneServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="AirplaneController" , value = "/airplane")
public class AirplaneController extends HttpServlet{
    private AirplaneService airplaneSerice;
    public AirplaneController(){
        airplaneSerice = new AirplaneServiceImpl();
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
                ceateView(request, response);
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
            default:
                try {
                    getJoinAll(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private static void ceateView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        AirlineService airlineService = new AirlineServiceImpl();
        List<Airline> airlineList = null;
        try {
            airlineList = airlineService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("elementListMin",airlineList);
        dispatcher = request.getRequestDispatcher("view/admin/createAirplane.jsp");
        dispatcher.forward(request, response);
    }

    private void editViewCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher;
        AirlineService airlineService = new AirlineServiceImpl();
        List<Airline> airlineList = null;
        try {
            airlineList = airlineService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int id = Integer.parseInt(request.getParameter("id"));
        Airplane airplaneModel = null;
        airplaneModel = airplaneSerice.getById(id);
        request.setAttribute("elementListMin",airlineList);
        request.setAttribute("element", airplaneModel);
        dispatcher = request.getRequestDispatcher("view/admin/editAirplane.jsp");
        dispatcher.forward(request, response);
    }

    private void getJoinAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        List<AirplaneDTO> airplaneDTOList = null;
        try {
            airplaneDTOList = airplaneSerice.getJoinAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("elementList", airplaneDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/airplane.jsp");
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
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = airplaneSerice.delete(id);
        response.sendRedirect("/airplane");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortName");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        int al_id = Integer.parseInt(request.getParameter("alId"));
        boolean result = false;
        result = airplaneSerice.edit(id, name, shortName,capacity,al_id);
        request.setAttribute("success", result);
        doGet(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortName");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        int alId = Integer.parseInt(request.getParameter("alId"));
        boolean result = false;
        result = airplaneSerice.create(name, shortName,capacity,alId);
        request.setAttribute("success", result);
        doGet(request, response);
    }
}
