<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Produit" %>


<html>
<head>
    <title>Liste des Produits</title>
    <style>
            body {
                font-family: 'Segoe UI', sans-serif;
                margin: 0;
                padding: 20px;
                background: #f5f7fa;
            }
            .container {
                max-width: 1000px;
                margin: 0 auto;
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            }
            h1 {
                        color: #166088;
                        margin-bottom: 20px;
                    }
                    .header {
                        display: flex;
                        justify-content: space-between;
                        align-items: center;
                        margin-bottom: 20px;
                    }
                    .btn {


                        color:#166088;

                        border-radius: 4px;
                    }
                    table {     margin-top:20px;
                                width: 100%;


                            }



</style>
</head>
<body>
<div class="container">
    <div class="header">
<h1>Liste des Produits!</h1>
<div>
    <a href="<%= request.getContextPath() %>/logout" class="btn">Déconnexion</a>
    </div>
   </div>
    <a href="produits?action=ajouter" class="btn">Ajouter un nouveau produit</a>



    <%
        List<Produit> listeProduits = (List<Produit>) request.getAttribute("listeProduits");
        if (listeProduits != null && !listeProduits.isEmpty()) {
    %>
        <table >
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Description</th>
                <th>Prix</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
            <%
                // Parcourir la liste des produits
                for (Produit produit : listeProduits) {
            %>
                <tr>
                    <td><%= produit.getId() %></td>
                    <td><%= produit.getNom() %></td>
                    <td><%= produit.getDescription() %></td>
                    <td><%= produit.getPrix() %></td>
                    <td><img src="<%= produit.getImage() %>" alt="<%= produit.getNom() %>" width="100"/></td>
                    <td>
                        <a href="produits?action=details&id=<%= produit.getId() %>">Détails</a> |
                        <a href="produits?action=modifier&id=<%= produit.getId() %>">Modifier</a> |
                        <a href="produits?action=supprimer&id=<%= produit.getId() %>"
                           onclick="return confirm('Supprimer ce produit ?');">Supprimer</a>
                    </td>
                </tr>
            <%
                }
            %>
        </table>
    <%
        } else {
    %>
        <p>Aucun produit disponible.</p>
    <%
        }
    %>
</div>
</body>
</html>
