package Controler;

import DAO.ProduitDAO;
import Model.Produit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/produits")
public class ProduitServlet extends HttpServlet {
    private ProduitDAO produitDAO;

    @Override
    public void init() throws ServletException {
        produitDAO = new ProduitDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }


        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; // Action par défaut
        }

        switch (action) {
            case "ajouter":
                handleAjouter(request, response);
                break;
            case "modifier":
                handleModifier(request, response);
                break;
            case "details":
                handleDetails(request, response);
                break;
            case "supprimer":
                handleSupprimer(request, response);
                break;
            case "list":
            default:
                handleList(request, response);
                break;
        }
    }

    private void handleAjouter(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("ajouterProduit.jsp");
        dispatcher.forward(request, response);
    }

    private void handleModifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Produit produit = produitDAO.getProduitById(id);
            if (produit != null) {
                request.setAttribute("produit", produit);
                RequestDispatcher dispatcher = request.getRequestDispatcher("modifierProduit.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("produits?action=list");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("produits?action=list");
        }
    }


    private void handleDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Produit produit = produitDAO.getProduitById(id);
            if (produit != null) {
                request.setAttribute("produit", produit);
                RequestDispatcher dispatcher = request.getRequestDispatcher("detailsProduit.jsp");
                dispatcher.forward(request, response);
            } else {
                response.sendRedirect("produits?action=list");
            }
        } catch (NumberFormatException e) {
            response.sendRedirect("produits?action=list");
        }
    }

    private void handleSupprimer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            produitDAO.supprimerProduit(id);
        } catch (NumberFormatException e) {
            // Log erreur si nécessaire
        }
        response.sendRedirect("produits?action=list");
    }

    private void handleList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produit> listeProduits = produitDAO.getAllProduits();
        System.out.println(listeProduits);
        System.out.println(" Nombre de produits récupérés : " + listeProduits.size());
        for (Produit produit : listeProduits) {
            System.out.println("Produit ID: " + produit.getId() + " | Nom: " + produit.getNom());
        }
        request.setAttribute("listeProduits", listeProduits);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listeProduits.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }


        String operation = request.getParameter("operation");

        if ("insert".equals(operation)) {
            ajouterProduit(request);
        } else if ("update".equals(operation)) {
            modifierProduit(request);
        }

        response.sendRedirect("produits?action=list");
    }

    private void ajouterProduit(HttpServletRequest request) {
        try {
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            double prix = Double.parseDouble(request.getParameter("prix"));
            String image = request.getParameter("image");

            Produit nouveauProduit = new Produit(0, nom, description, prix, image);
            produitDAO.ajouterProduit(nouveauProduit);
        } catch (NumberFormatException e) {
            // Log erreur si nécessaire
        }
    }

    private void modifierProduit(HttpServletRequest request) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String description = request.getParameter("description");
            double prix = Double.parseDouble(request.getParameter("prix"));
            String image = request.getParameter("image");

            Produit produit = new Produit(id, nom, description, prix, image);
            produitDAO.modifierProduit(produit);
        } catch (NumberFormatException e) {
            // Log erreur si nécessaire
        }
    }

}
