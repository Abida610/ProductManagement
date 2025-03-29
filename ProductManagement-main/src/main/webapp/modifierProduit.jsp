<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.Produit" %>
<%
    Produit produit = (Produit) request.getAttribute("produit");
    if (produit == null) {
        produit = new Produit();
    }
%>
<html>
<head>
    <title>Modifier le Produit</title>
    <style>
            body {
                font-family: 'Segoe UI', sans-serif;
                margin: 0;
                padding: 20px;
                background: #f5f7fa;
            }
            .container {
                max-width: 600px;
                margin: 20px auto;
                background: white;
                padding: 30px;
                border-radius: 8px;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            }
            h1 {
                color: #166088;
                margin-bottom: 20px;
            }
            .form-group {
                margin-bottom: 20px;
            }
            label {
                display: block;
                margin-bottom: 8px;
                color: #4a6fa5;
                font-weight: 500;
            }
            </style>
</head>
<body>
<div class="container">

    <h1>Modifier le Produit</h1>

    <form action="produits" method="post">
        <input type="hidden" name="operation" value="update"/>
        <input type="hidden" name="id" value="<%=produit.getId()%>"/>
         <div class="form-group">
            <label>Nom :</label>
            <input type="text" name="nom" value="<%= produit.getNom() %>" required/>
        </div>
         <div class="form-group">
            <label>Description :</label>
            <textarea name="description" required><%= produit.getDescription() != null ? produit.getDescription() : "" %></textarea>
        </div>
         <div class="form-group">
            <label>Prix :</label>
            <input type="number" step="0.01" name="prix" value="<%= produit.getPrix() %>" required/>
        </div>
         <div class="form-group">
            <label>Image (URL) :</label>
            <input type="text" name="image" value="<%= produit.getImage()%>" required/>
        </div>
         <div class="form-group">
            <input type="submit" value="Modifier"/>
        </div>

    </form>
    <a href="produits?action=list">Retour à la liste</a>
 </div>
</body>
</html>
