<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Détails du Produit</title>
     <style>
            body {
                font-family: 'Segoe UI', sans-serif;
                margin: 0;
                padding: 20px;
                background: #f5f7fa;
                color: #166088;
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

                        margin-bottom: 20px;
                    }
                    </style>
</head>
<body>
<div class="container">

    <h1>Détails du Produit</h1>
    <p><strong>ID :</strong> ${produit.id}</p>
    <p><strong>Nom :</strong> ${produit.nom}</p>
    <p><strong>Description :</strong> ${produit.description}</p>
    <p><strong>Prix :</strong> ${produit.prix}</p>
    <p>
        <strong>Image :</strong><br/>
        <img src="${produit.image}" alt="${produit.nom}" width="200"/>
    </p>
    <a href="produits?action=list">Retour à la liste</a>
</div>
</body>
</html>
