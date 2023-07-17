package controller;

import entity.Acount;
import service.LoginService;
import service.impl.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LoginController",value = "/login")

public class LoginController extends HttpServlet{
    private LoginService loginService = new LoginServiceImpl();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "logout" :
                HttpSession session = request.getSession();
                session.removeAttribute("user");
                response.sendRedirect("/login");
                break;
            default:
                RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/login.jsp");
                dispatcher.forward(request,response);
        }

    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Acount user = null;
        try {
            user = loginService.login(email,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (user !=null){
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/dasboard");
        }else {
            doGet(request,response);
        }
    }
}
