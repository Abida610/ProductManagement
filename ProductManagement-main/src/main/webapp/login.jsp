<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <style>
            :root {
                --primary-color: #4a6fa5;
                --secondary-color: #166088;
                --accent-color: #4fc3f7;
                --light-color: #f8f9fa;
                --dark-color: #343a40;
                --error-color: #e74c3c;
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

                    .auth-container {
                        background-color: white;
                        border-radius: 15px;
                        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
                        width: 100%;
                        max-width: 450px;
                        padding: 40px;
                    }
                     h1 {
                                color: var(--secondary-color);
                                text-align: center;
                                margin-bottom: 30px;
                                font-weight: 600;
                            }

                            .form-group {
                                margin-bottom: 20px;
                            }

                            label {
                                display: block;
                                margin-bottom: 8px;
                                color: var(--dark-color);
                                font-weight: 500;
                            }
                            input[type="text"],
                                    input[type="password"] {
                                        width: 100%;
                                        padding: 12px 15px;
                                        border: 1px solid #ddd;
                                        border-radius: 8px;
                                        font-size: 1rem;
                                        transition: border 0.3s;
                                    }
                             .btn {
                                        width: 100%;
                                        padding: 12px;
                                        border-radius: 8px;
                                        font-size: 1rem;
                                        font-weight: 500;
                                        transition: all 0.3s ease;
                                        border: none;
                                        cursor: pointer;
                                        margin-top: 10px;
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

                                    .auth-footer {
                                        text-align: center;
                                        margin-top: 25px;
                                        color: var(--dark-color);
                                    }
                     .error-message {
                                 color: var(--error-color);
                                 text-align: center;
                                 margin-bottom: 20px;
                                 padding: 10px;
                                 background-color: rgba(231, 76, 60, 0.1);
                                 border-radius: 5px;
                             }
                                    </style>

</head>
<body>
<div class="auth-container">
    <h1>Connexion</h1>
   <c:if test="${not empty error}">


            ${error}

        </c:if>

    <form action="<%= request.getContextPath() %>/auth" method="post">
        <div class="form-group">
                        <label for="username">Nom d'utilisateur</label>
                        <input type="text" id="username" name="username" required>
                    </div>
                    <div class="form-group">
                                    <label for="password">Mot de passe</label>
                                    <input type="password" id="password" name="password" required>
                                </div>

                                <button type="submit" class="btn btn-primary">Se connecter</button>
    </form>
     <div class="auth-footer">
    <p>Pas encore inscrit ? <a href="register.jsp">Créer un compte</a></p>
</div>
</div>
</body>
</html>