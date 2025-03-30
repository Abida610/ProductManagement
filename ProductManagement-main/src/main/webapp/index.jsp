
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accueil - Gestion des Produits</title>
    <style>
        :root {
            --primary-color: #4a6fa5;
            --secondary-color: #166088;
            --accent-color: #4fc3f7;
            --light-color: #f8f9fa;
            --dark-color: #343a40;
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }

        .welcome-container {
            background-color: white;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
            padding: 40px;
            text-align: center;

        }



        h1 {
            color: var(--secondary-color);
            margin-bottom: 10px;
            font-weight: 600;
        }

        p.subtitle {
            color: var(--dark-color);
            margin-bottom: 30px;
            font-size: 1.1rem;
        }

        .btn-container {
            display: flex;
            flex-direction: column;
            gap: 15px;
            margin-top: 30px;
        }

        .btn {
            padding: 12px 24px;
            border-radius: 50px;
            font-size: 1rem;
            font-weight: 500;
            text-decoration: none;
            transition: all 0.3s ease;
            border: none;
            cursor: pointer;
        }

        .btn-primary {
            background-color: var(--primary-color);
            color: white;
        }

        .btn-primary:hover {
            background-color: var(--secondary-color);
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        }

        .btn-secondary {
            background-color: white;
            color: var(--primary-color);
            border: 2px solid var(--primary-color);
        }




        footer {
            margin-top: 40px;
            font-size: 0.8rem;
            color: #6c757d;
        }
    </style>
</head>
<body>
    <div class="welcome-container">


        <h1>Bienvenue sur Product Manager</h1>
        <p class="subtitle">Gérez vos produits efficacement avec notre solution complète</p>

        <div class="btn-container">
            <a href="login.jsp" class="btn btn-primary">
                Se connecter
            </a>
            <a href="register.jsp" class="btn btn-secondary">
                Créer un compte
            </a>
        </div>



        <footer>
            © 2025 Product Manager - Tous droits réservés
        </footer>
    </div>
</body>
</html>