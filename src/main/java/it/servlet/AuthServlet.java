package it.servlet;

import it.services.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login")
public class AuthServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String passwordSecure  = null;
        //cifraPassword("1234");
        try {
          passwordSecure = cifraPassword(password);
            System.out.println("password sicura "+passwordSecure);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (verificaLogin(username, passwordSecure)) {
            //accedi
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("password", passwordSecure );
            resp.sendRedirect("Ciclo");
        } else {
            //pagina di errore
            req.getSession().setAttribute("username",username);
            req.getRequestDispatcher("jsp/paginaErrore.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private boolean verificaLogin(String username, String password) {
         return  userService.verificaLogin(username, password);
    }

    private  String cifraPassword( String password ) throws NoSuchAlgorithmException {
        String passwordSecure = BCrypt.hashpw(password, "ciao");
        return passwordSecure;
    }
}
