package it.servlet;

import it.controller.Controller;
import it.javaBean.UserBean;
import it.controller.UserController;
import it.dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/Start")
public class ServletStart extends HttpServlet {
    private static final long serialVersionUID=1L;

    private UserController userController;

    @Override
    public void init() throws ServletException {

        userController = new UserController();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      /*  //Se utente vuole la classifica
        if( request.getParameterMap().containsKey("Classifica")) {
            mostraClassifica(request,response);
        }
        //se utente vuole giocare
        else {
            setUsername(request, response);
        }*/
        Controller controller  = new Controller();
        controller.createTableModel();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doGet(request,response);
    }

    private void setUsername(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        String username=request.getParameter("username");
        request.getSession().setAttribute("username", username);
        if( userController.addUser(username) )
            response.sendRedirect("Ciclo");
        else {
            request.getRequestDispatcher("jsp/paginaErrore.jsp").forward(request,response);
           // response.sendRedirect("jsp/paginaErrore.jsp");
        }
    }

    private UserBean calcolaTabellaUtente() {
        UserBean userBean = new UserBean();
        userBean.setUtenti ((ArrayList<UserDTO>) userController.getUsers());
        Collections.sort(userBean.getUtenti());
        return userBean;
    }

    private void mostraClassifica(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException  {

            request.setAttribute("listaUser", calcolaTabellaUtente());
            request.getRequestDispatcher("jsp/tabella.jsp").forward(request, response);
        }
}


