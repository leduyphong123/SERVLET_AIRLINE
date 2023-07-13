package controller;


import dto.AirplaneChairDTO;
import entity.Airline;
import entity.Airplane;
import entity.AirplaneChair;
import entity.Chair;
import service.AirlineService;
import service.AirplaneChairService;
import service.AirplaneService;
import service.ChairService;
import service.impl.AirlineServiceImpl;
import service.impl.AirplaneChairServiceImpl;
import service.impl.AirplaneServiceImpl;
import service.impl.ChairServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "AirplaneChairController",value = "/airplaneChair")
public class AirplaneChairController extends HttpServlet{
    private AirplaneChairService airplaneChairService ;
    private AirplaneService airplaneService;
    private ChairService chairService;
    private AirlineService airlineService;
    public AirplaneChairController(){
        airplaneChairService = new AirplaneChairServiceImpl();
        airplaneService = new AirplaneServiceImpl();
        chairService = new ChairServiceImpl();
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
                    viewDetail(request, response);
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

    private void viewDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        AirplaneChairDTO airplaneChairDTO = airplaneChairService.getJoinById(id);
        Airline airline = airlineService.getById(airplaneChairDTO.getApId());
        request.setAttribute("airline",airline);
        request.setAttribute("element",airplaneChairDTO);
        RequestDispatcher dispatcher1 = request.getRequestDispatcher("view/admin/viewAirplaneChair.jsp");
        dispatcher1.forward(request, response);
    }

    private void createView(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        RequestDispatcher dispatcher;
        List<Airplane> elementListAirplaneMin =  airplaneService.getAll();
        List<Chair> elementListChairMin = chairService.getAll();
        request.setAttribute("elementListAirplaneMin",elementListAirplaneMin);
        request.setAttribute("elementListChairMin",elementListChairMin);
        dispatcher = request.getRequestDispatcher("view/admin/createAirplaneChair.jsp");
        dispatcher.forward(request, response);
    }

    private void editViewCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher dispatcher;
        List<Airplane> elementListAirplaneMin =  airplaneService.getAll();
        List<Chair> elementListChairMin = chairService.getAll();
        request.setAttribute("elementListAirplaneMin",elementListAirplaneMin);
        request.setAttribute("elementListChairMin",elementListChairMin);
        int id = Integer.parseInt(request.getParameter("id"));
        AirplaneChair airplaneChair = null;
        airplaneChair = airplaneChairService.getById(id);
        request.setAttribute("element", airplaneChair);
        dispatcher = request.getRequestDispatcher("view/admin/editAirplaneChair.jsp");
        dispatcher.forward(request, response);
    }

    private void getJoinAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AirplaneChairDTO> airplaneChairDTOList = null;
        try {
            airplaneChairDTOList = airplaneChairService.getJoinAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("elementList", airplaneChairDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/airplaneChair.jsp");
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
                    boolean result = airplaneChairService.active(id,state);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect("/airplaneChair");
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = airplaneChairService.delete(id);
        response.sendRedirect("/airplaneChair");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        long price = Long.parseLong(request.getParameter("price"));
        String used = request.getParameter("used");
        Date date = Date.valueOf(request.getParameter("date"));
        int apId = Integer.parseInt(request.getParameter("apId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        boolean result = false;
        result = airplaneChairService.edit(id,quantity,price,used,date,apId,cId);
        request.setAttribute("success", result);
        doGet(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        long price = Long.parseLong(request.getParameter("price"));
        String used = request.getParameter("used");
        Date date = Date.valueOf(request.getParameter("date"));
        int apId = Integer.parseInt(request.getParameter("apId"));
        int cId = Integer.parseInt(request.getParameter("cId"));
        boolean result = false;
        result = airplaneChairService.create(quantity,price,used,date,apId,cId);
        request.setAttribute("success", result);
        doGet(request, response);
    }
}
