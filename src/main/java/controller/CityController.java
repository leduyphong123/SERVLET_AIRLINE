package controller;

import entity.City;
import service.CityService;
import service.impl.CityServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CityController", value = "/city")
public class CityController extends HttpServlet {
    private CityService cityService = new CityServiceImpl();

    public CityController() {
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
                dispatcher = request.getRequestDispatcher("view/admin/createCity.jsp");
                dispatcher.forward(request, response);
                break;
            case "edit":
                editViewCity(request, response);
                break;
            default:
                getAll(request, response);
                break;
        }
    }

    private void editViewCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        int id = Integer.parseInt(request.getParameter("id"));
        City city = null;
        try {
            city = cityService.getById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("element", city);
        dispatcher = request.getRequestDispatcher("view/admin/editCity.jsp");
        dispatcher.forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<City> cityList = null;
        try {
            cityList = cityService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("elementList", cityList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/city.jsp");
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
                createCity(request, response);
                break;
            case "edit":
                try {
                    editCity(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "delete":
                try {
                    deleteCity(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void deleteCity(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = cityService.delete(id);
        response.sendRedirect("/city");

    }

    private void editCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortName");
        boolean result = false;
        result = cityService.edit(id, name, shortName);
        request.setAttribute("success", result);
        doGet(request, response);
    }

    private void createCity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String shortName = request.getParameter("shortName");
        boolean result = false;
        try {
            result = cityService.create(name, shortName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("success", result);
        doGet(request, response);
    }
}
