package it.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Ciclo")
public class Ciclo extends HttpServlet {
    public static int contatore=5; //per farne 5
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       controlloTentativi(request,response);
    }

    private void controlloTentativi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if(contatore>0)
        {
            contatore --;
            request.getSession().setAttribute("tentativi", contatore);
            request.getRequestDispatcher("jsp/game.jsp").include(request,response);
        }else
        {
            request.getRequestDispatcher("jsp/saluti.jsp").include(request,response);
        }
    }
}
