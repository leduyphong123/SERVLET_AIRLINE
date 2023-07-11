package controller;

import entity.Airline;
import service.AirlineService;
import service.impl.AirlineServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AirlineController",value = "/airline")
public class AirlineController extends HttpServlet{
    private AirlineService airlineService = null;
    public AirlineController(){
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
                dispatcher = request.getRequestDispatcher("view/admin/createAirline.jsp");
                dispatcher.forward(request, response);
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
                getAll(request, response);
                break;
        }
    }

    private void editViewCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher;
        int id = Integer.parseInt(request.getParameter("id"));
        Airline airline = null;
        airline = airlineService.getById(id);
        request.setAttribute("element", airline);
        dispatcher = request.getRequestDispatcher("view/admin/editAirline.jsp");
        dispatcher.forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Airline> airlineList = null;
        try {
            airlineList = airlineService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("elementList", airlineList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/airline.jsp");
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

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = airlineService.delete(id);
        response.sendRedirect("/airline");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortName");
        boolean result = false;
        result = airlineService.edit(id, name, shortName);
        request.setAttribute("success", result);
        doGet(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortName");
        boolean result = false;
        result = airlineService.create(name, shortName);
        request.setAttribute("success", result);
        doGet(request, response);
    }
}
