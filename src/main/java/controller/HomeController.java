package controller;

import entity.Chair;
import entity.City;
import service.ChairService;
import service.CityService;
import service.impl.ChairServiceImpl;
import service.impl.CityServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeController" , value = "/home")
public class HomeController extends HttpServlet{
    private CityService cityService;
    private ChairService chairService;
    public HomeController (){
        cityService = new CityServiceImpl();
        chairService = new ChairServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
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
        dispatcher.forward(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
