package Controler;

import Model.GestionUser;
import Model.IGestionUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/auth")

public class AuthenticationServlet extends HttpServlet {
    private IGestionUser user = new GestionUser();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (user.authentifier(username, password)) {
            HttpSession session=request.getSession();
            session.setAttribute("username",username);
            session.setMaxInactiveInterval(30 * 60);
            Cookie sessionCookie = new Cookie("JSESSIONID", session.getId());
            sessionCookie.setMaxAge(30*60);
            sessionCookie.setPath(request.getContextPath());
            response.addCookie(sessionCookie);

            response.sendRedirect(request.getContextPath() + "/produits");
        }
        else {
            System.err.println("Veuillez vérifier vos credentials");

            request.setAttribute("error", "Identifiants incorrects");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}