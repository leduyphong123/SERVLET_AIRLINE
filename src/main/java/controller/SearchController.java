package controller;

import dto.SearchFlight;
import service.SearchService;
import service.impl.SearchServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchController" , value = "/search")
public class SearchController extends HttpServlet{
    private SearchService searchService;
    public SearchController (){
        searchService = new SearchServiceImpl();
    }
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response){

    }
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response){
        int formCityId = Integer.parseInt(request.getParameter("formCity"));
        int toCityId = Integer.parseInt(request.getParameter("toCity"));
        int numberPeple = Integer.parseInt(request.getParameter("numberPeple"));
        Date formDate = Date.valueOf(request.getParameter("formDate"));
        String returnDate = request.getParameter("returnDate");
        int chairId = Integer.parseInt(request.getParameter("chair"));
        try {
            List<SearchFlight>searchFlightList = searchService.getAll(formCityId,toCityId,numberPeple,formDate,returnDate,chairId);
            request.setAttribute("searchFlightList",searchFlightList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/user/searchList.jsp");
            requestDispatcher.forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
