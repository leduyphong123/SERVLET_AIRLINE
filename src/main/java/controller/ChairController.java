package controller;
import entity.Airline;
import entity.Chair;
import service.ChairService;
import service.impl.ChairServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ChairController",value = "/chair")
public class ChairController extends HttpServlet{
    private ChairService chairService ;
    public ChairController(){
        chairService = new ChairServiceImpl();
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
                dispatcher = request.getRequestDispatcher("view/admin/createChair.jsp");
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
        Chair chair = null;
        chair = chairService.getById(id);
        request.setAttribute("element", chair);
        dispatcher = request.getRequestDispatcher("view/admin/editChair.jsp");
        dispatcher.forward(request, response);
    }

    private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Chair> chairList = null;
        try {
            chairList = chairService.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("elementList", chairList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/chair.jsp");
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
                    boolean result = chairService.active(id,state);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                response.sendRedirect("/chair");
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean result = chairService.delete(id);
        response.sendRedirect("/chair");

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean result = false;
        result = chairService.edit(id, name);
        request.setAttribute("success", result);
        doGet(request, response);
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        String name = request.getParameter("name");
        boolean result = false;
        result = chairService.create(name);
        request.setAttribute("success", result);
        doGet(request, response);
    }
}
