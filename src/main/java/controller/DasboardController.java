package controller;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DasboardController" , value = "/dasboard")
public class DasboardController extends HttpServlet{
    public DasboardController (){}
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null){

        }else {
            response.sendRedirect("/login");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/admin/dasboard.jsp");
        dispatcher.forward(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
