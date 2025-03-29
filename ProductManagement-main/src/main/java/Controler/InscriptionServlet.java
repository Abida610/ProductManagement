package Controler;

import Model.GestionUser;
import Model.IGestionUser;
import Model.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/register")

public class InscriptionServlet extends HttpServlet {
    private IGestionUser user=new GestionUser();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);


        try {
            User newUser = new User(username, password);
            user.inscrire(newUser);
            HttpSession session = request.getSession();
            session.setAttribute("user", newUser);
            response.sendRedirect("listeProduits.jsp");
        } catch (IllegalStateException e) {
            System.err.println("ERREUR INSCRIPTION: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
